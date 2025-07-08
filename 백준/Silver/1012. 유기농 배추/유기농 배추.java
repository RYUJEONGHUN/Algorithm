
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		
		
		
		for(int i=0;i<T;i++) {
			count=0;
			String[] arg=br.readLine().split(" ");
			int M=Integer.parseInt(arg[0]);
			int N=Integer.parseInt(arg[1]);
			int K=Integer.parseInt(arg[2]);
			
			int[][] arr=new int[M][N];
			int[][] visited=new int[M][N];

			for(int j=0;j<K;j++) {
				String[] temp=br.readLine().split(" ");
				int a=Integer.parseInt(temp[0]);
				int b=Integer.parseInt(temp[1]);
				
				
				arr[a][b]=1;
				
			}
			
			
			
			for(int m=0;m<M;m++) {
				for(int n=0;n<N;n++) {
					if(arr[m][n]==1 && visited[m][n]!=1) {
						visited[m][n]=1;
						dfs(arr,visited,m,n);
						count++;
					}
					
				}
			}
			
			
			System.out.println(count);
			
		}
		
	}
	public static void dfs(int[][] graph,int[][] visited,int m,int n) {
		for(int i=0;i<4;i++) {
			int dx=m+x[i];
			int dy=n+y[i];
			
			if(dx>=0 && dx<graph.length && dy>=0 && dy<graph[0].length && graph[dx][dy]==1 && visited[dx][dy]!=1) {
				visited[dx][dy]=1;
				dfs(graph,visited,dx,dy);
			}
		}
		
	}

}
