// https://codeforces.com/problemset/problem/1891/C
import java.util.*;

public class Smilo_and_Monsters {
   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			int  i=0,j=n-1;
			long x=0,t;
			long ans=0;
			while(i<j){
				if(x+a[i]>a[j]){
					t=a[i]+x-a[j];
					ans+=a[i]-t;
					a[i]=(int)t;
					ans++;
					a[j]=0;
					x=0;
					j--;
				}
				else{
					x+=a[i];
					ans+=a[i];
					a[i]=0;
					i++;
				}
			}
      		if(i==j && a[j]!=1){
				t=(a[j]-x)/2;
				x+=t;
				a[j]-=t;
				ans+=t;
				ans++;
				a[j]-=x;
				x=0;
			}
			if(a[j]==1){
				ans++;
			}
			System.out.println(ans);
        }
	}
	
}
