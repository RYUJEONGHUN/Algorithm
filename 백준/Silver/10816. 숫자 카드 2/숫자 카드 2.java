
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		
		HashMap<Integer,Integer> map= new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0;i<N;i++) {
			int key=sc.nextInt();
			map.put(key, map.getOrDefault(key, 0) + 1);
		
		}
		
		int M=sc.nextInt();
		
		
		for(int i=0;i<M;i++) {
			int findKey=sc.nextInt();
			sb.append(map.getOrDefault(findKey, 0)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
