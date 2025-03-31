// https://codeforces.com/problemset/problem/2075/C
import java.util.*;

public class Two_Colors{
    static int search(int[] a,int t,int s,int e){
        if(s>e)
            return s;
        int m=(s+e)/2;
        if(m!=0){
            if(a[m]>=t){
                if(a[m-1]<t)
                    return m;
                return search(a,t,s,m-1);
            }
        }else{
            if(a[m]>=t){
                return m;
            }
        }
        return search(a,t,m+1,e);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[m];
            for(int i=0;i<m;i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            long lc=0,rc=0;
            int l=1,r=0;
            long ans=0;
            for(int i=0;i<(n-1)/2;i++,l++){
                r=n-l;
                lc=m-search(a,l,0,m-1);
                rc=m-search(a,r,0,m-1);
                ans+=lc*rc -Math.min(lc,rc);
            }
            ans*=2;
            if(n%2==0){
                r=n-l;
                lc=m-search(a,l,0,m-1);
                ans+=lc*lc -lc;
            }
            System.out.println(ans);
        }
    }
}