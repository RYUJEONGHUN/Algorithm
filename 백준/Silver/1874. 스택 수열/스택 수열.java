

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		Deque<Integer> stack=new ArrayDeque<>();
		
		StringBuilder sb=new StringBuilder();
		Boolean check=true;
		
		int n=sc.nextInt();
		
		int big=0;
		int cnt=1;
		
		for(int i=1;i<=n;i++) {
			int input=sc.nextInt();
			if(input>big) {
				int k=cnt;
				for(int j=k;j<=input;j++) {
					stack.push(cnt++);
					sb.append("+").append("\n");
				}
				big=stack.pop();
				sb.append("-").append("\n");
			}
			else {
				if(stack.peek()!=input) {
					check=false;
				}
				else {
					stack.pop();
					sb.append("-").append("\n");
				}
			}
		}
		
		if(check) {
			System.out.print(sb);
		}else {
			System.out.print("NO");
		}
		sc.close();
		
	}

}
