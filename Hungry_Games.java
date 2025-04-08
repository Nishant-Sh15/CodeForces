// https://codeforces.com/problemset/problem/1994/C
import java.util.*;

public class Hungry_Games{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            int []a=new int[n+2];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int i=0,j=0;
            long s=0;
            int p[]=new int[n+2];
            while(i<n){
                while(s<=x && j<n+1){
                    s+=a[j];
                    j++;
                }
                p[i]=j;
                s-=a[i];
                i++;
            }
            long ind[]=new long[n+2];
            for(i=n-1;i>=0;i--){
                ind[i]=p[i]-i-1;
                ind[i]+=ind[p[i]];
            }
            long ans=0;
            for(i=0;i<n;i++){
                ans+=ind[i];
            }
            System.out.println(ans);
            
        }
    }
}       