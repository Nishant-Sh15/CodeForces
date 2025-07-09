// https://codeforces.com/contest/2096/problem/C
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Wonderful_City 
{
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            d=rd.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                d=rd.readLine().split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(d[j]);
                }
            }
            long rp[][]=new long[n][2];
            long cp[][]=new long[n][2];
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                rp[i][1]=Integer.parseInt(d[i]);
            }
            d=rd.readLine().split(" ");
            for(int i=0;i<n;i++){
                cp[i][1]=Integer.parseInt(d[i]);
            }
            long row[][]=new long[n][2];
            long col[][]=new long[n][2];
            row[0][0]=0;
            row[0][1]=rp[0][1];
            col[0][0]=0;
            col[0][1]=cp[0][1];
            for(int i=1;i<n;i++){
                for(int x=0;x<2;x++){
                    row[i][x]=10000000000000000l;
                    for(int y=0;y<2;y++){
                        int c=0;
                        for(int j=0;j<n;j++){
                            if(a[i][j]+x==a[i-1][j]+y){
                                c++;
                            }
                        }
                        if(c==0){
                            row[i][x]=Math.min(row[i][x],row[i-1][y]+rp[i][x]);
                        }
                    }
                }
            }
            for(int j=1;j<n;j++){
                for(int x=0;x<2;x++){
                    col[j][x]=10000000000000000l;
                    for(int y=0;y<2;y++){
                        int c=0;
                        for(int i=0;i<n;i++){
                            if(a[i][j]+x==a[i][j-1]+y){
                                c++;
                            }
                        }
                        if(c==0){
                            col[j][x]=Math.min(col[j][x],col[j-1][y]+cp[j][x]);
                        }
                    }
                }
            }
            long tr=Math.min(row[n-1][0],row[n-1][1]);
            long tc=Math.min(col[n-1][0],col[n-1][1]);
            if(tr==10000000000000000l || tc==10000000000000000l){
                System.out.println(-1);
            }
            else{
                System.out.println(tr+tc);
            }
        }
	}
}