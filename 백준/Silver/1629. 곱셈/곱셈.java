
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		long A=Long.parseLong(arg[0]);
		long B=Long.parseLong(arg[1]);
		long C=Long.parseLong(arg[2]);
		
		
		long result=pow(A,B,C);
		
		System.out.print(result);
	}
	
	public static long pow(long a,long b,long c) {
		if(b==0) {
			return 1;
		}
		long half=pow(a,b/2,c);
		long result=(half*half)%c;
		
		if(b%2==1){
			result=(result*a)%c;
		}
		
		return result;
	}
}
