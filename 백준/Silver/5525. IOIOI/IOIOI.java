

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
		
		for(int i=0;i<M-size+1;i++) {
			boolean check=true;
			for(int j=0;j<size;j++) {
				if(s.charAt(i+j)!=arr[j]) {
					check=false;
					break;
				}
			}
			if(check==true) {
				count++;
			}
		}
		
		System.out.print(count);
	}

}
