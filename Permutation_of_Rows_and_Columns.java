// https://codeforces.com/problemset/problem/1980/E
import java.util.*;

public class Permutation_of_Rows_and_Columns {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            int r[]=new int[n*m+1];
            int c[]=new int[n*m+1];
            int x;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    x=sc.nextInt();
                    r[x]=i;
                    c[x]=j;
                }
            }
            boolean fr=true,fc=true;
            int tr,tc;
            for(int i=0;i<n && fr;i++){
                tr=r[a[i][0]];
                for(int j=1;j<m;j++){
                    if(tr!=r[a[i][j]]){
                        fr=false;
                        break;
                    }
                }
            }
            for(int j=0;j<m;j++){
                tc=c[a[0][j]];
                for(int i=1;i<n;i++){
                    if(tc!=c[a[i][j]]){
                        fc=false;
                        break;
                    }
                }
            }
            if(fr && fc){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
	}
	
}
