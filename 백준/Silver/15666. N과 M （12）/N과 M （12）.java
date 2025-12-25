
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] vis;
	static int[] carr;
	static int prev;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		String[] temp=br.readLine().split(" ");
		
		N=Integer.parseInt(temp[0]);
		M=Integer.parseInt(temp[1]);
		
		
		arr=new int[N];
		carr=new int[M];
		
		String[] aa=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(aa[i]);
		}
		
		Arrays.sort(arr);
		
		dfs(0);
				
		System.out.print(sb);
		
	}
	public static void dfs(int level) {
		if(level==M) {
			for(int j=0;j<M;j++) {
				System.out.print(carr[j]+" ");
			}
			System.out.println();
			
			return;
		}
		int prev=-1;
		 
		for(int i=0;i<N;i++) {
			if(prev==arr[i]) continue;
		
			if(level==0) {
				carr[level]=arr[i];
				prev=arr[i];
				dfs(level+1);
			}
			else if(arr[i]>=carr[level-1]) {
				carr[level]=arr[i];
				prev=arr[i];
				dfs(level+1);
			}
		}
	}
}
