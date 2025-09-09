
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] parent;
	static List<Integer> r;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		List<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		r=new ArrayList<Integer>();
		
		String[] rt=br.readLine().split(" ");
		
		int pn=Integer.parseInt(rt[0]);
		
		for(int i=1;i<=pn;i++) {
			r.add(Integer.parseInt(rt[i]));
		}
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		
		parent=new int[N+1];
		
		for(int a=0;a<M;a++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
	
		
		for(int j=0;j<M;j++) {
			
			String[] temp=br.readLine().split(" ");
			
			int m=Integer.parseInt(temp[0]);
			
			int f=Integer.parseInt(temp[1]);
			arr.get(j).add(f);
			
			for(int a=2;a<=m;a++) {
				int b=Integer.parseInt(temp[a]);
				union(f,b);
				arr.get(j).add(b);
			}
		}
		
		int cnt=0;
		for(int a=0;a<M;a++) {
			boolean flag=true;
			int size=arr.get(a).size();
			
			for(int b=0;b<size;b++) {
				if(r.contains(find(arr.get(a).get(b)))) {
					flag=false;
					break;
				}
			}
			
			if(flag) {
				cnt++;
			}
		}
		System.out.print(cnt);
	}
	
	public static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		
		return find(parent[x]);
	}
	
	
	public static void union(int x,int y) {
		int tx=find(x);
		int ty=find(y);
		
		if(r.contains(ty)) {
			parent[tx]=ty;
			return;
		}
		
		parent[ty]=tx;
		return;
	}

}
