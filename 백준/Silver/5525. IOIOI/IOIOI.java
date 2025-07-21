
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		
		int size=2*N+1;
		char[] arr=new char[size];
		
		
		for(int i=0;i<size;i++) {
			if(i%2==0) {
				arr[i]='I';
			}else {
				arr[i]='O';
			}
		}
		
		String s=br.readLine();
		
		int j=0;
		int sum=0;
		
		while(j<M-2) {
			if(s.charAt(j)=='I') {
				int count=0;
				while(j<M-2 && s.charAt(j+1)=='O' && s.charAt(j+2)=='I') {
					j=j+2;
					count++;
					
				}
				if(count>=N) {
					sum=sum+count-N+1;
				}
			}
			j++;
		}
		
		System.out.print(sum);
	}

}
