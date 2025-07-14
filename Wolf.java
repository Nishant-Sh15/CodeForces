// https://codeforces.com/problemset/problem/2106/E
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Wolf

{
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            d=rd.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int q=Integer.parseInt(d[1]);
            int a[]=new int[n+1];
            int po[]=new int[n+1];
            d=rd.readLine().split(" ");
            for(int i=1;i<=n;i++){
                a[i]=Integer.parseInt(d[i-1]);
                po[a[i]]=i;
            }
            while(q-->0){
                d=rd.readLine().split(" ");
                int l=Integer.parseInt(d[0]);
                int r=Integer.parseInt(d[1]);
                int k=Integer.parseInt(d[2]);
                int indx=po[k];
                if(indx<l || indx>r){
                    System.out.print("-1 ");
                }
                else{
                    boolean p=true;
                    int s=0,b=0,ss=0,bb=0;
                    int m;
                    while(l<r){
                        m=(l+r)/2;
                        if(m==indx){
                            break;
                        }
                        if(m<indx){
                            if(a[m]>k){
                                s++;
                            }
                            else{
                                ss++;
                            }
                            l=m+1;
                        }
                        else{
                            if(a[m]<k){
                                b++;
                            }
                            else{
                                bb++;
                            }
                            r=m-1;
                        }
                    }
                    if(s+ss>k-1 || b+bb>n-k){
                        System.out.print("-1 ");
                    }
                    else{
                        System.out.print((Math.min(s,b)*2 +(Math.max(s,b)-Math.min(s,b))*2)+" ");
                    }
                }
            }
            System.out.println();
            
        }
	}
}