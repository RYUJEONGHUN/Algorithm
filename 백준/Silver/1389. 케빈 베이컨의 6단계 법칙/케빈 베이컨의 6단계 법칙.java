

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Pont{
	int start;
	int level;
	public Pont(int tstart,int tlevel){
		start=tstart;
		level=tlevel;
	}
}
public class Main {

	static int count=0;
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
		
		int min=Integer.MAX_VALUE;
		int value=0;
		for(int i=1;i<=N;i++) {
			count=0; 
			visited=new int[N+1];
			bfs(arr,visited,i);
			if(min>count) {
				min=count;
				value=i;
			}
		}
		System.out.println(value);
		
	}
	
	public static void bfs(int[][] graph,int[] visited,int start) {
		Queue<Pont> q=new LinkedList<Pont>();
		q.add(new Pont(start,0));
		visited[start]=1;
		
		while(!q.isEmpty()) {
			Pont current=q.poll();
			int cx=current.start;
			int cl=current.level;
			count=count+cl;
			for(int i=1;i<graph[0].length;i++) {
				if(graph[cx][i]==1 && visited[i]!=1) {
					q.add(new Pont(i,cl+1));
					visited[i]=1;
				}
			}
		}
	}

}
