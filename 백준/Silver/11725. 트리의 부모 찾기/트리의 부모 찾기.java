
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] arr;
	static int[] visited;
	static int[] c;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N + 1];
		visited=new int[N+1];
		
		c=new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=1;i<N;i++) {
			String[] arg=br.readLine().split(" ");
			int a=Integer.parseInt(arg[0]);
			int b=Integer.parseInt(arg[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		visited[1]=1;
		dfs(1);
		
		for(int i=2;i<=N;i++) {
			System.out.println(c[i]);
		}
	}
	
	public static void dfs(int n) {
		for(int next:arr[n]) {
			if( visited[next]!=1) {
				visited[next]=1;
				c[next]=n;
				dfs(next);
			}
		}
	}

}
