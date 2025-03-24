
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int F=sc.nextInt();
		
	
		  N = (N / 100) * 100;
	        
	        // 2) Find the smallest i in [0..99] such that (N + i) is divisible by F.
	      int ans = 0;
	       for(int i = 0; i < 100; i++) {
	            if((N + i) % F == 0) {
	                ans = i;
	                break;
	            }
	        }
		if(ans>=0 && ans<10) {
			String str='0'+Integer.toString(ans);
			System.out.print(str);
		}
		else {
			System.out.print(ans);
		}
	}

}