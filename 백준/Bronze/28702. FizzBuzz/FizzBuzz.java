
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String[] s=new String[3];
		int result=0;
		
		s[0]=sc.next();
		s[1]=sc.next();
		s[2]=sc.next();
		
		int n0=s[0].charAt(0)-'0';
		int n1=s[1].charAt(0)-'0';
		int n2=s[2].charAt(0)-'0';
		
		if(n2>=0 && n2<=9) {
			int temp=Integer.parseInt(s[2]);
			result=temp+1;
		}
		else if(n1>=0 && n1<=9){
			int temp=Integer.parseInt(s[1]);
			result=temp+2;
		}
		else if(n0>=0 && n0<=9){
			int temp=Integer.parseInt(s[0]);
			result=temp+3;
		}
		
		
		if(result%3==0 && result%5==0) {
			System.out.print("FizzBuzz");
		}
		else if(result%3==0 && result%5!=0) {
			System.out.print("Fizz");
		}
		else if(result%3!=0 && result%5==0) {
			System.out.print("Buzz");
		}
		else {
			System.out.print(result);
		}
		
		}

}
