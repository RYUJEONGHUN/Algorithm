
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int [][] arr=new int[N][3];
		int[][] dp=new int[N][3];
		
		for(int i=0;i<N;i++) {
			String[] arg=br.readLine().split(" ");
			
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(arg[j]);
			}
		}
		
		dp[0][0]=arr[0][0];
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];
		
		for(int a=1;a<N;a++) {
			dp[a][0]=Math.min(dp[a-1][1]+arr[a][0], dp[a-1][2]+arr[a][0]);
			dp[a][1]=Math.min(dp[a-1][0]+arr[a][1], dp[a-1][2]+arr[a][1]);
			dp[a][2]=Math.min(dp[a-1][0]+arr[a][2], dp[a-1][1]+arr[a][2]);
		}
		
		int min=Integer.MAX_VALUE;
		for(int k=0;k<3;k++) {
			min=Math.min(min, dp[N-1][k]);
		}
		
		System.out.print(min);
		
	}

}
