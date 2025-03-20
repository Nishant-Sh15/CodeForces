// https://codeforces.com/problemset/problem/2074/D
import java.util.*;

public class Counting_Points
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            long x[]=new long[n];
            long r[]=new long[n];
            for(int i=0;i<n;i++){
                x[i]=sc.nextLong();
            }
            for(int i=0;i<n;i++){
                r[i]=sc.nextLong();
            }
            long a=0;
            HashMap<Long,Long>hm=new HashMap<>();
            for(int i=0;i<n;i++){
                for(long j=x[i]-r[i];j<=x[i]+r[i];j++){
                    a=(long)Math.pow(r[i]*r[i] - Math.pow(j-x[i],2),0.5);
                    hm.put(j,Math.max(hm.getOrDefault(j,0l),2*a+1));
                }
            }
            long nop=0;
            for(long i:hm.keySet()){
                nop+=hm.get(i);
            }
            System.out.println(nop);
        }
    }
    
}