
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());
			int[][] arr=new int[2][n];
			int[][] dp=new int[3][n];
			
			
			for(int a=0;a<2;a++) {
				String[] temp=br.readLine().split(" ");
				for(int b=0;b<n;b++) {
					arr[a][b]=Integer.parseInt(temp[b]);
				}
			}
			
			dp[0][0]=arr[0][0];
			dp[1][0]=arr[1][0];
			dp[2][0]=0;
			
			for(int k=1;k<n;k++) {
				dp[0][k]=Math.max(dp[1][k-1], dp[2][k-1])+arr[0][k];
				dp[1][k]=Math.max(dp[0][k-1], dp[2][k-1])+arr[1][k];
				dp[2][k]=Math.max(Math.max(dp[0][k-1], dp[1][k-1]),dp[2][k-1]);
			}
			
			System.out.println(Math.max(Math.max(dp[0][n-1], dp[1][n-1]),dp[2][n-1]));
		}
		
		
		
	}

}
