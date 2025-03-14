// https://codeforces.com/problemset/problem/2070/C
import java.util.*;

public class Limited_Repainting{
    static int find(ArrayList<Integer> arr,int t,int s,int e){
        if(s>e){
            return e;
        }
        int m=(s+e)/2;
        if(m!=arr.size()-1){
            if(arr.get(m)>t){
                return find(arr,t,s,m-1);
            }else{
                if(arr.get(m+1)>t){
                    return m;
                }else{
                    return find(arr,t,m+1,e);
                }
            }
        }else{
            if(arr.get(m)>t){
                return find(arr,t,s,m-1);
            }else{
                return m;
            }
        }
    }
    static void add(ArrayList<Integer> arr,int v){
        int i=find(arr,v,0,arr.size()-1);
        if(i==arr.size()-1){
            arr.add(v);
        }else{
            arr.add(i+1,v);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            String str=sc.next();
            int arr[]=new int[n];
            int e=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                e=Math.max(e, arr[i]);
            }
            int s=0;
            int ans=0;
            while(s<=e){
                int m=(s+e)/2;
                int c=0,cont=0;
                for(int i=0;i<n;i++){
                    if(str.charAt(i)=='B'){
                        if(arr[i]>m){
                            if(cont==0){
                                c++;
                                cont=1;
                            }
                        }
                    }else{
                        if(arr[i]>m){
                            cont=0;
                        }
                    }
                }
                if(c>k){
                    s=m+1;
                }else{
                    ans=m;
                    e=m-1;
                }
            }
            System.out.println(ans);
        }
    }
    
}