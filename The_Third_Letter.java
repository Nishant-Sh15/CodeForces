// https://codeforces.com/problemset/problem/1850/H
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class The_Third_Letter{
    static HashMap<Integer,Long> hm[];
    static long pos[];
    static boolean vis[];
    static void dfs(int c,int p){
        vis[c]=true;
        for(int i:hm[c].keySet()){
            pos[i]=hm[c].get(i)+pos[c];
            if(!vis[i]){
                dfs(i,c);
            }
        }
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String s[];
		int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            s=rd.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            // int n=sc.nextInt();
            hm=new HashMap[n+1];
            pos=new long[n+1];
            vis=new boolean[n+1];
            for(int i=1;i<=n;i++){
                hm[i]=new HashMap<>();
            }
            // int m=sc.nextInt();
            int m=Integer.parseInt(s[1]);
            int a[]=new int[m];
            int b[]=new int[m];
            long d[]=new long[m];
            for(int i=0;i<m;i++){
                s=rd.readLine().split(" ");
                a[i]=Integer.parseInt(s[0]);
                b[i]=Integer.parseInt(s[1]);
                d[i]=Integer.parseInt(s[2]);
                // b[i]=sc.nextInt();
                // d[i]=sc.nextInt();
                hm[b[i]].put(a[i],d[i]);
                hm[a[i]].put(b[i],-d[i]);
            }
            for(int i=1;i<=n;i++){
                if(!vis[i]){
                    dfs(i,0);
                }
            }
            boolean p=true;
            for(int i=0;i<m;i++){
                if(pos[a[i]]!=pos[b[i]]+d[i]){
                    p=false;
                    break;
                }
            }
            System.out.println(p?"YES":"NO");
        }		
	}
}