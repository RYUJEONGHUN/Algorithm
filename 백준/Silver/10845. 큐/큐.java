
import java.util.Scanner;

public class Main {
	static int[] queue=new int[10000];
	static int back=0;
	static int front=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String input=sc.next();
			
			switch(input){
			case "push":
				int X=sc.nextInt();
				push(X);
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
	public static void push(int X) {
		if(back>9999) {
			back=back%10000;
		}
		queue[back]=X;
		back++;
		
	}
	public static int pop() {
		if(front>9999) {
			front=front%10000;
		}
		if(empty()==1) {
			return -1;
		}
		else {
			int temp=queue[front];
			front++;
			return temp;
		}
		
		
	}
	public static int size() {
		return Math.abs(front-back);
	}
	public static int empty() {
		if(back==front) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static int front() {
		if(empty()==1) {
			return -1;
		}
		else {
			return queue[front];
		}
	}
	public static int back() {
		if(empty()==1) {
			return -1;
		}
		else {
			return queue[back-1];
		}
	}

}
