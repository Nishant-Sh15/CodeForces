// https://codeforces.com/problemset/problem/2066/A
import java.util.*;

public class Object_Identification{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x[]=new int[n];
            int min=0,max=0;
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++){
                x[i]=sc.nextInt();
                hs.add(x[i]);
                if(x[i]==1){
                    min=i;
                }else if(x[i]==n){
                    max=i;
                }
            }
            if(hs.size()<n){
                int num=0;
                for(int i=1;i<=n;i++){
                    if(!hs.contains(i)){
                        num=i;
                        break;
                    }
                }
                System.out.println("? "+num+" "+(((num+1)%n)+1));
                int r=sc.nextInt();
                if(r==0){
                    System.out.println("! A");
                }else{
                    System.out.println("! B");
                }
            }else{
                System.out.println("? "+(min+1)+" "+(max+1));
                int r1=sc.nextInt();
                if(r1<n-1){
                    System.out.println("! A");
                }
                else if(r1>n-1){
                    System.out.println("! B");
                }else{
                    System.out.println("? "+(max+1)+" "+(min+1));
                    int r2=sc.nextInt();
                    if(r1==r2){
                        System.out.println("! B");
                    }else{
                        System.out.println("! A");
                    }
                }
            }
        }
    }
    
}