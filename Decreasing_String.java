// https://codeforces.com/problemset/problem/1886/C
import java.util.*;

public class Decreasing_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
        while(times-->0){
            String str=sc.next();
			long pos=sc.nextLong();
			int r=0,tl=str.length()-1;
			long cl=tl+1;
			while(cl<pos){
				r++;
				cl+=tl;
				tl--;
			}
			boolean rem[]=new boolean[str.length()];
			int i=0,j=1;
			while(r-->0){
				while(i<j&&rem[i]){
					i++;
				}
				if(i==j){
					j++;
				}
				while(j<rem.length &&(str.charAt(i)<=str.charAt(j) || rem[i])){
					i++;
					if(i==j){
						j++;
					}
				}
				int t=i;
				rem[i]=true;
				while(i>-1 && rem[i]){
					i--;
				}
				if(i==-1){
					i=t;
				}
			}
			long indx=pos-(cl-(tl+1));
			j=0;
			for(int k=0;k<rem.length;k++){
				if(!rem[k]){
					j++;
				}
				if(j==indx){
					System.out.print(str.charAt(k));
					break;
				}
			}

			
        }
		System.out.println();
	}
	
}
