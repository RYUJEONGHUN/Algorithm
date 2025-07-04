
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] fst=br.readLine().split(" ");
		
		int N=Integer.parseInt(fst[0]);
		int M=Integer.parseInt(fst[1]);
		
		int[] arr=new int[N];
		
		String[] s=br.readLine().split(" ");
		
		int sum=0;
		
		int[] prefix=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(s[i]);
			sum+=arr[i];
			prefix[i]=sum;
		}
		
		
		for(int j=0;j<M;j++) {
			String[] sr=br.readLine().split(" ");
			int n=Integer.parseInt(sr[0])-2;
			int m=Integer.parseInt(sr[1])-1;
			if(n==-1) {
				System.out.println(prefix[m]);
			}
			else {
				System.out.println(prefix[m]-prefix[n]);
			}
			
			
		}
		
	}

}
