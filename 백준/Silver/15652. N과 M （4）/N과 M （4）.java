
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]);
		M=Integer.parseInt(arg[1]);
		
		arr=new int[M+1];
		
		dfs(1,0);
		
		System.out.print(sb);
	}

	
	public static void dfs(int start,int level) {
		
		if(level==M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int j=start;j<=N;j++) {
			arr[level]=j;
			dfs(j,level+1);
		}
	}
}
