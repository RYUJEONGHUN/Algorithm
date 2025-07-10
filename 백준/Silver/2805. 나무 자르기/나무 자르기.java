
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int n=Integer.parseInt(arg[0]);
		long m=Long.parseLong(arg[1]);
		
		long[] arr=new long[n];
		
		String[] t=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i]=Long.parseLong(t[i]);
		}
		
		Arrays.sort(arr);
		long left=0;
		long right=arr[n-1];
		
		long min=Integer.MAX_VALUE;
		long result=0;
		
		while(right >= left) {
			long mid=(left+right)/2;
			long sum=0;
			for(int j=0;j<n;j++) {
				long temp=arr[j]-mid;
				if(temp>0) {
					sum+=temp;
				}
			}
			
			if(sum>=m) {
				left=mid+1;
				if(min>sum) {
					min=sum;
					result=mid;
				}
			}
			else {
				right=mid-1;
			}
			
		}
		System.out.print(result);
	}

}
