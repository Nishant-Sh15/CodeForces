// https://codeforces.com/problemset/problem/2112/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Reachability_and_Tree
{
    static HashSet<Integer>[] tree;
    static void rec(int c,int p,int d){
        for(int i:tree[c]){
            if(i!=p){
                if(d==1){
                    System.out.println(i+" "+c);
                    rec(i,c,0);
                }
                else{
                    System.out.println(c+" "+i);
                    rec(i,c,1);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        
		int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            int n=Integer.parseInt(rd.readLine());
            tree=new HashSet[n+1];
            for(int i=0;i<=n;i++){
                tree[i]=new HashSet<>();
            }
            int a,b;
            int d[]=new int[n+1];
            for(int i=1;i<n;i++){
                s=rd.readLine().split(" ");
                a=Integer.parseInt(s[0]);
                b=Integer.parseInt(s[1]);
                
                d[a]++;
                d[b]++;
                tree[a].add(b);
                tree[b].add(a);
            }
            boolean p=false;
            for(int i=1;i<=n;i++){
                if(d[i]==2){
                    System.out.println("YES");
                    p=true;
                    int c=0;
                    for(int j:tree[i]){
                        if(c<1){
                            c++;
                            System.out.println(i+" "+j);
                            rec(j,i,1);
                        }
                        else{
                            System.out.println(j+" "+i);
                            rec(j,i,0);
                        }
                    }
                    break;
                }
            }
            if(!p){
                System.out.println("NO");
            }
            
        }
	}
}