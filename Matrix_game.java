// https://codeforces.com/problemset/problem/2120/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Matrix_game

{
    static long m=1000000007l;
    
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        long inv[]=new long[100001];
        inv[1]=1;
        for(int i=2;i<=100000;i++){
            inv[i]=((m-m/i)*inv[(int)m%i])%m;
        }
        int times=sc.nextInt();
        while(times-->0){
            long a=sc.nextInt();
            long b=sc.nextInt();
            long k=sc.nextInt();
            long n=((a-1)*k)+1;
            long ans=((b-1)*k)%m;
            for(int i=1;i<=a;i++){
                ans=(((ans*((n-i+1)%m))%m)*inv[i])%m;
            }
            ans=(ans+1)%m;
            System.out.println(n%m +" "+ans);

            
        }
	}
}