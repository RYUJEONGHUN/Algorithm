
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Edddge implements Comparable<Edddge>{
	int to;
	int w;
	public Edddge(int to,int w){
		this.to=to;
		this.w=w;
	}
	
	public int compareTo(Edddge o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Main {
	static int INF=100_000_000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		int[] vis=new int[N+1];
		
		List<ArrayList<Edddge>> arr=new ArrayList<ArrayList<Edddge>>();
		
		for(int i=0;i<=N;i++) {
			arr.add(new ArrayList<Edddge>());
		}
		
		PriorityQueue<Edddge> q=new PriorityQueue<Edddge>();
		
		int[] dist=new int[N+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=0;i<M;i++) {
			String[] arg=br.readLine().split(" ");
			int a=Integer.parseInt(arg[0]);
			int b=Integer.parseInt(arg[1]);
			int c=Integer.parseInt(arg[2]);
			
			arr.get(a).add(new Edddge(b,c));
			arr.get(b).add(new Edddge(a,c));
		}
		
		HashSet<Integer> s=new HashSet<Integer>();
		
		vis[1]=1;
		s.add(1);
		dist[1]=0;
		for(Edddge e:arr.get(1)) {
			q.add(e);
			if(e.w<dist[e.to]) {
				dist[e.to]=e.w;
			}
		}
		
		while(!q.isEmpty() && s.size()<N) {
			Edddge cur=q.poll();
			int cw=cur.w;
			int ct=cur.to;
			s.add(ct);
			if(vis[ct]==1) {
				continue;
			}
			vis[ct]=1;
			
			if(cw<dist[ct]) {
				dist[ct]=cw;
			}
			
			for(Edddge e:arr.get(ct)) {
				int tt=e.to;
				int tw=e.w;
				
				if(vis[tt]==1) {
					continue;
				}
				
				q.add(e);
			}
			
		}
		int sum=0;
		for(int i=1;i<=N;i++) {
			sum+=dist[i];
		}
		System.out.print(sum);
	}
	

}
