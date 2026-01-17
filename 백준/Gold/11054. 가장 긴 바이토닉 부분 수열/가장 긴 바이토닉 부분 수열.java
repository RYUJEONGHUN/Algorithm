
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		
		String[] temp=br.readLine().split(" ");

		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		
		int[] upstreamdp=new int[N];
		int[] downstreamdp=new int[N];
		
		Arrays.fill(upstreamdp,1);
		Arrays.fill(downstreamdp, 1);
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					upstreamdp[i]=Math.max(upstreamdp[j]+1, upstreamdp[i]);
				}
			}
		}
		
		for(int i=N-2;i>=0;i--) {
			for(int j=N-1;j>i;j--) {
				if(arr[i]>arr[j]) {
					downstreamdp[i]=Math.max(downstreamdp[j]+1, downstreamdp[i]);
				}
			}
		}
		
		int m=Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			m=Math.max(m,upstreamdp[i]+downstreamdp[i]);
		}
		
		System.out.print(m-1);
	}

}
