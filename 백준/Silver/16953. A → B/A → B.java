
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	long current;
	long level;
	public Point(long tc,long tl) {
		current=tc;
		level=tl;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Long> s=new HashSet<Long>();
		
		String[] arg=br.readLine().split(" ");
		
		long A=Long.parseLong(arg[0]);
		long B=Long.parseLong(arg[1]);
		
		
		Queue<Point> q=new LinkedList<Point>();
		
		q.add(new Point(A,1));
		s.add(A);
		
		boolean check=false;
		long result=-1;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			long c=p.current;
			long l=p.level;
			
			if(c==B) {
				result=l;
				check=true;
				break;
			}
			else {
				long a=2*c;
				long b=c*10+1;
				
				if(!s.contains(a) && a<=B) {
					q.add(new Point(a,l+1));
					s.add(a);
				}
				if(!s.contains(b) && b<=B) {
					q.add(new Point(b,l+1));
					s.add(b);
				}
			}
		}
		
		if(check) {
			System.out.print(result);
		}
		else {
			System.out.print(-1);
		}
	}
	

}
