
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[] vis;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]); //N
		M=Integer.parseInt(arg[1]); //M
		vis=new int[N+1];
		arr=new int[M];
		dfs(1,0);
		
	}
	
	public static void dfs(int s,int level) {
		if(level==M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int j=s;j<=N;j++) {
			if(vis[j]!=1) {	
				vis[j]=1;
				arr[level]=j;
				dfs(j,level+1);
				vis[j]=0;
			}
		}
	}
}
