// https://codeforces.com/problemset/problem/1882/C
import java.util.*;

public class Card_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			long s=0;
			if(a[0]>0){
				s+=a[0];
				if(n>1 && a[1]>0){
					s+=a[1];
				}
			}
			else if(n>1 && a[0]+a[1]>0){
				s+=a[0]+a[1];
			}
			for(int i=2;i<n;i++){
				if(a[i]>0){
					s+=a[i];
				}
			}
            System.out.println(s);
        }
	}
	
}
