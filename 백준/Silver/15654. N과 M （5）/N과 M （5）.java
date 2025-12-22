
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int M;
	static int[] vis;
	static int[] arr;
	static int[] snum;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]); //N
		M=Integer.parseInt(arg[1]); //M
		sb=new StringBuilder();
		snum=new int[N];
		String[] temp=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			snum[i]=Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(snum);
		
		vis=new int[N];
		arr=new int[M];
		dfs(0);
		
		System.out.print(sb);
	}
	
	public static void dfs(int level) {
		if(level==M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int j=0;j<N;j++) {
			if(vis[j]!=1) {
				vis[j]=1;
				arr[level]=snum[j];
				dfs(level+1);
				vis[j]=0;
			}
		}
	}
}
