
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		long[] arr=new long[3];
		String[] arg=br.readLine().split(" ");
		
		
		long N=Integer.parseInt(arg[0]);
		arr[0]=Integer.parseInt(arg[1]);
		arr[1]=Integer.parseInt(arg[2]);
		arr[2]=Integer.parseInt(arg[3]);
		
		long m=Math.max(arr[0],Math.max(arr[1],arr[2]));
		
		long left=1;
		long right=m*N;
		
		while(left<=right) {
			long mid=(left+right)/2;
			
			long count=0;
			for(int i=0;i<3;i++) {
				count+=(mid/arr[i]);
			}
			if(N>count) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		
		long precount=0;
		
		for(int i=0;i<3;i++) {
			precount+=(left-1)/arr[i];
		}
		
		
		for(int i=0;i<3;i++) {
			if(left%arr[i]==0) {
				precount++;
				if(precount==N) {
					if(i==0) {
						System.out.print("A win");
					}
					else if(i==1) {
						System.out.print("B win");
					}
					else {
						System.out.print("C win");
					}
				}
			}
		}
		
		
	}

}
