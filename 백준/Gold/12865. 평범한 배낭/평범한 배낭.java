
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		int N=Integer.parseInt(temp[0]);
		int K=Integer.parseInt(temp[1]);
		
		int[] w=new int[N+1];
		int[] v=new int[N+1];
		
		int[][] dp=new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			String[] arg=br.readLine().split(" ");
			int a=Integer.parseInt(arg[0]);
			int b=Integer.parseInt(arg[1]);
			
			w[i]=a;
			v[i]=b;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(w[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.print(dp[N][K]);
	}

}
