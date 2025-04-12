// https://codeforces.com/problemset/problem/1990/C
import java.util.*;

public class Mad_MAD_Sum{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            long s=0,ans=0;
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                s+=a[i];
            }
            ans=s;
            s=0;
            int dp[]=new int[n];
            HashSet<Integer> hs=new HashSet<>();
            hs.add(a[0]);
            int z=0;
            for(int i=1;i<n;i++){
                if(hs.contains(a[i])){
                    if(a[i]>z){
                        z=a[i];;
                    }
                }
                hs.add(a[i]);
                dp[i]=z;
                s+=dp[i];
                // ans+=s;
            }
            ans+=s;
            hs=new HashSet<>();
            z=0;
            s=0;
            for(int i=1;i<n;i++){
                if(hs.contains(dp[i])){
                    if(dp[i]>z){
                        z=dp[i];;
                    }
                }
                hs.add(dp[i]);
                a[i]=z;
                s+=a[i];
                ans+=s;
            }
            System.out.println(ans);
        }
    }
}       