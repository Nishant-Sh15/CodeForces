// https://codeforces.com/problemset/problem/2023/B
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Skipping
{
    static HashMap<String,Integer>hm;
    static class pair implements Comparable<pair>{
        int c;
        long d;
        pair(int a,long b){
            c=a;
            d=b;
        }
        public int compareTo(pair p){
            return this.d<p.d?-1:1;
        }
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            int n=Integer.parseInt(rd.readLine());
            int []a=new int[n];
            int []b=new int[n];
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(d[i]);
            }
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                b[i]=Integer.parseInt(d[i])-1;
            }
            HashMap<Integer,Integer>tree[]=new HashMap[n];
            // cost=new int[n][n];
            hm=new HashMap<>();
            for(int i=0;i<n;i++){
                tree[i]=new HashMap<>();
            }
            for(int i=1;i<n;i++){
                tree[i].put(i-1,0);
            }
            for(int i=0;i<n;i++){
                if(b[i]>i){
                    tree[i].put(b[i],a[i]);
                }
            }
            long s[]=new long[n];
            for(int i=1;i<n;i++){
                s[i]=10000000000000000l;
            }
            PriorityQueue<pair> pq=new PriorityQueue<>();
            pq.add(new pair(0,0));
            boolean vis[]=new boolean[n];
            while(!pq.isEmpty()){
                pair p=pq.remove();
                if(!vis[p.c]){
                    vis[p.c]=true;
                    for(int i:tree[p.c].keySet()){
                        long t=s[p.c]+tree[p.c].get(i);
                        if(t<s[i]){
                            s[i]=t;
                            pq.add(new pair(i,t));
                        }
                    }
                }
            }
            long p[]=new long[n];
            p[0]=a[0];
            for(int i=1;i<n;i++){
                p[i]=p[i-1]+a[i];
            }
            long ans=a[0];
            for(int i=1;i<n;i++){
                ans=Math.max(ans,p[i]-s[i]);
            }
            System.out.println(ans);
        }
	}
}