
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		
		int div=gdc(a,b);
		
		int x=Math.max(a, b);
		
		int start=x/div;
		
		int mul;
		
		while (true) {
			mul=start*div;
			if( ((mul)%a==0) && ((mul)%b==0)) {
				break;
			}
			start++;
		}
		
		System.out.println(div);
		System.out.print(mul);
	}
	
	public static int gdc(int a,int b) {
		if(b==0) {
			return a;
		}
		int temp=a%b;
		a=b;
		b=temp;
		int result=gdc(a,b);
		return result;
	}

}

