
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int m=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			String[] temp=br.readLine().split(" ");
			int d=Integer.parseInt(temp[0]);
			int a=Integer.parseInt(temp[1]);
			int c=Integer.parseInt(temp[2]);
			
			if(arr[d][a]==0) {
				arr[d][a]=c;
			}else {
				arr[d][a]=Math.min(arr[d][a], c);
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			int[] v=new int[n+1];
			v[i]=1;
			int[] dist=new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[i]=0;
			for(int j=1;j<=n;j++) {
				if(arr[i][j]!=0) {
					dist[j]=arr[i][j];
				}
			}
			
			
			for(int a=0;a<n-1;a++) {
				int si=getSmallindex(dist,v);
			    if (si == -1 || dist[si] == Integer.MAX_VALUE) break;

			    v[si] = 1;
			    for(int b=1;b<=n;b++) {
			        if(v[b]!=1 && arr[si][b]!=0) {
			            if (dist[si] != Integer.MAX_VALUE) {
			                dist[b] = Math.min(dist[b], dist[si] + arr[si][b]);
			            }
			        }
			    }
			}
			
			for(int j=1;j<=n;j++) {
				if(dist[j]==Integer.MAX_VALUE) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(dist[j]+" ");
				}
			}
			System.out.println();
		}
		
	}
	public static int getSmallindex(int[] dist, int[] v) {
		int n=dist.length-1;
		int min=Integer.MAX_VALUE;
		int value=-1;
		
		for(int a=1;a<=n;a++) {
			if((v[a]!=1) && (min>dist[a])) {
				min=dist[a];
				value=a;
			}
		}
		return value;
	}

}
