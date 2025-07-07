import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=br.readLine().split(" ");
		
		int k=Integer.parseInt(s[0]);
		int n=Integer.parseInt(s[1]);
		
		int[] ar=new int[k];
		
		for(int i=0;i<k;i++) {
			ar[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ar);
		
		
		long max=1;
		long start=1;
		long end=ar[k-1];
		
		while(start<=end) {
			long count=0;
			long mid=(start+end)/2;
			
			for(int j=0;j<k;j++) {
				count+=ar[j]/mid;
			}
			if(count>=n) {
				max=mid;
				start=mid+1;
			}
			else {
				end=mid-1;
			}
			
		}
		System.out.print(max);
	}

}
