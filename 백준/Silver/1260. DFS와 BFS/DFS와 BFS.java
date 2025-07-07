import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		int start=Integer.parseInt(arg[2]);
		
		int[][] arr=new int[N+1][N+1];
		int[] visited=new int[N+1];
		
		for(int i=0;i<M;i++) {
			String[] temp=br.readLine().split(" ");
			int n=Integer.parseInt(temp[0]);
			int m=Integer.parseInt(temp[1]);
			
			arr[n][m]=1;
			arr[m][n]=1;
		}
		
		dfs(arr,visited,start);
		System.out.println();
		visited=new int[N+1];
		bfs(arr,visited,start);
		
		
	}
	
	public static void dfs(int[][] graph,int[] visited,int start) {
		visited[start]=1;
		System.out.print(start+" ");
		for(int i=1;i<graph.length;i++) {
			if(graph[start][i]==1 && visited[i]!=1) {		
				dfs(graph,visited,i);
			}
		}
	}
	
	public static void bfs(int[][] graph,int[] visited,int start) {
		visited[start]=1;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int current=queue.poll();
			System.out.print(current+" ");
			for(int i=1;i<graph.length;i++) {
				if(graph[current][i]==1 && visited[i]!=1) {
					queue.add(i);
					visited[i]=1;
				}
			}
		}
	}

}
