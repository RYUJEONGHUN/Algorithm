
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node2166 {
	long x;
	long y;
	Node2166(long x,long y){
		this.x=x;
		this.y=y;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Node2166> arr=new ArrayList<Node2166>();
		
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			long x=Long.parseLong(temp[0]);
			long y=Long.parseLong(temp[1]);
			
			arr.add(new Node2166(x,y));
		}
				
		Node2166 f=arr.get(0);
		
		long cnt=0;
		
		for(int i=1;i<=N-2;i++) {
			Node2166 b=arr.get(i);
			Node2166 c=arr.get(i+1);
			
			long r=tieshoe(f,b,c);
			cnt+=r;
		}
		double res=(Math.abs(cnt))/2.0;
		
		System.out.printf("%.1f\n",res);
	}
	
	public static long tieshoe(Node2166 a,Node2166 b,Node2166 c) {
		long xx=(a.x*b.y)+(b.x*c.y)+(c.x*a.y);
		long yy=(b.x*a.y)+(c.x*b.y)+(a.x*c.y);
		
		
		return xx-yy;
	}
}
