// https://codeforces.com/problemset/problem/1829/H
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Dont_Blame_Me{
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
        long m=(long)(1e9)+7;
		int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            long dp[][]=new long[n][64];
            dp[0][a[0]]=1;
            for(int i=1;i<n;i++){
                
                for(int j=0;j<64;j++){
                    dp[i][j]=dp[i-1][j];
                }

                for(int j=0;j<64;j++){
                    dp[i][a[i]&j]=(dp[i][a[i]&j]+dp[i-1][j])%m;
                }

                dp[i][a[i]]=(dp[i][a[i]]+1)%m;
            }
            int c,t;
            long ans=0;
            for(int j=0;j<64;j++){
                t=j;
                c=0;
                while(t>0){
                    if(t%2==1){
                        c++;
                    }
                    t=t/2;
                }
                if(c==k){
                    ans=(ans+dp[n-1][j])%m;
                }
            }
            System.out.println(ans);
        }		
	}
}