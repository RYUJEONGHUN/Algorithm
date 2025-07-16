
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	static int count=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String arg=br.readLine();
		
		int N=Integer.parseInt(arg);
		
		int[][] arr=new int[N][N];
		
		int[][] visited=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=temp.charAt(j)-'0';
			}
		}
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1 && visited[i][j]!=1) {
					visited[i][j]=1;
					count++;
					dfs(arr,visited,i,j);
					a.add(count);
					count=0;
				}
			}
		}
		int size=a.size();
		System.out.println(size);
		Collections.sort(a);
		
		for(int k=0;k<size;k++) {
			System.out.println(a.get(k));
		}
	}
	
	public static void dfs(int[][] graph,int[][] visited,int m,int n) {
		
		for(int i=0;i<4;i++) {
			int dx=m+x[i];
			int dy=n+y[i];
			
			if(dx>=0 && dx<graph.length && dy>=0 && dy<graph[0].length ) {
				if(graph[dx][dy]==1 && visited[dx][dy]!=1 ) {
					visited[dx][dy]=1;
					count++;
					dfs(graph,visited,dx,dy);
				}
			}
			
		}
	}

}
