// https://codeforces.com/contest/1955/problem/F
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Unfair_Game
{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        // String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            int n[]=new int[5];
            int x=0;
            for(int i=1;i<=4;i++){
                n[i]=sc.nextInt();
                if(n[i]%2==1){
                    x=x^i;
                }
            }
            if(x>=4){
                n[4]--;
                x=x^4;
            }
            if(x!=0){
                if(n[x]!=0){
                    n[x]--;
                }
                else{
                    if(x==3){
                        n[2]--;
                        n[1]--;
                    }
                    else if(x==1){
                        n[3]--;
                        n[2]--;
                    }
                    else{
                        n[3]--;
                        n[1]--;
                    }
                }
            }
            int t[]=new int[5];
            for(int i=1;i<5;i++){
                t[i]=t[i-1]+n[i];
            }
            int ans=0;
            if(t[4]==0){
                System.out.println(0);
                continue;
            }
            ans=1;
            if(t[3]==0){
                ans+=(n[4]-1)/2 ;
            }
            else{
                ans+=n[4]/2;
            }
            if(n[3]%2==0){
                if(t[2]==0){
                    ans+=(n[3]-1)/2 ;
                }
                else{
                    ans+=n[3]/2;
                }
                if(t[1]==0){
                    ans+=(n[2]-1)/2 ;
                }
                else{
                    ans+=n[2]/2;
                }
                ans+=(n[1]-1)/2 ;
            }
            else{
                ans+=(n[3]-1)/2;
                ans+=(n[2]-1)/2;
                ans+=(n[1]-1)/2;
            }
            System.out.println(ans);
            
        }
	}
}