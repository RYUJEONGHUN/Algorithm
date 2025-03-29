import java.util.ArrayList;
import java.util.Scanner;


class Toint{
	int temp;
	int plus;
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Toint> map=new ArrayList<>();
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int A=Integer.MAX_VALUE;
		int B=Integer.MAX_VALUE;
		
		for(int i=0;i<M;i++) {
			int tA=sc.nextInt();
			if(tA<A) {
				A=tA;
			}
			
			int tB=sc.nextInt();
			if(tB<B) {
				B=tB;
			}
		}
		
		int i=0;
		int plus=101;
		
		while(plus>0) {
			Toint p=new Toint();
	
			int temp=6*i;
			plus=N-temp;
			if(plus<0) {
				plus=0;
			}
			p.temp=i;
			p.plus=plus;
			map.add(p);
			i++;
		}
		
		int sum=Integer.MAX_VALUE;
		
		for(int j=0;j<map.size();j++) {
			int x=map.get(j).temp;
			int y=map.get(j).plus;
			int tempsum=x*A+y*B;
			
			if(tempsum<sum) {
				sum=tempsum;
			}
		}
		
		System.out.print(sum);
		
	}

}