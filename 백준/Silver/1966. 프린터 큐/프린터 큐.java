import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
			
			Scanner sc=new Scanner(System.in);
			StringBuilder sb= new StringBuilder();
			
			int N=sc.nextInt();
			
			for(int i=0;i<N;i++) {
				PriorityQueue<Integer> queueread=new PriorityQueue<Integer>(Collections.reverseOrder());
				Queue<Integer> queue=new LinkedList<Integer>();
				Queue<Integer> index=new LinkedList<Integer>();
				int n=sc.nextInt();
				int m=sc.nextInt();
				
				for(int j=0;j<n;j++) {
					int c=sc.nextInt();
					queueread.add(c);
					queue.add(c);
					index.add(j);
				}
				int count=0;
				while(true) {
					if(queueread.peek()==queue.peek()) {
						if(index.peek()==m) {
							count++;
							break;
						}
						queueread.poll();
						queue.poll();
						index.poll();
						count++;
					}
					else {
						queue.add(queue.poll());
						index.add(index.poll());
					}
				}
				sb.append(count).append("\n");
			}
			System.out.println(sb);
	}
}