
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int M=Integer.parseInt(arg[1]);
		int B=Integer.parseInt(arg[2]);
		
		int[][] arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
				
		int tsum=0;
		int st=0;
		int min=Integer.MAX_VALUE;
		int block=0;
		int firstB=B;
		for(int i=0;i<=256;i++) {
			block=0;
			tsum=0;
			B=firstB;
			for(int c=0;c<N;c++) {
				for(int d=0;d<M;d++) {
					int diff=arr[c][d]-i;
					
					if(diff>=0) {
						tsum+=diff*2;
						B+=diff;
					}
					else {
						tsum+=(-1)*diff;
						block+=(-1)*diff;
					}
				}
			}
			
			
			if(block>B) {
				break;
			}
			
			if(min>=tsum) {
				min=tsum;
				st=i;
			}
		}

		
		System.out.print(min+" "+st);
	}

}
