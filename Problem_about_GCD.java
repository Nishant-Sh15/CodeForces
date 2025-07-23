// https://codeforces.com/problemset/problem/2043/D
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Problem_about_GCD
{
    static Scanner sc=new Scanner(System.in);
    static BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
    static void solve(long l,long r,long m){
        if(l==r){
            if(l==1){
                System.out.println(m+" "+m);
                return;
            }
        }
        if(l>=r){
            System.out.println("-1 -1");
            return;
        }
        long A=-1,B=-1,d=-1;
        for(long i=l;i<l+30;i++){
            for(long j=r;j>r-30;j--){
                if(i<=j){
                    if(gcd(i,j)==1 && j-i>d){
                        A=i;
                        B=j;
                        d=j-i;
                    }
                }
            }
        }
        System.out.println((A*m)+" "+(B*m));
    }
    static long gcd(long a,long b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    public static void main(String[] args) throws Exception{
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            long l=sc.nextLong();
            long r=sc.nextLong();
            long g=sc.nextLong();
            if(g==1){
                solve(l,r,1);
            }
            else{
                solve(1+(l-1)/g,r/g,g);
            }
        }
	}
}