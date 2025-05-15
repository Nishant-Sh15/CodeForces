// https://codeforces.com/problemset/problem/1920/C
import java.util.*;

public class Partitioning_the_Array {
   public static int gcd(int a,int b){
		if(a==0){
			return b;
		}
		return gcd(b%a,a);
   }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			int score=1;
			for(int p=2;p<=n;p++){
				if(n%p==0){
					int c=n/p;
					int m=0;
					// 	--------finding gcd-------
					for(int i=0;i+c<n;i++){
						m=gcd(m,Math.abs(a[i]-a[i+c]));
					}
					// ---------check condition------
					if(m!=1){
						score++;
					}
				}
			}
			System.out.println(score);
            
        }
	}
	
}
