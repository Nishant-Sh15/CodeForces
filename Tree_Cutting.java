// https://codeforces.com/problemset/problem/1946/C
import java.util.*;

public class Tree_Cutting {
    static int x=0,num=0;
    static int []nodes;
    static ArrayList<Integer>[] tree;
    static void fill(int c,int p){
        nodes[c]=1;
        for(int i:tree[c]){
            if(i!=p){
                fill(i,c);
                nodes[c]+=nodes[i];
            }
        }
    }
    static int check(int curr,int par){
        if(nodes[curr]<x){
            return 0;
        }
        else if(nodes[curr]==x){
            num++;
            return x;
        }
        int sum=0;
        for(int i:tree[curr]){
            if(i!=par){
                sum+=check(i,curr);
            }
        }
        if(nodes[curr]-sum>=x){
            num++;
            return nodes[curr];
        }
        else{
            return sum;
        }

    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            tree=new ArrayList[n];
            for(int i=0;i<n;i++){
                tree[i]=new ArrayList<>();
            }
            int a,b;
            for(int i=1;i<n;i++){
                a=sc.nextInt()-1;
                b=sc.nextInt()-1;
                tree[a].add(b);
                tree[b].add(a);
            }
            nodes=new int[n];
            fill(0,0);
            int l=1,r=(n+k)/(k+1);
            int ans=1;
            while(l<=r){
                x=(l+r)/2;
                num=0;
                check(0,0);
                if(num>=k+1){
                    ans=x;
                    l=x+1;
                }else{
                    r=x-1;
                }
            }
            System.out.println(ans);
            
        }
	}
	
}

