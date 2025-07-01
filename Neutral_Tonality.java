// https://codeforces.com/problemset/problem/1893/B
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Neutral_Tonality{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            int c[]=new int[n+m];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]=sc.nextInt();
            }
            Arrays.sort(b);
            int i=0,j=m-1,k=0;
            while(i<n && j>=0){
                if(a[i]>=b[j]){
                    c[k++]=a[i++];
                }
                else{
                    c[k++]=b[j--];
                }
            }
            while(j>=0){
                c[k++]=b[j--];
            }
            while(i<n){
                c[k++]=a[i++];
            }
            for(i=0;i<k;i++){
                System.out.print(c[i]+" ");
            }
            System.out.println();
        }		
	}
}