// https://codeforces.com/problemset/problem/2121/G
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Gangsta
{
    static Scanner sc=new Scanner(System.in);
    static BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            long n=sc.nextInt();
            char[] s=sc.next().toCharArray();
            long p[]=new long[(int)n+1];
            p[0]=0;
            for(int i=1;i<=n;i++){
                p[i]=p[i-1];
                if(s[i-1]=='0'){
                    p[i]--;
                }
                else{
                    p[i]++;
                }
            }
            Arrays.sort(p);
            long ans=n;
            long t=0;
            for(int i=2;i<=n;i++){
                ans+=i*(n-(i-1));
            }
            t=p[0];
            for(int i=1;i<=n;i++){
                ans+=i*p[i] -t;
                t+=p[i];
            }
            System.out.println(ans/2);
        }
        wd.flush();
	}
}