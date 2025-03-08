// https://codeforces.com/problemset/problem/2072/E
import java.util.*;

public class Do_You_Love_Your_Hero_and_His_Two_Hit_Multi_Target_Attacks{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int k=sc.nextInt();
            int n=0,x=0,y=0;
            ArrayList<Integer> ans=new ArrayList<>();
            while(k>0){
                n=search(k,0,500);
                for(int i=0;i<=n;i++){
                    ans.add(x);
                    ans.add(y++);
                }
                x++;
                k-=fun(n);
            }
            System.out.println(ans.size()/2);
            for(int i=0;i<ans.size();i+=2){
                System.out.println(ans.get(i)+" "+ans.get(i+1));
            }
        }
    }
    static int search(int k,int s,int e){
        if(s>e){
            return s;
        }
        int m=(s+e)/2;
        int f=fun(m);
        if(f<=k){
            if(fun(m+1)>k){
                return m;
            }
            return search(k,m+1,e);
        }
        return search(k,s,m-1);
    }
    static int fun(int n){
        return n*(n+1)/2;
    }
}
