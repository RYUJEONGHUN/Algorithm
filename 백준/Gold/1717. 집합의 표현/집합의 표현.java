
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		
		int n=Integer.parseInt(arg[0]);
		int m=Integer.parseInt(arg[1]);
		
		
		parent=new int[n+1];
		
		for(int j=1;j<=n;j++) {
			parent[j]=j;
		}
		
		for(int i=0;i<m;i++) {
			String[] temp=br.readLine().split(" ");
			
			int f=Integer.parseInt(temp[0]);
			
			int a=Integer.parseInt(temp[1]);
			int b=Integer.parseInt(temp[2]);
			
			if(f==0) {
				union(a,b);
			}
			else {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
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
