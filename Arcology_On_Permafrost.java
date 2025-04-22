import java.util.*;

public class Arcology_On_Permafrost {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            int a=n-m*k;
            int b=n/(m+1);
            if(a<k){
                for(int i=0;i<n;i++){
                    System.out.print((i%k)+" ");
                }
            }
            else{
                for(int i=0;i<n;i++){
                    System.out.print((i%b)+" ");
                }
            }
            System.out.println();
        }
	}
	
}
