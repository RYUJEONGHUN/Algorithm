
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[][] arr;
	static int max=10000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String[] temp=br.readLine().split(" ");
		
		n=Integer.parseInt(temp[0]);
		int m=Integer.parseInt(temp[1]);
		int r=Integer.parseInt(temp[2]);
		
		int[] item=new int[n+1];
		
		String[] itemp=br.readLine().split(" ");
		
		for(int i=1;i<=n;i++) {
			item[i]=Integer.parseInt(itemp[i-1]);
		}
		
		arr=new int[n+1][n+1];

		
		for(int i=0;i<r;i++) {
			String[] a=br.readLine().split(" ");
			int s=Integer.parseInt(a[0]);
			int e=Integer.parseInt(a[1]);
			int d=Integer.parseInt(a[2]);
			
			arr[s][e]=d;
			arr[e][s]=d;
		}
		
		int maxitem=0;
		
		for(int i=1;i<=n;i++) {
			int[] dist=new int[n+1];
			int[] vis=new int[n+1];
			
			Arrays.fill(dist, max);
			
			dist[i]=0;
			vis[i]=1;
			
			for(int a=1;a<=n;a++) {
				if(a==i) continue;
				if(arr[i][a]!=0) {
					dist[a]=arr[i][a];
				}
			}
			
			for(int j=1;j<n;j++) {
				int nextidx=nextindex(dist,vis);
				if(nextidx==-1) break;
				
				vis[nextidx]=1;
				
				for(int b=1;b<=n;b++) {
					if(vis[b]!=1 && arr[nextidx][b]!=0 && dist[b]> arr[nextidx][b]+dist[nextidx]) {
						dist[b]= arr[nextidx][b]+dist[nextidx];	
					}
				}
			}
			
			int t=0;
			for(int k=1;k<=n;k++) {
				if(m>=dist[k]) {
					t+=item[k];
				}
			}
			maxitem=Math.max(maxitem, t);
		}
		
		System.out.print(maxitem);
	}
	
	public static int nextindex(int[] dist,int[] vis) {
		int min=Integer.MAX_VALUE;
		int midx=-1;
		
		for(int i=1;i<=n;i++) {
			if(vis[i]!=1 && dist[i]!=max) {
				if(min>dist[i]) {
					min=dist[i];
					midx=i;
				}
			}
		}
		return midx;

	}
}
