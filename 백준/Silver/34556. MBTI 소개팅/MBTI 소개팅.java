
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] vis;
	static int[][] arr;
	static ArrayList<Integer> a=new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		 
		String[] m=new String[N];
		String[] f=new String[N];
		
		for(int i=0;i<N;i++) {
			m[i]=br.readLine();
		}
		for(int i=0;i<N;i++) {
			f[i]=br.readLine();
		}
		arr=new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			String ma=m[i];
			for(int j=0;j<N;j++) {
				int sum=0;
				String fa=f[j];
				for(int a=0;a<4;a++) {
					if(ma.charAt(a)!=fa.charAt(a)) {
						sum++;
					}
				}
				arr[j][i]=sum;
			}
		}
		
		
		
		vis=new int[N];
		
		dfs(N,0,0);
		
		int max=0;
		for(int i=0;i<a.size();i++) {
			max=Math.max(max, a.get(i));
		}
		System.out.print(max);
	}

	public static void dfs(int N,int level,int sum) {
		if(level==N) {
			a.add(sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(vis[i]==0) {
				vis[i]=1;
				dfs(N,level+1,sum+arr[i][level]);
				vis[i]=0;
			}
			
		}
	}
}
