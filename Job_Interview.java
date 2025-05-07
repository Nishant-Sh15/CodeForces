// https://codeforces.com/problemset/problem/1976/C
import java.util.*;

public class Job_Interview {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[][]=new int[n+m+2][2];
            for(int i=1;i<a.length;i++){
                a[i][0]=sc.nextInt();
            }
            for(int i=1;i<a.length;i++){
                a[i][1]=sc.nextInt();
            }
            int p_n=Integer.MAX_VALUE;
            int p_n1=Integer.MAX_VALUE;
            int t_m=Integer.MAX_VALUE;
            int t_m1=Integer.MAX_VALUE;
            long p[]=new long[a.length];
            long t[]=new long[a.length];
            int counter=-1;
            int k;
            a[0][0]=1;
            for( k=0;k<a.length;k++){
                if(a[k][0]>a[k][1]){
                    counter++;
                }
                if(counter==n){
                    p_n=k;
                    break;
                }
            }
            for( k=k+1;k<a.length;k++){
                if(a[k][0]>a[k][1]){
                    counter++;
                }
                if(counter==n+1){
                    p_n1=k;
                    break;
                }
            }
            counter=-1;
            a[0][1]=1;
            for( k=0;k<a.length;k++){
                if(a[k][0]<=a[k][1]){
                    counter++;
                }
                if(counter==m){
                    t_m=k;
                    break;
                }
            }
            for( k=k+1;k<a.length;k++){
                if(a[k][0]<=a[k][1]){
                    counter++;
                }
                if(counter==m+1){
                    t_m1=k;
                    break;
                }
            }
            p[a.length-1]=0;
            t[a.length-1]=0;
            for(int i=a.length-2;i>=0;i--){
                p[i]=p[i+1]+a[i+1][0];
                t[i]=t[i+1]+a[i+1][1];
            }
            long c[]=new long[a.length];
            for(int i=1;i<a.length;i++){
                c[i]=c[i-1]+Math.max(a[i][0],a[i][1]);
            }
            long ans=0;
            int p_min,t_min;
            for(int i=1;i<a.length;i++){
                if(i<=p_n){
                    if(a[i][0]>a[i][1]){
                      p_min=p_n1;  
                    }
                    else{
                      p_min=p_n;
                    }
                }
                else{
                    p_min=p_n;
                }
                if(i<=t_m){
                  if(a[i][0]<=a[i][1]){
                    t_min=t_m1;
                  }
                  else{
                    t_min=t_m;
                  }
                }  
                else{
                    t_min=t_m;
                }

                if(p_min<t_min){
                    ans=c[p_min]+t[p_min];
                    if(i<p_min){
                        ans-=Math.max(a[i][0],a[i][1]);
                    }
                    else{
                        ans-=a[i][1];
                    }
                }
                else{
                    ans=c[t_min]+p[t_min];
                    if(i<t_min){
                        ans-=Math.max(a[i][0],a[i][1]);
                    }else{
                        ans-=a[i][0];
                    }
                }
                System.out.print(ans+" ");
            }
            System.out.println();
        }
	}
	
}

