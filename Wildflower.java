// https://codeforces.com/problemset/problem/2117/F
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Wildflower

{
    static long m=1000000007l;
    static HashSet<Integer> tree[];
    static HashSet<Integer> hs=new HashSet<>();
    static int c=0;
    static int v=0;
    static int dp[];
    static void  dfs(int cu,int p){
        if(tree[cu].size()==1 && cu!=1){
            c++;
            hs.add(cu);
            dp[cu]=dp[p]+1;
            return;
        }
        if(tree[cu].size()==3 ||(cu==1 && tree[1].size()==2)){
            v=cu;
        }
        dp[cu]=dp[p]+1;
        for(int i:tree[cu]){
            if(i!=p){
                dfs(i,cu);
            }
        }
    }
    static long md(int a){
        long ans=1;
        long t=2;
        while(a>0){
            if(a%2==1){
                ans=(ans*t)%m;
            }
            t=(t*t)%m;
            a/=2;
        }
        return ans;
    }
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            int n=Integer.parseInt(rd.readLine());
            tree=new HashSet[n+1];
            for(int i=1;i<=n;i++){
                tree[i]=new HashSet<>();
            }
            int a,b;
            for(int i=1;i<n;i++){
                d=rd.readLine().split(" ");
                a=Integer.parseInt(d[0]);
                b=Integer.parseInt(d[1]);
                tree[a].add(b);
                tree[b].add(a);
            }
            v=c=0;
            dp=new int[n+1];
            hs=new HashSet<>();
            dfs(1,0);
            if(c>2){
                System.out.println(0);
                continue;
            }
            else{
                if(c==1){
                    System.out.println(md(n));
                    continue;
                }
                int l[]=new int[2];
                int i=0;
                for(int j:hs){
                    l[i++]=j;
                }
                long vv=md(dp[v]);
                if(dp[l[0]]==dp[l[1]]){
                    System.out.println((2*vv)%m);
                }
                else{
                    long l1=md(Math.abs(dp[l[0]]-dp[l[1]]));
                    long l2=md(Math.abs(dp[l[0]]-dp[l[1]])-1);
                    long ans=(((l1+l2)%m)*vv)%m;
                    System.out.println(ans);
                }
            }

            
        }
	}
}