
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		int n=sc.nextInt();
		
		int sum=0;
		
		String s=sc.next();
		
		for(int j=0;j<26;j++) {
			map.put((char)(97+j), j+1);
		}
		
		
		for(int i=0;i<n;i++) {
			int a=1;
			for(int j=0;j<i;j++) {
				a=a*31;
			}
			int v=map.get(s.charAt(i));
			sum=sum+v*a;
		}
		System.out.print(sum);
	}

}
