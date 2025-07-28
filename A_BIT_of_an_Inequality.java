// https://codeforces.com/problemset/problem/1957/D
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class A_BIT_of_an_Inequality
{
    static Scanner sc=new Scanner(System.in);
    static BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        String d[]; 
 
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int a[][]=new int[33][n];
            int x;
            int ls[]=new int[n];
            for(int i=0;i<n;i++){
                x=sc.nextInt();
                int j=0;
                while(x>0){
                    if(x%2==1){
                        a[j][i]=1;
                    }
                    j++;
                    x/=2;
                }
                ls[i]=j-1;
            }
            int s[][]=new int[33][n],p[][]=new int[33][n];
            int re[][]=new int[33][n];
            int le[][]=new int[33][n];
            for(int b=0;b<33;b++){
                p[b][0]=a[b][0];
                for(int i=1;i<n;i++){
                    p[b][i]=p[b][i-1]+a[b][i];
                }
                int e=0;
                for(int i=n-1;i>-1;i--){
                    re[b][i]=e;
                    if(p[b][i]%2==0){
                        e++;
                    }
                }
                s[b][n-1]=a[b][n-1];
                for(int i=n-2;i>-1;i--){
                    s[b][i]=s[b][i+1]+a[b][i];
                }
                e=0;
                for(int i=0;i<n;i++){
                    le[b][i]=e;
                    if(s[b][i]%2==0){
                        e++;
                    }
                }
            }
            long ans=0;
            long rec,roc,lec,loc;
            for(int y=0;y<n;y++){
                int lb=ls[y];
                if(p[lb][y]%2==0){
                    rec=re[lb][y];
                }
                else{
                    int c=n-y-1;
                    rec=c-re[lb][y];
                }
                if(s[lb][y]%2==0){
                    int c=y;
                    loc=c-le[lb][y];
                }
                else{
                    loc=le[lb][y];
                }
                ans+=(rec+1)*loc;
                roc=(n-y-1)-rec;
                lec=y-loc;
                ans+=roc*(lec+1);
            }
            System.out.println(ans);
        }
        wd.flush();
	}
}