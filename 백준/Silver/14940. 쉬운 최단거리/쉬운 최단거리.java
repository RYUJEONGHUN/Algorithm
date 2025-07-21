
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Koint{
	int x=0;
	int y=0;
	int l=0;
	
	public Koint(int tx,int ty,int tl) {
		x=tx;
		y=ty;
		l=tl;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] x= {-1,0,1,0};
		int[] y= {0,1,0,-1};
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		int n=Integer.parseInt(temp[0]);
		int m=Integer.parseInt(temp[1]);
		
		int[][] arr=new int[n][m];
		int[][] r=new int[n][m];
		int[][] visited=new int[n][m];
		
		int tn=0;
		int tm=0;
		
		for(int i=0;i<n;i++) {
			String[] arg=br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(arg[j]);
				if(arr[i][j]==2) {
					tn=i;
					tm=j;
				}
			}
		}
		
		Queue<Koint> q=new LinkedList<Koint>();
		 
		q.add(new Koint(tm,tn,0));
		r[tn][tm]=0;
		visited[tn][tm]=1;
		
		while(!q.isEmpty()) {
			Koint current=q.poll();
			int tx=current.x;
			int ty=current.y;
			int tl=current.l;
			for(int i=0;i<4;i++) {
				int dx=tx+x[i];
				int dy=ty+y[i];
				
				if(dx>=0 && dx<arr[0].length && dy>=0 && dy<arr.length && arr[dy][dx]==1 && visited[dy][dx]!=1) {
					q.add(new Koint(dx,dy,tl+1));
					visited[dy][dx]=1;
					r[dy][dx]=tl+1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1 && visited[i][j]==0) {
					System.out.print(-1+" ");
				}
				else {
					System.out.print(r[i][j]+" ");
				}
				
			}
			System.out.println();
		}
	}

}
