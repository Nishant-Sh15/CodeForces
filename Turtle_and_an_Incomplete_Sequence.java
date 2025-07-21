// https://codeforces.com/contest/1981/problem/C
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Turtle_and_an_Incomplete_Sequence
{
    static ArrayList<Integer> conv(int a,int t){
        Stack<Integer>as=new Stack<>();
        Stack<Integer>ts=new Stack<>();
        int x=a;
        while(x>0){
            as.push(x%2);
            x=x/2;
        }
        x=t;
        while(x>0){
            ts.push(x%2);
            x/=2;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        boolean f=false;;
        while(!ts.isEmpty() && !as.isEmpty()){
            int c=as.pop();
            int g=ts.pop();
            if(c!=g){
                f=true;
                for(int i=0;i<=as.size();i++){
                    ans.add(-1);
                    ans.add(0);
                }
                ans.add(1);
                ans.add(g);
                break;
            }
        }
        if(f){
            while(!ts.isEmpty()){
                ans.add(1);
                ans.add(ts.pop());
            }
        }
        else if(ts.isEmpty()){
            while(!as.isEmpty()){
                ans.add(-1);
                ans.add(0);
                as.pop();
            }
        }
        else if(as.isEmpty()){
            while(!ts.isEmpty()){
                ans.add(1);
                ans.add(ts.pop());
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String d[]; 
        int z=1000000000;
        int times=sc.nextInt();
        while(times-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int b[]=new int[n];
            // ArrayList<Integer>t=new ArrayList<>();
            ArrayList<Integer>p=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(a[i]!=-1){
                    b[i]=a[i];
                    p.add(i);
                }
            }
            if(p.size()==n){
                boolean f2=a[0]==a[1]/2 ||a[1]==a[0]/2;
                for(int i=0;i<n-1;i++){
                    if(a[i]==a[i+1]/2 ||a[i+1]==a[i]/2){
                        continue;
                    }
                    f2=false;
                    break;
                }
                if(!f2){
                    System.out.println(-1);
                    continue;
                }
                for(int i=0;i<n;i++){
                    System.out.print(a[i]+" ");
                }
                System.out.println();
                continue;
            }
            else if(p.size()==0){
                for(int i=0;i<n;i++){
                    System.out.print((i%2 +1)+" ");
                }
                System.out.println();
                continue;
            }
            if(p.get(0)!=0){
                int i=p.get(0);
                if(i%2==0){
                    for(int j=0;j<i;j++){
                        if(j%2==1){
                            b[j]=a[i]*2;
                        }
                        else{
                            b[j]=a[i];
                        }
                        if(b[j]>z){
                            b[j]=a[i]/2;
                        }
                    }
                }
                else{
                    for(int j=0;j<i;j++){
                        if(j%2==0){
                            b[j]=a[i]*2;
                        }
                        else{
                            b[j]=a[i];
                        }
                        if(b[j]>z){
                            b[j]=a[i]/2;
                        }
                    }
                    
                }
            }
            else{
                b[0]=a[0];
            }
            int x=p.get(p.size()-1);
            b[x]=a[x];
            for(int i=x+1;i<n;i++){
                b[i]=b[i-1]*2;
                if(b[i]>z){
                    b[i]=b[i-1]/2;
                }
            }
            boolean f=true;
            for(int i=1;i<p.size();i++){
                int t=p.get(i);
                int c=p.get(i-1);
                if(t==c+1){
                    if(a[t]==a[c]/2 ||a[c]==a[t]/2){
                        continue;
                    }
                    else{
                        f=false;
                        break;
                    }
                }
                ArrayList<Integer>s=new ArrayList<>();
                if(b[c]!=b[t]){
                    s=conv(b[c], b[t]);
                    if(t-c<s.size()/2){
                        f=false;
                        break;
                    }
                    for(int j=0;j<s.size();j+=2){
                        int m=s.get(j);
                        int r=s.get(j+1);
                        if(m==1){
                            b[c+1]=b[c]*2;
                        }
                        else{
                            b[c+1]=b[c]/2;
                        }
                        c++;
                        b[c]+=r;
                    }
                }
                if((t-c+1)%2!=1){
                    f=false;
                    break;
                }
                for(int j=c+1;j<t;j++){
                    if((j-c)%2==1){
                        b[j]=b[c]*2;
                        if(b[i]>z){
                            b[j]=b[c]/2;
                        }
                    }
                    else{
                        b[j]=b[c];
                    }
                }
            }
            if(!f){
                System.out.println(-1);
            }
            else{
                for(int i=0;i<n;i++){
                    System.out.print(b[i]+" ");
                }
                System.out.println();
            }
        }
	}
}