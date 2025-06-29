// https://codeforces.com/problemset/problem/1849/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Array_Painting{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		// int times=sc.nextInt();
        // while(times-->0){
            int n=sc.nextInt();
            int a[]=new int[n+1];
            for(int i=1;i<=n;i++){
                a[i]=sc.nextInt();
            }
            boolean red[]=new boolean[n+2];
            red[0]=true;
            int l=0,r=0,c;
            int ans=0;
            while(l<=n){
                if(red[l]){
                    l++;
                }
                c=0;
                while(l<=n && a[l]==0){
                    c++;
                    ans++;
                    l++;
                }
                if(l==n+1){
                    break;
                }
                if(c!=0){
                    ans--;
                }
                r=l;
                l--;
                int boundary=1;
                while(r<=n && a[r]!=0){
                    if(a[r]==2){
                        boundary++;
                    }
                    r++;
                }
                if(!red[l]){
                    red[l]=true;
                    boundary--;
                }
                ans++;
                if(boundary>0){
                    red[r]=true;
                }
                l=r;
            }

            System.out.println(ans);
        // }		
	}
}