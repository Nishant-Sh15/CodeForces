// https://codeforces.com/problemset/problem/2074/E
import java.util.*;

public class Empty_Triangle{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int i=1,j=2,k=3;
            System.out.println("? "+i+" "+j+" "+k);
            k=sc.nextInt();
            if(k==0){
                System.out.println("! "+i+" "+j+" "+3);
                continue;
            }
            int q=n;
            while(q>0){
                System.out.println("? "+i+" "+j+" "+k);
                q=sc.nextInt();
                System.out.flush();
                if(q!=0){
                    i=j;
                    j=k;
                    k=q;
                }
            }
            System.out.println("! "+i+" "+j+" "+k);
        }
    }
}       