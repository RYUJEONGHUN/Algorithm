
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tempA=br.readLine().split(" ");
		int ax=Integer.parseInt(tempA[0]);
		int ay=Integer.parseInt(tempA[1]);
		
		String[] tempB=br.readLine().split(" ");
		int bx=Integer.parseInt(tempB[0]);
		int by=Integer.parseInt(tempB[1]);
		
		if(ax==0 && bx!=0) {
			System.out.print(1);
		}
		else if(ax==0 && bx==0 && by<ay){
			System.out.print(3);
		}
		else if(ax==0 && bx==0 && by>ay) {
			System.out.print(1);
		}
		else if(ay==0 && by!=0) {
			System.out.print(1);
		}
		else if(ay==0 && by==0 && ax<bx) {
			System.out.print(1);
		}
		else if(ay==0 && by==0 && ax>bx) {
			System.out.print(3);
		}
		else {
			System.out.print(2);
		}
	}

}
