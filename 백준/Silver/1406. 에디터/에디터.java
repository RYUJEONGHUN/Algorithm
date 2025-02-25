
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		StringBuilder sb=new StringBuilder();
		
		Deque<Character> leftstack=new ArrayDeque<Character>();
		Deque<Character> rightstack=new ArrayDeque<Character>();
		
		String str=sc.next();
		
		for (char c : str.toCharArray()) {
            leftstack.addLast(c);  // push 대신 addLast 사용
        }
		
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String ch=sc.next();
			switch (ch) {
			case "L":
				if(leftstack.isEmpty()) {
					continue;
				}
				else {
					rightstack.push(leftstack.pollLast());
				}
				break;
			
			case "D":
				if(rightstack.isEmpty()) {
					continue;
				}
				else {
					leftstack.addLast(rightstack.pop());
				}
				break;
				
			case "B":
				if(leftstack.isEmpty()) {
					continue;
				}
				else {
					leftstack.pollLast();
				}
				break;
				
			case "P":
				char pch=sc.next().charAt(0);
				leftstack.addLast(pch);
				break;
			}
		}
		int leftsize=leftstack.size();
		int rightsize=rightstack.size();
		
		for(int i=0;i<leftsize;i++) {
			sb.append(leftstack.pop());
		}
		for(int i=0;i<rightsize;i++) {
			sb.append(rightstack.pop());
		}
		System.out.println(sb);
	}

}
