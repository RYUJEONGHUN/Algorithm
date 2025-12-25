
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point_16953{
	long stage;
	long num;
	public Point_16953(long num,long stage) {
		this.num=num;
		this.stage=stage;
	}
}

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		long A=Integer.parseInt(temp[0]);
		long B=Integer.parseInt(temp[1]);
		
		Queue<Point_16953> q=new LinkedList<Point_16953>();
		
		q.add(new Point_16953(A,1));
		
		long result=-1;
		
		while(!q.isEmpty()) {
			Point_16953 cur=q.poll();
			long cs=cur.stage;
			long num=cur.num;
			
			if(num==B) {
				result=cs;
				break;
			}
			
			long a=2*num;
			long b=num*10+1;
			
			if(a<=B) {
				q.add(new Point_16953(a,cs+1));
			}
			if(b<=B) {
				q.add(new Point_16953(b,cs+1));
			}
			
		}
		
		System.out.print(result);
		
	}

}
