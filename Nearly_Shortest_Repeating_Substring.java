// https://codeforces.com/problemset/problem/1950/E
import java.util.*;

public class Nearly_Shortest_Repeating_Substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            String str=sc.next();
            boolean f=true;
            int i;
            for(i=1;i<=n/2 && f;i++){
                if(n%i==0){
                    int c=0,j=0;
                    int l=0;
                    for(int m=0;m<2 && f;m++){
                        c=0;
                        j=l;
                        for(int k=0;k<n && c<2;k++){
                            if(str.charAt(j)!=str.charAt(k)){
                                c++;
                            }
                            j++;
                            if(j>=l+i){
                                j=l;
                            }
                        }
                        if(c<2){
                            f=false;
                        }
                        l=n-i;
                    }
                }
            }
            if(!f){
                System.out.println(i-1);
            }
            else{
                System.out.println(n);
            }
            
        }
	}
	
}

