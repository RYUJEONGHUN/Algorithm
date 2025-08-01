
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	static int[] arr;
	static int[] visited;
	static int[] r;
	static int M;
	static int N;
	static HashSet<String> a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]);
		M=Integer.parseInt(arg[1]);
		
		arr=new int[N];
		visited=new int[N];
		
		
		r=new int[M];
		a=new HashSet<String>();
		
		String[] temp=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		Arrays.sort(arr);
		
		dfs(0);
		
	}
	public static void dfs(int node) {
		if(node==M) {
			StringBuilder sb = new StringBuilder();
			for(int temp:r) {
				sb.append(temp).append(' ');
			}
			String key=sb.toString();
			if(!a.contains(key)) {
				for(int j=0;j<M;j++) {
					System.out.print(r[j]+" ");
				}
				a.add(key);
				System.out.println();
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]!=1) {
				visited[i]=1;
				r[node]=arr[i];
				dfs(node+1);
				visited[i]=0;
			}
		}
	}

} 
