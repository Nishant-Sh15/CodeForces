// https://codeforces.com/contest/2090/problem/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Simple_Permutation{
    static boolean isPrime(int a){
        if(a==0 || a==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int x=n/3;
            while(!isPrime(x)){
                x++;
            }
            int a[]=new int[n];
            a[0]=x;
            int l=x-1;
            int r=x+1;
            int i=1;
            while(i<n){
                if(i%2==1){
                    a[i++]=l--;
                }
                else{
                    a[i++]=r++;
                }
                if(l==0 || r==n+1){
                    break;
                }
            }
            if(l==0){
                while(i<n){
                    a[i++]=r++;
                }
            }
            else{
                while(i<n){
                    a[i++]=l--;
                }
            }
            for(i=0;i<n;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();            
        }		
	}
}