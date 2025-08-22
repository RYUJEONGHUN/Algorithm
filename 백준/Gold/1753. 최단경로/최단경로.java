
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge1{
	int to;
    int w;
    Edge1(int to, int w) { this.to = to; this.w = w; }
}

class State1 implements Comparable<State1>{
	int node;
    int dist;
    State1(int node, int dist) { 
    	this.node = node; 
    	this.dist = dist; 
    }
    
    public int compareTo(State1 o) { 
    	return Integer.compare(this.dist, o.dist); 
    }
    
}

public class Main {
	static final int INF = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int V=Integer.parseInt(arg[0]);
		int E=Integer.parseInt(arg[1]);

		int K=Integer.parseInt(br.readLine());
		
		List<List<Edge1>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
		
		for(int i=0;i<E;i++) {
			String[] temp=br.readLine().split(" ");
			int u=Integer.parseInt(temp[0]);
			int v=Integer.parseInt(temp[1]);
			int w=Integer.parseInt(temp[2]);
			
			graph.get(u).add(new Edge1(v, w));
		}
		
		// Dijkstra
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[V + 1];
		
        PriorityQueue<State1> pq = new PriorityQueue<>();
        dist[K] = 0;
        pq.offer(new State1(K, 0));
        
        while (!pq.isEmpty()) {
            State1 cur = pq.poll();
            int u = cur.node;

            if (visited[u]) continue;        // already finalized
            visited[u] = true;

            for (Edge1 e : graph.get(u)) {
                int v = e.to;
                int nd = dist[u] + e.w;
                if (nd < dist[v]) {          // relax
                    dist[v] = nd;
                    pq.offer(new State1(v, nd));
                }
            }
        }
        
        for(int i=1;i<=V;i++) {
        	if(dist[i]==1000000000) {
        		System.out.println("INF");
        	}
        	else {
            	System.out.println(dist[i]);
        	}
        }
        
		
		
	}

}
