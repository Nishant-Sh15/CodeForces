// https://codeforces.com/problemset/problem/2003/D1
import java.util.*;

public class Turtle_and_a_MEX_Problem__Easy_Version{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int z=sc.nextInt();
            ArrayList<HashSet<Integer>> a=new ArrayList<>();
            HashSet<Integer> temp;
            int x;
            for(int i=0;i<n;i++){
                x=sc.nextInt();
                temp=new HashSet<>();
                for(int j=0;j<x;j++){
                    temp.add(sc.nextInt());
                }
                a.add(temp);
            }
            long ans=0,m=0;
            for(int i=0;i<n;i++){
                boolean f=false;
                temp=a.get(i);
                for(int j=0;j<temp.size()+2;j++){
                    if(!temp.contains(j)){
                        if(f){
                            m=Math.max(m,j);
                            break;
                        }
                        else{
                            f=true;
                        }
                    }
                }
            }
            ans=m*Math.min(m+1,z+1);
            if(z>m){
                ans+=(z+m+1)*(z-m)/2;
            }
            System.out.println(ans);
        }
    }
}