// https://codeforces.com/problemset/problem/2093/G
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Shorten_the_Array
{
    static Scanner sc=new Scanner(System.in);
    static BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int size=10000000;
    static int k_bin[]=new int[31];
    static int trie[][]=new int[2][size];
    static int min_j[]=new int[size];
    static int a[]=new int[200001];
    static int n,k;
    static int ans;
    static int lst;
    static int c;
    static int i,t,b,bm,eq,gr,j;
    public static void main(String[] args) throws Exception{
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            n=sc.nextInt();
            k=sc.nextInt();
            for(int i=1;i<=n;i++){
                a[i]=sc.nextInt();
            }
            if(k==0){
                System.out.println(1);
                continue;
            }
            ans=n+10;
            j=0;
            t=k;
            trie[0][1]=trie[1][1]=0;
            lst=1;
            while(j<31){
                k_bin[j++]=t%2;
                t/=2;
            }
            for(i=n-1;i>0;i--){
                c=1;
                for(bm=1<<30;bm>0;bm/=2){
                    b=(a[i+1]&bm)==0?0:1;
                    if(trie[b][c]==0){
                        trie[b][c]=++lst;
                        trie[0][lst]=trie[1][lst]=0;
                    }
                    c=trie[b][c];
                    min_j[c]=i+1;
                }
                c=1;
                bm=1<<30;
                for(j=30;j>=0;j--){
                    b=(a[i]&bm)==0?0:1;
                    eq=(b^k_bin[j]);
                    if(k_bin[j]==0){
                        gr=eq^1;
                        if(trie[gr][c]!=0){
                            ans=Math.min(ans,min_j[trie[gr][c]]-i+1);
                        }
                    }
                    if(j==0 && trie[eq][c]!=0){
                        ans=Math.min(ans,min_j[trie[eq][c]]-i+1);
                    }
                    if(trie[eq][c]==0){
                        break;
                    }
                    bm/=2;
                    c=trie[eq][c];
                }

            }
            System.out.println(ans>n?-1:ans);
        }
        wd.flush();
	}
}