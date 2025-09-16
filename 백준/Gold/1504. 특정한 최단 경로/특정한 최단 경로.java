
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


class Edge3{
	int w;
	int to;
	
	public Edge3(int to,int w) {
		this.w=w;
		this.to=to;
	}
}

class State3 implements Comparable<State3>{
	
	int node;
	int dist;
	
	public State3(int node,int dist) {
		this.node=node;
		this.dist=dist;
	}
	
	public int compareTo(State3 o) {
		return Integer.compare(this.dist, o.dist);
	}
}

public class Main {

	static final int INF = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		
		int N=Integer.parseInt(temp[0]);
		int E=Integer.parseInt(temp[1]);
		
		int[] dist1=new int[N+1];
		int[] distV1=new int[N+1];
		int[] distV2=new int[N+1];
		
		int[] visited1=new int[N+1];
		int[] visited2=new int[N+1];
		int[] visited3=new int[N+1];

		
		List<ArrayList<Edge3>> arr=new ArrayList<ArrayList<Edge3>>();
		
		for(int i=0;i<=N;i++) {
			arr.add(new ArrayList<Edge3>());
		}
		
		Arrays.fill(dist1, INF);
		Arrays.fill(distV1, INF);
		Arrays.fill(distV2, INF);
		
		for(int i=0;i<E;i++) {
			String[] arg=br.readLine().split(" ");
			
			int a=Integer.parseInt(arg[0]);
			int b=Integer.parseInt(arg[1]);
			int c=Integer.parseInt(arg[2]);
			
			arr.get(a).add(new Edge3(b,c));
			arr.get(b).add(new Edge3(a,c));
		}
		
		String[] c=br.readLine().split(" ");
		int v1=Integer.parseInt(c[0]);
		int v2=Integer.parseInt(c[1]);

		
		
		PriorityQueue<State3> q=new PriorityQueue<State3>();
		
		dist1[1]=0;
		q.add(new State3(1,0));
		while(!q.isEmpty()) {
			State3 cur=q.poll();
			
			int cn=cur.node;
			int cb=cur.dist;
			
			 if (visited1[cn]==1) continue;        // already finalized
			 visited1[cn] = 1;
			
			for(Edge3 e:arr.get(cn)) {
				int cw=e.w;
				int cto=e.to;
								
				if(dist1[cto]>cb+cw) {
					dist1[cto]=cb+cw;
					q.add(new State3(cto,dist1[cto]));
				}
			}
		}
		
		PriorityQueue<State3> qv1=new PriorityQueue<State3>();
		
		qv1.add(new State3(v1,0));
		distV1[v1]=0;
		while(!qv1.isEmpty()) {
			State3 cur=qv1.poll();
			
			int cn=cur.node;
			int cb=cur.dist;
			
			 if (visited2[cn]==1) continue;        // already finalized
			 visited2[cn] = 1;
			
			for(Edge3 e:arr.get(cn)) {
				int cw=e.w;
				int cto=e.to;
				
				if(distV1[cto]>cb+cw) {
					distV1[cto]=cb+cw;
					qv1.add(new State3(cto,distV1[cto]));
				}
			}
		}
		
		
		
		PriorityQueue<State3> qv2=new PriorityQueue<State3>();
		
		qv2.add(new State3(v2,0));
		distV2[v2]=0;
		while(!qv2.isEmpty()) {
			State3 cur=qv2.poll();
			
			int cn=cur.node;
			int cb=cur.dist;
			
			 if (visited3[cn]==1) continue;        // already finalized
			 visited3[cn] = 1;
			
			for(Edge3 e:arr.get(cn)) {
				int cw=e.w;
				int cto=e.to;
				
				if(distV2[cto]>cb+cw) {
					distV2[cto]=cb+cw;
					qv2.add(new State3(cto,distV2[cto]));
				}
			}
		}
		
		
		long A = (long) dist1[v1] + distV1[v2] + distV2[N]; // 1->v1->v2->N
		long B = (long) dist1[v2] + distV2[v1] + distV1[N]; // 1->v2->v1->N

		boolean okA = dist1[v1] < INF && distV1[v2] < INF && distV2[N] < INF;
		boolean okB = dist1[v2] < INF && distV2[v1] < INF && distV1[N] < INF;

		if (!okA && !okB) {
		    System.out.println(-1);
		} else if (okA && okB) {
		    System.out.println(Math.min(A, B));
		} else {
		    System.out.println(okA ? A : B);
		}
		
	}

}
