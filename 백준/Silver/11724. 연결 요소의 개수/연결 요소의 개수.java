

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
		
		int[][] arr=new int[N+1][N+1];
		
		int[] visited=new int[N+1];
		
		for(int i=0;i<M;i++) {
			String[] temp=br.readLine().split(" ");
			int a=Integer.parseInt(temp[0]);
			int b=Integer.parseInt(temp[1]);
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		int count=0;
		for(int i=1;i<=N;i++) {
			if(visited[i]!=1) {
				bfs(arr,visited,i);
				count++;
			}
		}
		System.out.println(count);
		
	}
	public static void bfs(int[][] graph,int[] visited,int m) {
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.add(m);
		visited[m]=1;
		while(!q.isEmpty()) {
			int current=q.poll();
			for(int j=1;j<graph[0].length;j++) {
				if(graph[current][j]==1 && visited[j]!=1) {
					q.add(j);
					visited[j]=1;
				}
			}
		}
		
	}
}
