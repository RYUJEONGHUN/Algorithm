

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Roint{

	int x;
	int y;
	int s;
	public Roint(int tx,int ty,int ts) {
		x=tx;
		y=ty;
		s=ts;
	}
}

public class Main {
	static int[] x= {-1,0,1,0};
	static int[] y= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int M=Integer.parseInt(arg[0]);
		int N=Integer.parseInt(arg[1]);
		
		int[][] arr=new int[N][M];
		
		int[][] visited=new int[N][M];
		
		Queue<Roint> q=new LinkedList<Roint>();
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);
				if(arr[i][j]==1) {
					q.add(new Roint(j,i,0));
					visited[i][j]=1;
				}
			}
		}
				
		
		if(q.size()==0) {
			System.out.print(-1);
		}
		else {
			int result=0;
			while(!q.isEmpty()){
				Roint current=q.poll();
				for(int i=0;i<4;i++) {
					int dx=current.x+x[i];
					int dy=current.y+y[i];
					int dc=current.s;
					result=dc;
					if(dx>=0 && dx<M && dy>=0 && dy<N && arr[dy][dx]==0 && visited[dy][dx]!=1) {
						arr[dy][dx]=1;
						q.add(new Roint(dx,dy,dc+1));
						visited[dy][dx]=1;
					}
				}
			}
			
			/*for (int i = 0; i < N; i++) {
				System.out.println();
			    for (int j = 0; j < M; j++) {
			    	System.out.print(arr[i][j]+" ");
			    }
			}*/
	
			boolean allRipe = true;
			outer:
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < M; j++) {
			        if (arr[i][j] == 0) {
			            allRipe = false;
			            break outer;
			        }
			    }
			}
			
			if (allRipe==true) {
			    System.out.print(result);
			} else {
			    System.out.print(-1);
			}
		}
		
		
	}

}
