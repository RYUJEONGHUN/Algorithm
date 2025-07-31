
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
				
		String[] temp=br.readLine().split(" ");
		
		int[] dp=new int[N];	
		Arrays.fill(dp, 1);
		
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		
		dp[0]=1;
		
		int realmax=1;
		
		for(int j=1;j<N;j++) {
			for(int i=0;i<j;i++) {
				if(arr[i]<arr[j]) {
					dp[j]=Math.max(dp[j], dp[i]+1);
				}
			}
			realmax=Math.max(realmax, dp[j]);
		}
		
		System.out.print(realmax);
	}

}
