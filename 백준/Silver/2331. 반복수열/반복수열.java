
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int A;
	static int P;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		A=sc.nextInt();
		P=sc.nextInt();
		
		arr.add(A);
		int std=A;
		
		int index;
		
		while(true) {
			int ans=parser(std);
			if(arr.contains(ans)) {
				index=arr.indexOf(ans);
				break;
			}
			arr.add(ans);
			std=ans;
		}
	
		
		System.out.print(index);
		
	}

	public static int parser(int sc) {
		
		int sum=0;
		
		while(sc!=0) {
			int n=sc%10;
			int mup=1;
			for(int i=0;i<P;i++) {
				mup=mup*n;
			}
			sum=sum+mup;
			sc=sc/10;
		}
		return sum;
	}
}
