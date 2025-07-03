// https://codeforces.com/problemset/problem/1807/F
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Bouncy_Ball{
    static int n,m,ix,iy,fx,fy,tx,ty;
    static char[] d;
    static void bounce(){
        int xd,yd;
        if(d[0]=='U' && d[1]=='R'){
            xd=m-tx;
            yd=n-ty;
            tx+=Math.min(xd,yd);
            ty+=Math.min(xd,yd);
        }
        else if(d[0]=='U' && d[1]=='L'){
            yd=n-ty;
            xd=tx-1;
            tx-=Math.min(xd,yd);
            ty+=Math.min(xd,yd);
        }
        else if(d[0]=='D' && d[1]=='L'){
            yd=ty-1;
            xd=tx-1;
            ty-=Math.min(xd,yd);
            tx-=Math.min(xd,yd);
        }
        else{
            yd=ty-1;
            xd=m-tx;
            tx+=Math.min(xd,yd);
            ty-=Math.min(xd,yd);
        }
        if(xd<yd){
            d[1]=d[1]=='L'?'R':'L';
        }
        else if(yd<xd){
            d[0]=d[0]=='D'?'U':'D';
        }
        else{
            d[0]=d[0]=='D'?'U':'D';
            d[1]=d[1]=='L'?'R':'L';
        }

    }
    public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        // String d[];
		int times=sc.nextInt();
        while(times-->0){
            n=sc.nextInt();
            m=sc.nextInt();
            ty=iy=n-sc.nextInt()+1;
            tx=ix=sc.nextInt();
            fy=n-sc.nextInt()+1;
            fx=sc.nextInt();
            String s=sc.next();
            d=new char[2];
            d[0]=s.charAt(0);d[1]=s.charAt(1);
            int b=0;
            int ic,tc,fc;
            if((d[0]=='U' && d[1]=='R') || (d[0]=='D' && d[1]=='L')){
                tc=ic=ix-iy;
                fc=fx-fy;
            }
            else{
                tc=ic=ix+iy;
                fc=fx+fy;
            }
            if(ic==fc){
                if(d[0]=='U' && d[1]=='R'){
                    if(fx>=ix && fy>=iy){
                        System.out.println(0);
                        continue;
                    }
                }
                else if(d[0]=='U' && d[1]=='L'){
                    if(fy>=iy && fx<=ix){
                        System.out.println(0);
                        continue;
                    }
                }
                else if(d[0]=='D' && d[1]=='R'){
                    if(fy<=iy && fx>=ix){
                        System.out.println(0);
                        continue;
                    }
                }
                else{
                    if(fy<=iy && fx<=ix){
                        System.out.println(0);
                        continue;
                    }
                }
            }
            bounce();
            b++;
            ix=tx;
            iy=ty;
            s=new String(d);
            boolean p=false;
            if((d[0]=='U' && d[1]=='R') || (d[0]=='D' && d[1]=='L')){
                ic=tx-ty;
            }
            else{
                ic=tx+ty;
            }
            while(true){
// System.out.println(tx+" "+ty+" "+d[0]+" "+d[1]+" "+s);
                if((d[0]=='U' && d[1]=='R') || (d[0]=='D' && d[1]=='L')){
                    tc=tx-ty;
                    fc=fx-fy;
                }
                else{
                    tc=tx+ty;
                    fc=fx+fy;
                }
                if(tc==fc){
                    System.out.println(b);
                    p=true;
                    break;
                }
                if(tx==ix && ty==iy && d[0]==s.charAt(0) && d[1]==s.charAt(1) && b>1){
                    break;
                }
                bounce();
                b++;

            }
            if(!p){
                System.out.println(-1);
            }

        }		
	}
}