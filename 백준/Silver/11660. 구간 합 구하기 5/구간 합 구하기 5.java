
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		
		int[][] arr=new int[N+1][N+1];
		int[][] dp=new int[N+1][N+1];
		
		
		for(int j=1;j<=N;j++) {
			String[] temp=br.readLine().split(" ");
			for(int i=1;i<=N;i++) {
				arr[j][i]=Integer.parseInt(temp[i-1]);
				dp[j][i]=dp[j][i-1]+dp[j-1][i]-dp[j-1][i-1]+arr[j][i];
			}
		}
		
		for(int i=0;i<M;i++) {
			String[] temp=br.readLine().split(" ");
			int x1=Integer.parseInt(temp[0]);
			int y1=Integer.parseInt(temp[1]);
			int x2=Integer.parseInt(temp[2]);
			int y2=Integer.parseInt(temp[3]);
			
			int sum = dp[x2][y2]
                    - dp[x1 - 1][y2]
                    - dp[x2][y1 - 1]
                    + dp[x1 - 1][y1 - 1];
			
			System.out.println(sum);
		}
		
		
	}

}
