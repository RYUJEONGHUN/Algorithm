
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s1=br.readLine();
		String s2=br.readLine();
		
		int s1n=s1.length();
		int s2n=s2.length();
		
		int[][] arr=new int[s2n+1][s1n+1];		

		for(int i=0;i<=s1n;i++) {
			arr[0][i]=0;
		}
		
		for(int j=0;j<=s2n;j++) {
			arr[j][0]=0;
		}
		
		//System.out.print("ok");
		
		for(int a=1;a<=s2n;a++) {
			for(int b=1;b<=s1n;b++) {
				if(s1.charAt(b-1)==s2.charAt(a-1)) {
					arr[a][b]=arr[a-1][b-1]+1;
				}
				else {
					arr[a][b]=Math.max(arr[a-1][b],arr[a][b-1]);
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
			
		for(int b=0;b<=s1n;b++) {
			max=Math.max(max, arr[s2n][b]);
		}
		
		System.out.print(max);	
		
	}

}
