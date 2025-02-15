

import java.util.Scanner;

public class Main {
	static int[] stack=new int[10001];
	static int point=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String str=sc.next();
			
			switch(str) {
			case "push":
				int num=sc.nextInt();
				push(num);
				break;
				
			case "pop":
				if(empty()==1) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(pop()).append("\n");
				}
				break;
				
			case "size":
				sb.append(size()).append("\n");
				break;
				
			case "empty":
				sb.append(empty()).append("\n");
				break;
			
			case "top":
				if(empty()==1) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(top()).append("\n");
				}
				break;
			}
		}
		System.out.print(sb);
		
	}
	public static void push(int num) {
		point++;
		stack[point]=num;
	}
	public static int pop() {
		int temp=stack[point];
		point--;
		return temp;
	}
	public static int size() {
		return point;
	}
	public static int empty() {
		if(point==0) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public static int top() {
		return stack[point];
	}

}
