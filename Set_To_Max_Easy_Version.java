// https://codeforces.com/problemset/problem/1904/D1
import java.util.*;

public class Set_To_Max_Easy_Version
 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++){
				b[i]=sc.nextInt();
			}
			boolean f=true;
			for(int i=0;i<n;i++){
				if(a[i]>b[i]){
					f=false;
					break;
				}	
				else if(a[i]<b[i]){
					boolean t=true;
					int j;
					for( j=i+1;j<n;j++){
						if(a[j]>b[i] || b[j]<b[i]){
							t=false;
							break;
						}
						if(a[j]==b[i]){
							break;
						}
					}
					if(t && j<n){
						continue;
					}
					t=true;
					for(j=i-1;j>=0;j--){
						if(a[j]>b[i] || b[j]<b[i]){
							t=false;
							break;
						}
						if(a[j]==b[i]){
							break;
						}
					}
					if(!t || j<0){
						f=false;
						break;
					}
				}
			}
			System.out.println(f?"YES":"NO");
        }
	}
	
}
