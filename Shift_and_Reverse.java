// https://codeforces.com/problemset/problem/1907/F
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Shift_and_Reverse

{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int a[]=new int[2*n+1];
            for(int i=1;i<=n;i++){
                a[i]=a[i+n]=sc.nextInt();
            }
            int inc=Integer.MAX_VALUE,dec=Integer.MAX_VALUE;
            int t=1;
            for(int i=1;i<2*n;i++){
                if(a[i]<=a[i+1]){
                    t++;
                }
                else{
                    t=1;
                }
                if(t>=n){
                    inc=Math.min(inc,Math.min(2*n-(i+1),i+1-n+2));
                }
            }
            t=1;
            for(int i=1;i<2*n;i++){
                if(a[i]>=a[i+1]){
                    t++;
                }
                else{
                    t=1;
                }
                if(t>=n){
                    dec=Math.min(dec,Math.min(2*n-(i+1)+1,i+1-n+1));
                }
            }
            if(inc==dec && dec==Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(Math.min(inc,dec));
            }

        }
	}
}