

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Eoint{
	int x;
	int y;
	public Eoint(int tx,int ty) {
		x=tx;
		y=ty;
	}
}

public class Main {
	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		char[][] arr=new char[N][N]; 
		int[][]	visited=new int[N][N];
		
	    for(int i=0;i<N;i++) {
			String arg=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=arg.charAt(j);
			}
		}
	    
	    int rcount=0;
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<N;j++) {
	    		if(arr[i][j]=='R' && visited[i][j]!=1) {
	    			bfsr(arr,visited,i,j);
	    			rcount++;
	    		}
	    		else if(arr[i][j]=='G' && visited[i][j]!=1) {
	    			bfsg(arr,visited,i,j);
	    			rcount++;
	    		}
	    		else if(arr[i][j]=='B' && visited[i][j]!=1) {
	    			bfsb(arr,visited,i,j);
	    			rcount++;
	    		}
	    	}
	    }
	    
	    visited=new int[N][N];
	    int xcount=0;
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<N;j++) {
	    		if((arr[i][j]=='R' || arr[i][j]=='G') && visited[i][j]!=1) {
	    			obfrg(arr,visited,i,j);
	    			xcount++;
	    		}
	    		else if(arr[i][j]=='B' && visited[i][j]!=1) {
	    			obfsb(arr,visited,i,j);
	    			xcount++;
	    		}
	    	}
	    }
	    
	    System.out.print(rcount+" "+xcount);
	}
	
	public static void bfsr(char[][] arr,int[][] visited,int m,int n) {
		
		Queue<Eoint> q=new LinkedList<Eoint>();
		q.add(new Eoint(m,n));
		
		while(!q.isEmpty()) {
			Eoint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && visited[dx][dy]!=1 ) {
					if(arr[dx][dy]=='R') {
						q.add(new Eoint(dx,dy));
						visited[dx][dy]=1;
					}
				}
			}	
		}
	}
	
	public static void bfsg(char[][] arr,int[][] visited,int m,int n) {
		
		Queue<Eoint> q=new LinkedList<Eoint>();
		q.add(new Eoint(m,n));
		
		while(!q.isEmpty()) {
			Eoint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && visited[dx][dy]!=1 ) {
					if(arr[dx][dy]=='G') {
						q.add(new Eoint(dx,dy));
						visited[dx][dy]=1;
					}
				}
			}	
		}
	}
	
	public static void bfsb(char[][] arr,int[][] visited,int m,int n) {
		
		Queue<Eoint> q=new LinkedList<Eoint>();
		q.add(new Eoint(m,n));
		
		while(!q.isEmpty()) {
			Eoint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && visited[dx][dy]!=1 ) {
					if(arr[dx][dy]=='B') {
						q.add(new Eoint(dx,dy));
						visited[dx][dy]=1;
					}
				}
			}	
		}
	}
	
	public static void obfrg(char[][] arr,int[][] visited,int m,int n) {
		
		Queue<Eoint> q=new LinkedList<Eoint>();
		q.add(new Eoint(m,n));
		
		while(!q.isEmpty()) {
			Eoint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && visited[dx][dy]!=1 ) {
					if(arr[dx][dy]=='R' || arr[dx][dy]=='G') {
						q.add(new Eoint(dx,dy));
						visited[dx][dy]=1;
					}
				}
			}	
		}
	}
	
	public static void obfsb(char[][] arr,int[][] visited,int m,int n) {
		
		Queue<Eoint> q=new LinkedList<Eoint>();
		q.add(new Eoint(m,n));
		
		while(!q.isEmpty()) {
			Eoint current=q.poll();
			for(int i=0;i<4;i++) {
				int dx=current.x+x[i];
				int dy=current.y+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && visited[dx][dy]!=1 ) {
					if(arr[dx][dy]=='B') {
						q.add(new Eoint(dx,dy));
						visited[dx][dy]=1;
					}
				}
			}
			
		}
	}
	

}
