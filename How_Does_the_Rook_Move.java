// https://codeforces.com/problemset/problem/1957/C
import java.util.*;

public class How_Does_the_Rook_Move {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<k;i++){
                hs.add(sc.nextInt());
                hs.add(sc.nextInt());
            }
            long dp[]=new long[n-hs.size()+1];
            dp[0]=1;
            if(dp.length>1)
                dp[1]=1;
            long m=(long)1e9 +7;
            for(int i=2;i<dp.length;i++){
                dp[i]=((2*(i-1)*dp[i-2])%m +dp[i-1])%m;
            }
            System.out.println(dp[dp.length-1]);
            
        }
	}
	
}

