
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		arr=new char[N][2*N-1];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		draw(0,N-1,N);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<2*N-1;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void draw(int x,int y,int h) {
		if(h==3) {
			arr[x][y]='*';
			
			arr[x+1][y-1]='*';
			arr[x+1][y+1]='*';
			
			arr[x+2][y-2]='*';
			arr[x+2][y-1]='*';
			arr[x+2][y]='*';
			arr[x+2][y+1]='*';
			arr[x+2][y+2]='*';
			return;
		}
		draw(x,y,h/2);
		draw(x+h/2,y-h/2,h/2);
		draw(x+h/2,y+h/2,h/2);
		
	}

}
