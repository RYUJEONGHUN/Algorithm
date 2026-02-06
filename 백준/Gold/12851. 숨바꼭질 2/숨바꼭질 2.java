
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		int N=Integer.parseInt(temp[0]);
		int K=Integer.parseInt(temp[1]);
		
		int[] dist=new int[100001];
		int[] way=new int[100001];
		
		Arrays.fill(dist, -1);
		
		Queue<Integer> q=new LinkedList<Integer>();
		
		dist[N]=0;
		way[N]=1;
		q.add(N);
		
		while(!q.isEmpty()) {
			int v=q.poll();
			
			int[] next= {v*2,v-1,v+1};
			
			for(int n:next) {
				if(n<0 || n>100000 ) {
					continue;
				}
				
				if(dist[n]==-1) {
					dist[n]=dist[v]+1;
					way[n]=way[v];
					q.add(n);
				}
				else {
					if(dist[n]==dist[v]+1) {
						way[n]+=way[v];
					}
				}
				
			}
			
		}
		System.out.println(dist[K]);
		System.out.println(way[K]);
		
	}

}
