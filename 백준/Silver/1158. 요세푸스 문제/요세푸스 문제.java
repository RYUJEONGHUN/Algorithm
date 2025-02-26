

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		StringBuilder sb=new StringBuilder();
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			queue.add(i+1);
		}
		
		while(queue.size()!=1) {
			for(int i=0;i<K-1;i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()+", ");
		}
		sb.append(queue.poll());
		System.out.print("<"+sb+">");
	}

}