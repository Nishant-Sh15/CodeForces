// https://codeforces.com/contest/1861/problem/C
import java.util.*;

public class Queries_for_the_Array {
    static String solve(char[] cs){
        int l=0,sort=0,unsort=Integer.MAX_VALUE;
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='+'){
                l++;
            }
            else if(cs[i]=='-'){
                l--;
                if(unsort>l){
                    unsort=Integer.MAX_VALUE;
                }
                if(sort>l){
                    sort=l;
                }
            }
            else if(cs[i]=='1'){
                if(l>=unsort){
                    return "NO";
                }
                sort=l;
            }
            else if(cs[i]=='0'){
                if(sort>=l ||l<2){
                    return "NO";
                }
                unsort=Math.min(unsort,l);
            }
                
        }
        return "YES";
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            String str=sc.next();
            System.out.println(solve(str.toCharArray()));
            
        }
	}
	
}
