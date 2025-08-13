
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String temp=br.readLine();
		
		int T=Integer.parseInt(temp);

		int[][] arr;
		int[][] dp;
		
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());
			
			arr=new int[2][n];
			dp=new int[3][n];
			
			
			String[] arg1=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[0][j]=Integer.parseInt(arg1[j]);
			}
			
			String[] arg2=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[1][j]=Integer.parseInt(arg2[j]);
			}
			
			
			dp[0][0]=0;
			dp[1][0]=arr[0][0];
			dp[2][0]=arr[1][0];
			
			
			
			for(int j=1;j<n;j++) {			
				dp[0][j]=Math.max(dp[0][j-1],Math.max(dp[1][j-1],dp[2][j-1]));
				dp[1][j]=Math.max(dp[0][j-1]+arr[0][j],dp[2][j-1]+arr[0][j]);
				dp[2][j]=Math.max(dp[0][j-1]+arr[1][j],dp[1][j-1]+arr[1][j]);
				
				
			}
			
			int ans = Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]));
			System.out.println(ans);
		}
	}
	


}
