
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge2{
	int to;
	int w;
	
	Edge2(int to,int w) {
		this.to=to;
		this.w=w;
	}
}

class State2 implements Comparable<State2>{
	int node;
	int dist;
	
	State2(int node,int dist){
		this.node=node;
		this.dist=dist;
	}
	
	public int compareTo(State2 o) {
		return Integer.compare(this.dist, o.dist);
	}
}


public class Main {

	static final int INF=100_000_000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int M=Integer.parseInt(br.readLine());
		
		List<List<Edge2>> graph=new ArrayList<List<Edge2>>(N+1);
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			String[] temp=br.readLine().split(" ");
			
			int s=Integer.parseInt(temp[0]);
			int t=Integer.parseInt(temp[1]);
			int w=Integer.parseInt(temp[2]);
					
			graph.get(s).add(new Edge2(t,w));
		}
		
		boolean[] visited=new boolean[N+1];
		int[] dist=new int[N+1];
		
		
		Arrays.fill(dist, INF);
		
		PriorityQueue<State2> pr=new PriorityQueue<State2>();
		
		String[] arg=br.readLine().split(" ");
		
		int start=Integer.parseInt(arg[0]);
		int end=Integer.parseInt(arg[1]);
		
		dist[start]=0;
		pr.offer(new State2(start,0));
		
		while(!pr.isEmpty()) {
			State2 cur=pr.poll();
			int u=cur.node;
			
			if(visited[u]) {
				continue;
			}
			visited[u]=true;
			
			for(Edge2 e:graph.get(u)) {
				int v=e.to;
				int nd=dist[u]+e.w;
				
				if(dist[v]>nd) {
					dist[v]=nd;
					pr.offer(new State2(v,nd));
				}
			}
		}
		
		System.out.print(dist[end]);
		
	}

}
