// https://codeforces.com/problemset/problem/1850/G
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class The_Morning_Star
{
    static long add(HashMap<Long,Long> hm){
        long ans=0;
        for(long i:hm.keySet()){
            long k=hm.get(i);
            ans+=k*(k-1);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[];
		int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            int n=Integer.parseInt(rd.readLine());
            long x,y;
            long ans=0,t;
            HashMap<Long,Long> up=new HashMap<>();
            HashMap<Long,Long> side=new HashMap<>();
            HashMap<Long,Long> diag1=new HashMap<>();
            HashMap<Long,Long> diag2=new HashMap<>();

            for(int i=0;i<n;i++){
                d=rd.readLine().split(" ");
                x=Long.parseLong(d[0]);
                y=Long.parseLong(d[1]);
                up.put(x, up.getOrDefault(x, 0L) + 1);
            side.put(y, side.getOrDefault(y, 0L) + 1);
            diag1.put(x - y, diag1.getOrDefault(x - y, 0L) + 1);
            diag2.put(x + y, diag2.getOrDefault(x + y, 0L) + 1);
            }
            ans+=add(up)+add(side)+add(diag1)+add(diag2);
            System.out.println(ans);
        }		
	}
}