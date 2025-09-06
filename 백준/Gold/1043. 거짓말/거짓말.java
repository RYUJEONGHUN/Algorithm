
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		
		List<Integer> s=new ArrayList<Integer>();
				
		String[] temp=br.readLine().split(" ");
		
		int tn=Integer.parseInt(temp[0]);
		
		for(int i=1;i<=tn;i++) {
			int n=Integer.parseInt(temp[i]);
			s.add(n);
		}
		
		List<HashSet<Integer>> arr=new ArrayList<HashSet<Integer>>();
		
		for(int i=0;i<M;i++) {
			arr.add(new HashSet<Integer>());
		}
		
		int[][] arrb=new int[N+1][N+1];
		
		
		for(int i=0;i<M;i++) {
			String[] arrt=br.readLine().split(" ");
			
			int n=Integer.parseInt(arrt[0]);
			
			for(int j=0;j<n;j++) {
				int a=Integer.parseInt(arrt[j+1]);
				for(int k=0;k<n;k++) {
					int b=Integer.parseInt(arrt[k+1]);
					arrb[a][b]=1;
				}
			}
			
			for(int j=0;j<n;j++) {
				arr.get(i).add(Integer.parseInt(arrt[j+1]));
			}
		}
		
		
		for(int i=0;i<s.size();i++) {
			int[] visited=new int[N+1];
			
			int n=s.get(i);
			
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(n);
			
			while(!q.isEmpty()) {
				int c=q.poll();
				visited[c]=1;
				for(int j=1;j<=N;j++) {
					if(arrb[c][j]==1 && visited[j]!=1) {
						if(!s.contains(j)) {
							s.add(j);
						}
						q.add(j);
					}
				}
			}
			
		}
		
		
		int size=0;
		
		for(int i=0;i<arr.size();i++) {
			boolean check=true;
			for(int j=0;j<s.size();j++) {
				if(arr.get(i).contains(s.get(j))) {
					check=false;
					break;
				}
			}
			if(check)size++;
		}
		System.out.print(size);
	}

}
