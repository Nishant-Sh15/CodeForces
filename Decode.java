// https://codeforces.com/problemset/problem/1996/E
import java.util.*;

public class Decode{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=sc.nextInt();
        long m=(long)1e9;
        m=m+7;
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            HashMap<Integer,Long> hm=new HashMap<>();
            long temp=1;
            hm.put(0,1l);
            int cnt=0;
            long ans=0;
            for(int i=1;i<=n;i++){
                if(s.charAt(i-1)=='0')  cnt--;
                else    cnt++;
                temp=hm.getOrDefault(cnt,0l);
                ans=(ans+temp*(n-i+1))%m;
                temp+=i+1;
                hm.put(cnt,temp);
            }
            System.out.println(ans%m);
        }
    }
}