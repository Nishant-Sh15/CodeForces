// https://codeforces.com/problemset/problem/2104/E
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Unpleasant_Strings

{
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=1;
        while(times-->0){
            d=rd.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int k=Integer.parseInt(d[1]);
            String s=rd.readLine();
            int c[][]=new int[k][n];
            for(int i=0;i<k;i++){
                c[i][n-1]=n;
            }
            for(int i=n-2;i>-1;i--){
                for(int j=0;j<k;j++){
                    c[j][i]=c[j][i+1];
                }
                c[s.charAt(i+1)-'a'][i]=i+1;
            }
            int dp[]=new int[n+1];
            dp[n]=1;
            HashSet<Character> hs=new HashSet<>();
            for(int i=n-1;i>-1;i--){
                dp[i]=dp[i+1];
                if(hs.size()==k){
                    dp[i]++;
                    hs=new HashSet<>();
                }
                hs.add(s.charAt(i));
            }
            int q=Integer.parseInt(rd.readLine());
            while(q-->0){
                String t=rd.readLine();
                int m=t.length();
                int i=0,j=0;
                if(s.charAt(0)==t.charAt(0)){
                    j++;
                }
                while(j<m){
                    i=c[t.charAt(j)-'a'][i];
                    if(i==n){
                        break;
                    }
                    j++;
                }
                if(j<m){
                    System.out.println(0);
                }
                else{
                    
                    System.out.println(dp[i]);
                }
            }
            

            
        }
	}
}