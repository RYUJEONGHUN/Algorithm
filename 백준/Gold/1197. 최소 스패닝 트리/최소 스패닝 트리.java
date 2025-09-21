
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Eddge implements Comparable<Eddge>{
	int u,v;
	int w;
	public Eddge(int u,int v,int w) {
		this.u=u;
		this.v=v;
		this.w=w;
	}
	public int compareTo(Eddge other) {
		return Integer.compare(this.w, other.w);
	}
}

class DSU{
	int[] parent;
	int[] rank;
	
	DSU(int n){
		parent=new int[n+1];
		rank=new int[n+1];
		for(int i=0;i<=n;i++) {
			parent[i]=i;
		}
	}
	
	int find(int x){
		if(parent[x]!=x) return find(parent[x]);
		return parent[x];
	}
	
	boolean union(int x,int y){
		int rx=find(x);
		int ry=find(y);
		
		if(rx==ry) {
			return false;
		}
		if(rank[rx]>rank[ry]) {
			parent[ry]=rx;
		}else if(rank[rx]<rank[ry]) {
			parent[rx]=ry;
		}
		else {
			parent[ry]=rx;
			rank[rx]++;
		}
		return true;
	}
	
}


public class Main {

	public static List<Eddge> mst(int n,List<Eddge> edges){
		Collections.sort(edges);
		DSU dsu=new DSU(n);
		
		List<Eddge> T=new ArrayList<Eddge>();
	
		for(Eddge e : edges) {
			if(e.u==e.v) continue;
			if (dsu.union(e.u, e.v)) {
                T.add(e);
                if (T.size() == n - 1) break; // MST complete if connected
            }
		}
		return T;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int V=Integer.parseInt(arg[0]);
		int E=Integer.parseInt(arg[1]);
		
		List<Eddge> arr=new ArrayList<Eddge>();
		
		
		for(int i=0;i<E;i++) {
			String[] temp=br.readLine().split(" ");
			int A=Integer.parseInt(temp[0]);
			int B=Integer.parseInt(temp[1]);
			int C=Integer.parseInt(temp[2]);
			
			arr.add(new Eddge(A,B,C));	
		}
		List<Eddge> T = mst(V, arr);
		
		int sum = 0;
        for (Eddge e : T) sum += e.w;
        System.out.println(sum); 
	}
}
