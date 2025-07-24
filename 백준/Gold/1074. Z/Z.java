
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static int r;
	static int C;
	static int count=0;
	static boolean check=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		
		int N=Integer.parseInt(arg[0]);
		r=Integer.parseInt(arg[1]);
		C=Integer.parseInt(arg[2]);
		
		int s=(int)Math.pow(2,N);		
		
		divide(0,0,s);
		
		
		
	}

	public static void divide(int m,int n,int s) {
		 if (s == 1) {
			 if (m == r && n == C) {
		            System.out.println(count);
		        }
		        return;
		 }
		int plus=(s/2)*(s/2);
		if(r<m+s/2 && C<n+s/2) {
			count=count+0;
			divide(m,n,s/2);
		}
		else if(r<m+s/2 && C>=n+s/2){
			count=count+1*plus;
			divide(m,n+s/2,s/2);
		}
		else if(r>=m+s/2 && C<n+s/2) {
			count=count+2*plus;
			divide(m+s/2,n,s/2);
		}
		else if(r>=m+s/2 && C>=n+s/2) {
			count=count+3*plus;
			divide(m+s/2,n+s/2,s/2);
		}
	}
}
