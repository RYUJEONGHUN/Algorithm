import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N+1][N+1];
		
		long[][][] dp=new long[N+1][N+1][3];
		
		
		for(int i=1;i<=N;i++) {
			String[] arg=br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(arg[j-1]);
			}
		}
		
		dp[1][2][0]=1;
		
		for(int y=1;y<=N;y++) {
			for(int x=1;x<=N;x++) {
				if(arr[y][x]==1) continue;
				
				if (x - 1 >= 1 && arr[y][x - 1] == 0) {
                    dp[y][x][0] += dp[y][x - 1][0] + dp[y][x - 1][2];
                }
				
				if (y - 1 >= 1 && arr[y - 1][x] == 0) {
                    dp[y][x][1] += dp[y - 1][x][1] + dp[y - 1][x][2];
                }
				
				if (y - 1 >= 1 && x - 1 >= 1
                        && arr[y - 1][x] == 0 && arr[y][x - 1] == 0) {
                    dp[y][x][2] += dp[y - 1][x - 1][0]
                                  + dp[y - 1][x - 1][1]
                                  + dp[y - 1][x - 1][2];
                }
				
			}

			
		}
		long ans = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(ans);
		
		
	}

}
