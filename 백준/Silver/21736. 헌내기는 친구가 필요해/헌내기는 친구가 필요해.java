

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Poiint{
	int x;
	int y;
	public Poiint(int tx,int ty){
		x=tx;
		y=ty;
	}
}

public class Main {
	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	static int count=0;
	public static void main(String[] args) throws IOException {	
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		
		Character[][] arr=new Character[N][M];
		int[][] visited=new int[N][M];
		
		int m=0;
		int n=0;
		
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=temp.charAt(j);
				if(arr[i][j]=='I') {
					m=i;
					n=j;
				}
			}
		}
		
		bfs(arr,visited,m,n);
		
		if(count==0) {
			System.out.print("TT");
		}
		else {
			System.out.print(count);
		}
		
			
	}
	
	public static void bfs(Character[][] graph,int[][] visited,int m,int n) {
		Queue<Poiint> q=new LinkedList<Poiint>();
		visited[m][n]=1;
		Poiint p=new Poiint(m,n);
		q.add(p);
		while(!q.isEmpty()) {
			Poiint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<graph.length && dy>=0 && dy<graph[0].length) {
					if(graph[dx][dy]!='X'&& visited[dx][dy]!=1) {
						q.add(new Poiint(dx,dy));
						visited[dx][dy]=1;
						if(graph[dx][dy]=='P') {
							count++;
						}
					}
				}
			}
		}
		
	}
}
