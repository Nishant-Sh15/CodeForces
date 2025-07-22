// https://codeforces.com/contest/1973/problem/C
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Cat_Fox_and_Double_Maximum
{
    static Scanner sc=new Scanner(System.in);
    static BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
    static void fill(int a[]){
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception{
        // String d[]; 
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int p[]=new int[n+1];
            fill(a);
            for(int i=0;i<n;i++){
                p[a[i]]=i;
            }
            int qe[]=new int[n];
            int qo[]=new int[n];
            ArrayList<Integer> e=new ArrayList<>();
            ArrayList<Integer> o=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i%2==0){
                  e.add(a[i]);  
                } 
                else{
                    o.add(a[i]);
                }
            }
            Collections.sort(e);
            Collections.sort(o);
            int num=n;
            for(int i=0;i<e.size();i++){
                qe[p[e.get(i)]]=num--;
            }
            for(int i=0;i<o.size();i++){
                qe[p[o.get(i)]]=num--;
            }
            num=n;
            for(int i=0;i<o.size();i++){
                qo[p[o.get(i)]]=num--;
            }
            for(int i=0;i<e.size();i++){
                qo[p[e.get(i)]]=num--;
            }
            int ec=0,oc=0;
            for(int i=1;i<n-1;i++){
                int t=a[i]+qe[i];
                int l=a[i-1]+qe[i-1];
                int r=a[i+1]+qe[i+1];
                if(t>l && t>r){
                    ec++;
                }
                t=a[i]+qo[i];
                l=a[i-1]+qo[i-1];
                r=a[i+1]+qo[i+1];
                if(t>l && t>r){
                    oc++;
                }
            }
            if(ec>oc){
                print(qe);
            }
            else{
                print(qo);
            }
        }
	}
}