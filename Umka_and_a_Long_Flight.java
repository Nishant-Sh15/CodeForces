// https://codeforces.com/problemset/problem/1811/D
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Umka_and_a_Long_Flight{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
        long[] f=new long[46];
        f[0]=f[1]=1;
        for(int i=2;i<46;i++){
            f[i]=f[i-1]+f[i-2];    
        }
		int times=sc.nextInt();;
        while(times-->0){
            int n=sc.nextInt();
            long y=sc.nextInt();
            long x=sc.nextInt();

            boolean p=true;
            int i=n;
            long sr=1,er=f[n],s_c=1,ec=f[n+1];
            boolean col=true;
            while(sr!=er && s_c!=ec){
                if(col){
                    if(x>f[i]){
                        x-=f[i];
                        ec-=f[i];
                    }
                    else if(ec-f[i]>=x){
                        ec-=f[i];
                    }
                    else{
                        p=false;
                        break;
                    }
                    col=false;
                }
                else{
                    if(y>f[i]){
                        y-=f[i];
                        er-=f[i];
                    }
                    else if(er-f[i]>=y){
                        er-=f[i];
                    }
                    else{
                        p=false;
                        break;
                    }
                    col=true;
                }
                i--;
            }
            System.out.println(p?"YES":"NO");
        }		
	}
}