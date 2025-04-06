// https://codeforces.com/problemset/problem/1996/D
import java.util.*;

public class Fun{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            long ans=0;
            int l=Math.min(x-2,n/2);
            int c=0;
            for(int a=1;a<n;a++){
              l=n/a;
                for(int b=1;b<=l;b++){
                    c=Math.max(0,Math.min(x-a-b,(n-a*b)/(a+b)));
                    ans+=c;
                }
            }
            System.out.println(ans);
        }
    }
}