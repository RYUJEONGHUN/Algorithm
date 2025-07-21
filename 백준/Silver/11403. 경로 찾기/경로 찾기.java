
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N][N];
		
		int[] visited=new int[N];
		
		
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);	
			}
		}
		bfs(arr,visited);
		
	}
	
	public static void bfs(int[][] graph,int[] visited) {
		
		int size=graph.length;
		for(int i=0;i<size;i++) {
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(i);
			visited=new int[size];
			while(!q.isEmpty()) {
				int c=q.poll();
				for(int j=0;j<graph.length;j++) {
					if(graph[c][j]==1 && visited[j]!=1) {
						q.add(j);
						graph[i][j]=1;
						visited[j]=1;
					}
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
