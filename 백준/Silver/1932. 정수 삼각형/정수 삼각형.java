
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
		int[][] dp=new int[n][n];
		
		dp[0][0]=arr[0][0];
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][j]+arr[i][j];
				}
				else if(j==i) {
					dp[i][j]=dp[i-1][j-1]+arr[i][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		
		for(int s:dp[n-1]) {
			max=Math.max(max, s);
		}
		System.out.print(max);
	}

}
