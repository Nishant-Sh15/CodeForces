// https://codeforces.com/problemset/problem/1814/B
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Long_Legs{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		int times=sc.nextInt();
        while(times-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long ans=Integer.MAX_VALUE;
            double limit=Math.sqrt(2*(Math.max(a,b)));
            for(int k=1;k<=limit+1;k++){
                ans=Math.min(ans,(a+k-1)/k +(b+k-1)/k +k-1);
            }
            System.out.println(ans);

            
        }		
	}
}