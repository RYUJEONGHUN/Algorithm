
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[] arr=new int[n+1];
		int[] dp=new int[n+1];
		
		String[] temp=br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			arr[i+1]=Integer.parseInt(temp[i]);
		}

		Arrays.fill(dp, 1);
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<=n;i++) {
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		System.out.print(max);
	}

}
