// https://codeforces.com/problemset/problem/2053/D
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Refined_Product_Optimality
{
    static long m=998244353;
    static long a[];
    static long b[];
    static long A[];
    static long B[];
    static long ans;
    static HashMap<Long,Integer> ha;
    static HashMap<Long,Integer> hb;
    static long p(long a){
        long x=m-2;
        long ans=1;
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
    static void solve(int x,long[] A,long[]B,long[]a,long[]b,HashMap<Long,Integer>hm){
        long v=a[x];
        int i=hm.get(v);
        if(A[i]<B[i]){
            long f=p(v);
            ans=(ans*f)%m;
            ans=(ans*(v+1))%m;
        }
        if(i!=a.length-1){
            if(A[i+1]!=A[i]+1){
                hm.put(v+1,i);
            }
        }
        else{
            hm.put(v+1,i);
        }
        if(i!=0){
            if(A[i-1]==A[i]){
                hm.put(v,i-1);
            }
            else{
                hm.remove(v);
            }
        }
        else{
            hm.remove(v);
        }
        A[i]++;
        a[x]++;
    }
 

    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        
        while(times-->0){
            d=rd.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int q=Integer.parseInt(d[1]);
            a=new long[n];
            b=new long[n];
            A=new long[n];
            B=new long[n];
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                A[i]=a[i]=Integer.parseInt(d[i]);
            }
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                B[i]=b[i]=Integer.parseInt(d[i]);
            }
            Arrays.sort(A);
            Arrays.sort(B);
            ha=new HashMap<>();
            hb=new HashMap<>();
            ans=1;
            for(int i=0;i<n;i++){
                ans=(ans*Math.min(A[i],B[i]))%m;
                ha.put(A[i],i);
                hb.put(B[i],i);
            }
            // System.out.print(ans+" ");
            wd.write(ans+" ");
            while(q-->0){
                d=rd.readLine().split(" ");
                int o=Integer.parseInt(d[0]);
                int x=Integer.parseInt(d[1])-1;
                if(o==1){
                    solve(x,A,B,a,b,ha);
                }
                else{
                    solve(x,B,A,b,a,hb);
                }
                wd.write(ans+" ");
                // System.out.print(ans+" ");
            }
            // System.out.println();
            wd.write("\n");
        }
        wd.flush();
	}
}