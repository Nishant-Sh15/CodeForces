// https://codeforces.com/problemset/problem/2092/D
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Mishkin_Energizer

{
    static int n;
    static char[]s;
    static ArrayList<Integer>ans;
    static void solve(char a,int x,char b,int y,char c,int z){
        int i=-1;
        if(y!=x){
            for(int j=n-1;j>0;j--){
                if(s[j]==b && s[j-1]!=b){
                    i=j;
                    break;
                }
            }
            if(i!=-1){
                int t;
                if(s[i-1]==c){
                    t=2*(y-x);
                    z+=y-x;
                }
                else{
                    t=2*(y-x)+1;
                    z+=y-x+1;
                }
                while(t-->0){
                    ans.add(i-1);
                    i++;
                }
                x=y;
                i--;
                while(z>x){
                    ans.add(i);
                    ans.add(i);
                    x++;
                }
            }
            else{
                for(int j=0;j<n-1;j++){
                    if(s[j]==b && s[j+1]!=b){
                        i=j;
                        break;
                    }
                }
                int t;
                if(s[i+1]==c){
                    z+=y-x;
                    t=2*(y-x);
                }
                else{
                    z+=y-x+1;
                    t=2*(y-x)+1;
                }
                while(t-->0){
                    ans.add(i);
                }
                x=y;
                i++;
                while(z>x){
                    ans.add(i-1);
                    i++;
                    ans.add(i-1);
                    i++;
                    x++;
                }
            }
        }
        else{
            i=-1;
            for(int j=n-1;j>0;j--){
                if(s[j]==c && s[j-1]!=c){
                    i=j;
                    break;
                }
            }
            if(i!=-1){
                int t=2*(z-y);
                while(t-->0){
                    ans.add(i-1);
                    i++;
                }
            }
            else{
                for(int j=0;j<n-1;j++){
                    if(s[j]==c && s[j+1]!=c){
                        i=j;
                        break;
                    }
                }
                int t=2*(z-y);
                while(t-->0){
                    ans.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wd=new BufferedWriter(new OutputStreamWriter(System.out));
        String d[]; 
        int times=Integer.parseInt(rd.readLine());
        while(times-->0){
            n=Integer.parseInt(rd.readLine());
            s=rd.readLine().toCharArray();
            ans=new ArrayList<>();
            HashMap<Character,Character>hm=new HashMap<>();
            hm.put('A','L');
            hm.put('B','T');
            hm.put('C','I');
            hm.put('I','C');
            hm.put('T','B');
            hm.put('L','A');
            int f[][]=new int[3][2];
            f[1][1]=1;
            f[2][1]=2;
            for(int i=0;i<n;i++){
                f[hm.get(s[i])-'A'][0]++;
            }
            Arrays.sort(f,Comparator.comparingDouble(o->o[0]));
            if(f[2][0]==n){
                wd.write("-1\n");
                continue;
            }
            else{
                solve(hm.get((char)(f[0][1]+'A')),f[0][0],hm.get((char)(f[1][1]+'A')),f[1][0],hm.get((char)(f[2][1]+'A')),f[2][0]);
                wd.write(ans.size()+"\n");
                for(int i=0;i<ans.size();i++){
                    wd.write((ans.get(i)+1)+"\n");
                }
            }
        }
        wd.flush();
	}
}