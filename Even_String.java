// https://codeforces.com/problemset/problem/2086/D
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Even_String
{
    static int m=998244353;
    static long p(long a){
        long ans=1;
        long x=m-2;
        long t=a;
        while(x>0){
            if(x%2==1){
                ans=(ans*t)%m;
            }
            t=(t*t)%m;
            x/=2;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        long f[]=new long[500001];
        f[0]=1;
        for(int i=1;i<=500000;i++){
            f[i]=(f[i-1]*i)%m;
        }
        long inf[]=new long[500001];
        inf[500000]=p(f[500000]);
        for(int i=500000;i>0;i--){
            inf[i-1]=(inf[i]*i)%m;
        }
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            d=rd.readLine().split(" ");
            long a[]=new long[26];
            for(int i=0;i<26;i++){
                a[i]=Integer.parseInt(d[i]);
            }
            long n=0;
            for(int i=0;i<26;i++){
                n+=a[i];
            }
            long e=n/2,o=n-e;
            long w[]=new long[(int)e+1];
            w[0]=1;
            for(int i=0;i<26;i++){
                if(a[i]!=0){
                    for(int j=(int)e;j>=a[i];j--){
                        w[j]=(w[j]+w[j-(int)a[i]])%m;
                    }
                }
            }
            long ans=w[(int)e];
            ans=(ans*f[(int)e])%m;
            ans=(ans*f[(int)o])%m;
            for(int i=0;i<26;i++){
                ans=(ans*inf[(int)a[i]])%m;
            }
            wd.write(ans+"\n");
        }
        wd.flush();
	}
}