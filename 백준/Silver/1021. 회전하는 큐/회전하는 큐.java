import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Deque<Integer> deque=new ArrayDeque<>();
		
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int count=0;
		
		for(int i=0;i<N;i++) {
			deque.addLast(i+1);
		}
        
        
        for(int i=0;i<M;i++) {
        	int index = 0;
        	int target=sc.nextInt();
        	Iterator<Integer> iterator = deque.iterator();
        	while (iterator.hasNext()) {
                if (iterator.next().equals(target)) {
                	break;
                }
                index++;
            }
        	
        	int std=deque.size()/2;
        	
        	if(index<=std) {
        		for(int j=0;j<index;j++) {
        			deque.addLast(deque.pollFirst());
        			count++;
        		}
        		deque.pollFirst();
        	}
        	else {
        		for(int j=0;j<deque.size()-index;j++) {
        			deque.addFirst(deque.pollLast());
        			count++;
        		}
        		deque.pollFirst();
        	}
        }
        System.out.print(count);
	}
}
