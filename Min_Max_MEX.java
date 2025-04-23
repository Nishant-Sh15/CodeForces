import java.util.*;

public class Min_Max_MEX {
    static boolean trial(int a[],int t,int k){
        HashSet<Integer> hs=new HashSet<>();
        int c=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]<t){
                hs.add(a[i]);
            }
            if(hs.size()==t){
                c++;
                hs=new HashSet<>();
                if(c==k){
                    return true;
                }
            }
        }
        return false;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int l=0,r=n/k;
            int m,ans=0;
            while(l<=r){
                m=(l+r)/2;
                if(trial(a,m,k)){
                    ans=m;
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            System.out.println(ans);
        }
	}
	
}
