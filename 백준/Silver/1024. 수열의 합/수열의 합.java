
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int L=sc.nextInt();
		
		
		int count=2;
		int sum=0;
		int i=2;
		int j=1;
		
		while(count<L) {
			i++;
			j=j+count;
			count++;
		}
		
		while(count>=L && count<=100) {
			int temp=N-j;
			if(temp<0 || temp%i==0) {
				break;
			}
			else {
				i++;
				j=j+count;
				count++;
			}
		}
		
		if(N-j<0) {
			System.out.print(-1);
		}
		else if(count>100) {
			System.out.print(-1);
		}
		else {
			int div=(N-j)/i;
			for(int k=0;k<count;k++) {
				System.out.print(div+k+" ");
			}
		}
		
		sc.close();
		
	}

}
