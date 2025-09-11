
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int M=Integer.parseInt(br.readLine());
		
		parent=new int[N+1];
		
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=1;i<=N;i++) {
			String[] temp=br.readLine().split(" ");
			
			for(int j=1;j<=N;j++) {
				int a=Integer.parseInt(temp[j-1]);
				
				if(a==1) {
					union(i,j);
				}
			}
		}
		
		String[] a=br.readLine().split(" ");

		boolean check=true;
		
		int t=find(Integer.parseInt(a[0]));
		
		for(int i=1;i<M;i++) {
			int v=find(Integer.parseInt(a[i]));
			
			if(t!=v) {
				check=false;
				break;
			}
			
		}
		
		if(check) {
			System.out.print("YES");
		}else {
			System.out.print("NO");
		}
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
		
		
		parent[ty]=tx;
	}

}
