
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	static int R;
	static int C;
	static int[][] visited;
	static char[][] arr;
	static int m=Integer.MIN_VALUE;
	static HashSet<Character> s= new HashSet<Character>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		R=Integer.parseInt(temp[0]);
		C=Integer.parseInt(temp[1]);
		
		visited=new int[R][C];
		
		arr=new char[R][C];
		
		for(int i=0;i<R;i++) {
			String t=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=t.charAt(j);
			}
		}
		
		s.add(arr[0][0]);
		visited[0][0]=1;
		dfs(0,0,1);
			
		System.out.print(m);
	}
	
	public static void dfs(int ty,int tx,int level) {
		for(int i=0;i<4;i++) {
			int ry=ty+y[i];
			int rx=tx+x[i];
			if(ry>=0 && ry<=R-1 && rx>=0 && rx<=C-1 && visited[ry][rx]!=1) {
				if(!s.contains(arr[ry][rx])) {
					s.add(arr[ry][rx]);
					visited[ry][rx]=1;
				
					dfs(ry,rx,level+1);
				}
				else {
					continue;
				}
	
			}
			m=Math.max(m, level);
		}
		s.remove(arr[ty][tx]);
		visited[ty][tx]=0;
	}

}
