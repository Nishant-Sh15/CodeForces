// https://codeforces.com/problemset/problem/2084/C
import java.util.*;

public class You_Soared_Afar_With_Grace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[][]=new int[2][n];
            int p[][]=new int[2][n+1];
            ArrayList<Integer> ans=new ArrayList<>();
            int temp;
            for(int i=0;i<n;i++){
                temp=sc.nextInt();
                a[0][i]=temp;
                p[0][temp]=i;
            }
            for(int i=0;i<n;i++){
                temp=sc.nextInt();
                a[1][i]=temp;
                p[1][temp]=i;
            }
            for(int i=0;i<n;i++){
                if(a[0][i]==a[1][i]){
                    if(i!=n/2){
                        temp=a[0][i];
                        a[0][i]=a[0][n/2];
                        a[0][n/2]=temp;
                        p[0][temp]=n/2;
                        p[0][a[0][i]]=i;

                        temp=a[1][i];
                        a[1][i]=a[1][n/2];
                        a[1][n/2]=temp;
                        p[1][temp]=n/2;
                        p[1][a[1][i]]=i;
                        ans.add(i+1);
                        ans.add(n/2 +1);
                    }
                    break;
                }
            }
            int j,indx;
            for(int i=0;i<n/2;i++){
                j=n-1-i;
                indx=p[1][a[0][j]];
                if(indx>i && indx<j){
                    temp=a[0][i];
                    a[0][i]=a[0][indx];
                    a[0][indx]=temp;
                    p[0][temp]=indx;
                    p[0][a[0][i]]=i;

                    a[1][indx]=a[1][i];
                    a[1][i]=a[0][j];
                    p[1][a[1][indx]]=indx;
                    p[1][a[1][i]]=i;

                    ans.add(i+1);
                    ans.add(indx+1);
                }
            }
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(a[0][i]!=a[1][n-1-i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(ans.size()/2);
                for(int i=0;i<ans.size();i+=2){
                    System.out.println(ans.get(i)+" "+ans.get(i+1));
                }
            }else{
                System.out.println(-1);
            }
        }
	}
	
}
