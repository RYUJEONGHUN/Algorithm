
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Tr{
	int y;
	int x;
	public Tr(int y,int x) {
		this.y=y;
		this.x=x;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int INF=Integer.MAX_VALUE;
		ArrayList<Tr> s=new ArrayList<Tr>();
				
		int N=Integer.parseInt(br.readLine());
		
		int[][] dp=new int[N+1][N+1];
		
		s.add(new Tr(0,0));
		
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			
			int r=Integer.parseInt(temp[0]);
			int c=Integer.parseInt(temp[1]);
			
			s.add(new Tr(r,c));
		}
		
		
		for(int i=1;i<=N;i++) {
			dp[i][i]=0;
		}
		
		for(int L=1;L<N;L++) {
			for(int i=1;i+L<=N;i++) {
				int j=i+L;
				dp[i][j]=INF;
				
				for(int k=i;k<j;k++) {
					int temp=dp[i][k]+dp[k+1][j]+(s.get(i).y)*(s.get(k).x)*(s.get(j).x);
					if(temp<dp[i][j]) {
						dp[i][j]=temp;
					}
				}
			}
		}
		
		System.out.print(dp[1][N]);
	}

}
