// https://codeforces.com/problemset/problem/2000/E
import java.util.*;

public class Photoshoot_for_Gorillas{
    public static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            int l=sc.nextInt();
            Integer[] a=new Integer[l];
            for(int i=0;i<l;i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a,Collections.reverseOrder());
            int r[]=new int[n+1];
            r[1]=1;
            for(int i=2;i<=n;i++){
                r[i]=r[i-1];
                if(i-k>0){
                    r[i]-=1;
                }
                if(i+k-1<=n){
                    r[i]+=1;
                }
            }
            int c[]=new int[m+1];
            c[1]=1;
            for(int i=2;i<=m;i++){
                c[i]=c[i-1];
                if(i-k>0){
                    c[i]-=1;
                }
                if(i+k-1<=m){
                    c[i]+=1;
                }
            }
            TreeMap<Long,Long>hm=new TreeMap<>(Comparator.reverseOrder());
            long row,col,ans=0,sum=0;
            for(int i=1;i<=n;i++){
                row=r[i];
                for(int j=1;j<=m;j++){
                    col=c[j];
                    hm.put(row*col,hm.getOrDefault(row*col, 0l)+1);
                }
            }
            int i=0;
            for(long j:hm.keySet()){
              long lim=i+hm.get(j);
                for(i=i;(long)i<lim && i<l;i++){
                    sum+=a[i];
                }
                ans+=sum*j;
                sum=0;
            }
            System.out.println(ans);
        }
    }
}