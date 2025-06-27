// https://codeforces.com/problemset/problem/1826/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Running_Miles{
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int p[]=new int[n];
            int s[]=new int[n];
            p[0]=a[0];
            s[n-1]=a[n-1]-(n-1);
            for(int i=1;i<n;i++){
                p[i]=Math.max(p[i-1],a[i]+i);
            }
            for(int i=n-2;i>=0;i--){
                s[i]=Math.max(s[i+1],a[i]-i);
            }
            int ans=0;
            for(int m=1;m<n-1;m++){
                ans=Math.max(ans,a[m]+p[m-1]+s[m+1]);
            }
            System.out.println(ans);
        }		
	}
}