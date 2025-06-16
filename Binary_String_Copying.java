// https://codeforces.com/problemset/problem/1849/C

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Binary_String_Copying
{
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		int times=sc.nextInt();
        // String d[];
        while(times-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            String s=sc.next();

            int l[]=new int[n];
            int r[]=new int[n];
            l[n-1]=n;
            if(s.charAt(n-1)=='1'){
                l[n-1]=n-1;
            }
            for(int i=n-2;i>=0;i--){
                l[i]=l[i+1];
                if(s.charAt(i)=='1'){
                    l[i]=i;
                }
            }

            r[0]=-1;
            if(s.charAt(0)=='0'){
                r[0]=0;
            }
            for(int i=1;i<n;i++){
                r[i]=r[i-1];
                if(s.charAt(i)=='0'){
                    r[i]=i;
                }
            }
            HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
            HashSet<Integer> hs;
            int left,right,o=0;
            int ans=0;
            while(m-->0){
                left=sc.nextInt()-1;
                right=sc.nextInt()-1;
                if(r[right]>=left && l[left]<=right && l[left]<r[right]){
                    hs=hm.getOrDefault(l[left], new HashSet<>());
                    if(!hs.contains(r[right])){
                        ans++;
                        hs.add(r[right]);
                        hm.put(l[left],hs);
                    }
                }else{
                    o++;
                }
            }
            System.out.println(o>0?ans+1:ans);
        }		
	}
}