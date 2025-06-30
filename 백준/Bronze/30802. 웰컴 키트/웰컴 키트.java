
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int sumt=0;
		
		int d=0;
		int p=0;
		
		int[] arr=new int[6];
		
		for(int i=0;i<6;i++) {
			arr[i]=sc.nextInt();
		}
		
		int T=sc.nextInt();
		int P=sc.nextInt();
		
		
		int k;
		
		for(int j=0;j<6;j++) {
			if(arr[j]%T==0) {
				k=arr[j]/T;
			}
			else {
				k=arr[j]/T+1;
			}
			sumt+=k;
		}
		
		System.out.println(sumt);
		
		d=N/P;
		p=N%P;
		
		System.out.print(d+" "+p);
		
	}

}