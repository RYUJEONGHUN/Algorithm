

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]);
		
		M=Integer.parseInt(arg[1]);
		

		int[] arr=new int[N];
			
		int[] visited=new int[N];
		int[] stack=new int[N];
		
		String[] temp=br.readLine().split(" ");
		
		for(int j=0;j<N;j++) {
			arr[j]=Integer.parseInt(temp[j]);
		}
		Arrays.sort(arr);
		
		dfs(arr,visited,0,stack);
		
	}
	
	public static void dfs(int[] graph,int[] visited,int count,int[] stack) {
		
		if(count==M) {
			for(int i=0;i<M;i++) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<graph.length;i++) {
			if(visited[i]!=1) {
				stack[count]=graph[i];
				visited[i]=1;
				dfs(graph,visited,count+1,stack);
				visited[i]=0;
			}
		}
	}

}
