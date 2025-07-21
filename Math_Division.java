// https://codeforces.com/problemset/problem/2081/A
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Math_Division
{
    static long m=1000000007;
    static long p(long n){
        long ans=1;
        long t=m-m/2;
        while(n>0){
            if(n%2==1){
                ans=(ans*t)%m;
            }
            t=(t*t)%m;
            n/=2;
        }   
        return ans;
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            char[] s=sc.next().toCharArray();
            long dp[][]=new long[n][2];
            dp[n-1][s[n-1]-'0']++;
            for(int i=n-2;i>-1;i--){
                if(s[i]=='1'){
                    if(s[i+1]=='1'){
                        dp[i][0]=(2*dp[i+1][0]+dp[i+1][1])%m;
                        dp[i][1]=dp[i+1][1]%m;
                    }
                    else{
                        dp[i][0]=dp[i+1][1]%m;
                        dp[i][1]=(2*dp[i+1][0]+dp[i+1][1])%m;
                    }
                }
                else{
                    if(s[i+1]=='1'){
                        dp[i][1]=(2*dp[i+1][0]+dp[i+1][1])%m;
                        dp[i][0]=dp[i+1][1];
                    }
                    else{
                        dp[i][0]=(2*dp[i+1][0]+dp[i+1][1])%m;
                        dp[i][1]=dp[i+1][1];
                    }
                }
            }
            long pn_1=p(n-1)*(n-1)%m;
            long pn=p(n)*n%m;
            long nop=pn*(2*dp[0][0]%m)%m;
            long n_1op=pn_1*dp[0][1]%m;
            long ans=(nop+n_1op)%m;
            System.out.println(ans);
        }
	}
}