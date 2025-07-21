// https://codeforces.com/contest/1977/problem/C
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Nikita_and_LCM
{
        static long gcd(long a,long b){
            if(a==0){
                return b;
            }
            return gcd(b%a,a);
        }
        public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            long a[]=new long[n];
            HashSet<Long>hs=new HashSet<>();
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                hs.add(a[i]);
            }
            Arrays.sort(a);
            int ans=0;
            int c=0;
            for(int i=0;i<n-1;i++){
                if(a[n-1]%a[i]!=0){
                    c++;
                    break;
                }
            }
            if(c>0){
                System.out.println(n);
                continue;
            }
            ArrayList<Long> f=new ArrayList<>();
            double l=Math.sqrt(a[n-1]);
            f.add(1l);
            for(int i=2;i<=l;i++){
                if(a[n-1]%i==0){
                    f.add((long)i);
                    f.add(a[n-1]/i);
                }
            }
            l=f.size();
            for(int i=0;i<l;i++){
                long t=f.get(i);
                long g=0;
                c=0;
                for(int j=0;j<n;j++){
                    if(t%a[j]==0){
                        c++;
                        if(a[j]!=1){
                            g=a[j];
                        }
                    }
                }
                long lcm=g;
                for(int j=0;j<n;j++){
                    if(a[j]!=1 && t%a[j]==0){
                        g=gcd(lcm,a[j]);
                        lcm=lcm*a[j]/g;
                    }
                }
                if(!hs.contains(lcm) && lcm!=0){
                    ans=Math.max(ans,c);
                }
            }
            System.out.println(ans);
        }
	}
}