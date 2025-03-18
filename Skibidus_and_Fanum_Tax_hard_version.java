// https://codeforces.com/problemset/problem/2065/C2
import java.util.*;

public class Skibidus_and_Fanum_Tax_hard_version
{
    public static int find(Long[] b,Long t,int s,int e){
        if(s>e){
            return s;
        }
        int m=(s+e)/2;
        if(m!=0){
            if(b[m]>=t){
                if(b[m-1]<t){
                    return m;
                }
                return find(b,t,s,m-1);
            }
        }else{
            if(b[m]>=t)
                return m;
        }
        return find(b,t,m+1,e);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            Long a[]=new Long[n];
            Long b[]=new Long[m];
            for(int i=0;i<n;i++)
                a[i]=sc.nextLong();
            for(int i=0;i<m;i++)
                b[i]=sc.nextLong();
            Arrays.sort(b);
            long x=b[0]-a[0];
            a[0]=Math.min(x,a[0]);

            boolean flag=true;

            for(int i=1;i<n;i++){
                long min=a[i]+a[i-1];
                int indx=find(b,min,0,m-1);
                if(a[i]>=a[i-1]){
                    if(indx!=m){
                        x=b[indx]-a[i];
                        a[i]=Math.min(a[i],x);
                    }
                }else{
                    if(indx==m){
                        flag=false;
                        break;
                    }
                    a[i]=b[indx]-a[i];
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    
}