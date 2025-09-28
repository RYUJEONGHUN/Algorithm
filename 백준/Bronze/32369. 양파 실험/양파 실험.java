
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		int A=Integer.parseInt(arg[1]);
		int B=Integer.parseInt(arg[2]);
		
		
		int pos=1;
		int neg=1;
		int day=0;
		
		while(day<N) {
			pos+=A;
			neg+=B;
			
			if(pos<neg) {
				int temp=pos;
				pos=neg;
				neg=temp;
			}
			if(pos==neg) {
				neg--;
			}
			day++;
		}
		
		System.out.print(pos+" "+neg);
	}

}
