// https://codeforces.com/problemset/problem/2008/F
import java.util.*;

public class Sakurako_s_Box{
    static Scanner sc=new Scanner(System.in);
    static long exp(long a,long n,long m){
        long res=1;
        while(n>0){
            if(n%2==1){
                res=(res*a)%m;
            }
            a=(a*a)%m;
            n=n/2;
        }
        return res;
    }
    public static void main(String[] args){
        int t=sc.nextInt();
        long m=(long)1e9;
        m=m+7;
        while(t-->0){
            long n=sc.nextLong();
            long sum=0;
            long A=0;
            int x;
            for(int i=0;i<n;i++){
                x=sc.nextInt();
                A=(A+x*sum)%m;
                sum=(sum+x)%m;
            }
            long B=((n*(n-1))/2)%m;
            B=exp(B,m-2,m);
            System.out.println((A*B)%m);
        }
    }
}       