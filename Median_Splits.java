// https://codeforces.com/problemset/problem/2103/C
import java.util.*;

public class Median_Splits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			int i,j;
			int c=0;
			int e1=-1,e2=-1,s3=-1,s2=-1;
			for( i=0;i<n-2;i++){
				if(a[i]<=k){
					c++;
				}
				if(c>=(i+2)/2){
					if((i+1)%2==1 && i<n-3 && a[i+1]>k){
						i++;
					}
					e1=i;
					break;
				}
			}
			c=0;
			for(j=i+1;j<n-1;j++){
				if(a[j]<=k){
					c++;
				}
				if(c>=(j-i+1)/2){
					if((j-i)%2==1 && j+1<n-1 && a[j+1]>k){
						j++;
					}
					e2=j;
					break;
				}
			}
			c=0;
			for(i=n-1;i>=2;i--){
				if(a[i]<=k){
					c++;
				}
				if(c>=(n-i+1)/2){
					if((n-i)%2==1 && i>2 && a[i-1]>k){
						i--;
					}
					s3=i;
					break;
				}
			}
			c=0;
			for(j=i-1;j>0;j--){
				if(a[j]<=k){
					c++;
				}
				if(c>=(i-j+1)/2){
					if((i-j)%2==1 && j>1 && a[j-1]>k ){
						j--;
					}
					s2=j;
					break;
				}
			}
			boolean f12=false;
			if(e1!=-1 && e2!=-1){
				f12=true;
			}
			boolean f23=false;
			if(s3!=-1 && s2!=-1){
				f23=true;
			}
			if(e1!=-1 && a[e1]>k){
				e1--;
			}
			if(s3!=-1 && a[s3]>k){
				s3++;
			}
			boolean f13=false;
			if(e1!=-1 && s3!=-1 && e1<s3-1){
				f13=true;
			}
			System.out.println((f12 || f23 || f13 )?"YES":"NO");
        }
	}
	
}
