
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String a=br.readLine();
		String b=br.readLine();
		
		int an=a.length();
		int bn=b.length();
		
		int[][] arr=new int[an+1][bn+1];
		
		for(int i=0;i<=an;i++) {
			arr[i][0]=i;
		}
		
		for(int j=0;j<=bn;j++) {
			arr[0][j]=j;
		}
		
		for(int i=1;i<=an;i++) {
			for(int j=1;j<=bn;j++) {
				int n;
				if(a.charAt(i-1)==b.charAt(j-1)) {
					n=0;
				}else {
					n=1;
				}
				arr[i][j]=Math.min(arr[i][j-1]+1, Math.min(arr[i-1][j]+1, arr[i-1][j-1]+n));
				
			}
		}
		
		System.out.print(arr[an][bn]);
	}

}
