
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int K=Integer.parseInt(arg[1]);
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		int[][] dp=new int[N][K+1];
		
		int[] w=new int[N];
		int[] v=new int[N];
				
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			w[i]=Integer.parseInt(temp[0]);
			v[i]=Integer.parseInt(temp[1]);
		}
		
		for(int b=0;b<=K;b++) {
			if(b>=w[0]) {
				dp[0][b]=v[0];
			}
			else {
				dp[0][b]=0;
			}
		}
		
		for(int a=1;a<N;a++) {
			for(int b=0;b<=K;b++) {
				if(b>=w[a]) {
					int temp=b-w[a];
					if(temp>=0) {
						dp[a][b]=Math.max(dp[a-1][temp]+v[a],dp[a-1][b]);
					}
					else {
						dp[a][b]=Math.max(dp[a-1][b], v[a]);
					}
				}else {
					dp[a][b]=dp[a-1][b];
				}
			}
		}
		
		
		int max=Integer.MIN_VALUE;
		
		for(int a=0;a<=K;a++) {
			max=Math.max(max, dp[N-1][a]);
		}
		
		System.out.print(max);

	}

}
