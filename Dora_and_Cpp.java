// https://codeforces.com/problemset/problem/2007/C


import java.util.*;
public class Dora_and_Cpp{
    static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int d=gcd(Math.max(a,b),Math.min(a,b));
            ArrayList<Integer> arr=new ArrayList<>();
            HashSet<Integer> hs=new HashSet<>();
            int x;
            for(int i=0;i<n;i++){
                x=sc.nextInt();
                if(!hs.contains(x%d)){
                    hs.add(x%d);
                    arr.add(x%d);
                }
            }
            Collections.sort(arr);
            int ans=arr.get(arr.size()-1)-arr.get(0);
            for(int i=1;i<arr.size();i++){
                ans=Math.min(ans,d+arr.get(i-1)-arr.get(i));
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
