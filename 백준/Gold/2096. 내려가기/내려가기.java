
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n][3];
		
		int[][] dpma=new int[n][3];
		int[][] dpmi=new int[n][3];
		
		for(int a=0;a<n;a++) {
			String[] arg=br.readLine().split(" ");
			for(int i=0;i<3;i++) {
				arr[a][i]=Integer.parseInt(arg[i]);
			}
		}
		
		dpma[0][0]=arr[0][0];
		dpma[0][1]=arr[0][1];
		dpma[0][2]=arr[0][2];
		
		dpmi[0][0]=arr[0][0];
		dpmi[0][1]=arr[0][1];
		dpmi[0][2]=arr[0][2];
		
		
		for(int i=1;i<n;i++) {
			dpma[i][0]=Math.max(dpma[i-1][0]+arr[i][0], dpma[i-1][1]+arr[i][0]);
			dpma[i][1]=Math.max(dpma[i-1][0]+arr[i][1], Math.max(dpma[i-1][1]+arr[i][1], dpma[i-1][2]+arr[i][1]));
			dpma[i][2]=Math.max(dpma[i-1][1]+arr[i][2], dpma[i-1][2]+arr[i][2]);

			dpmi[i][0]=Math.min(dpmi[i-1][0]+arr[i][0], dpmi[i-1][1]+arr[i][0]);
			dpmi[i][1]=Math.min(dpmi[i-1][0]+arr[i][1], Math.min(dpmi[i-1][1]+arr[i][1], dpmi[i-1][2]+arr[i][1]));
			dpmi[i][2]=Math.min(dpmi[i-1][1]+arr[i][2], dpmi[i-1][2]+arr[i][2]);
		}
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int j=0;j<3;j++) {
			max=Math.max(max, dpma[n-1][j]);
		}
		
		for(int j=0;j<3;j++) {
			min=Math.min(min, dpmi[n-1][j]);
		}
		
		System.out.print(max+" "+min);
	}

}
