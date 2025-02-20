import java.util.Scanner;

public class Main {
	public static int[] arr=new int[20000];
	public static int rear=10000;
	public static int front=10001;
	public static int size=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String str=sc.next();
			switch(str) {
			case "push_front":
				int fn=sc.nextInt();
				push_front(fn);
				break;
			case "push_back":
				int bn=sc.nextInt();
				push_back(bn);
				break;
			case "pop_front":
				sb.append(pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(pop_back()).append("\n");
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
	public static void push_front(int fn) {
		arr[front]=fn;
		front++;
		size++;
	}
	public static void push_back(int bn) {
		arr[rear]=bn;
		rear--;
		size++;
	}
	public static int pop_front() {
		if(front==rear+1) {
			return -1;
		}
		int temp=arr[front-1];
		arr[front-1]=0;
		front--;
		size--;
		return temp;
		
	}
	public static int pop_back() {
		if(front==rear+1) {
			return -1;
		}
		int temp=arr[rear+1];
		arr[rear+1]=0;
		rear++;
		size--;
		return temp;
	}
	public static int size() {
		return size;
	}
	public static int empty() {
		if(front==rear+1) {
			return 1;
		}
		else
			return 0;
	}
	public static int front() {
		if(front==rear+1) {
			return -1;
		}
		return arr[front-1];
	}
	public static int back() {
		if(front==rear+1) {
			return -1;
		}
		return arr[rear+1];
	}

}