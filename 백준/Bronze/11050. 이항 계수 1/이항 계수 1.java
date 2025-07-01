import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		int nfact=1;
		int kfact=1;
		int rfact=1;
		
		for(int i=1;i<=N;i++) {
			nfact=nfact*i;
		}
		for(int i=1;i<=K;i++) {
			kfact=kfact*i;
		}
		
		for(int i=1;i<=(N-K);i++) {
			rfact=rfact*i;
		}
		
		int result=nfact/(kfact*rfact);
		
		System.out.print(result);
		
		sc.close();
	}

}