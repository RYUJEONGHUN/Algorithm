
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Faoint {
	int x;
	int level;
	Faoint(int x,int level){
		this.x=x;
		this.level=level;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int K=Integer.parseInt(arg[1]);
		int result=-1;
		int[] visited=new int[1000001];
		
		Queue<Faoint> q=new LinkedList<Faoint>();
		
		q.add(new Faoint(N,0));
		visited[N]=1;
		
		while(!q.isEmpty()) {
			Faoint c=q.poll();
			
			int cx=c.x;
			int clevel=c.level;

			if(cx==K) {
				result=clevel;
				break;
			}
			int cm=cx-1;
			int cp=cx+1;
			int tc=2*cx;
			
			if(tc>=0 && tc<=100000 && visited[tc]!=1) {
				q.add(new Faoint(tc,clevel));
				visited[tc]=1;
			}
			if(cm>=0 && cm<=100000 && visited[cm]!=1) {
				q.add(new Faoint(cm,clevel+1));
				visited[cm]=1;
			}
			if(cp>=0 && cp<=100000 && visited[cp]!=1) {
				q.add(new Faoint(cp,clevel+1));
				visited[cp]=1;
			}
			
		}
		System.out.print(result);
	}

}
