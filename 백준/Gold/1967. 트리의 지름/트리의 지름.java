
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Edge{
	int to;
	int w;
	public Edge(int to,int w) {
		this.to=to;
		this.w=w;
	}
}


class Node{
	int num;
	int sum;
	
	public Node(int num,int sum) {
		this.num=num;
		this.sum=sum;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		List<List<Edge>> arr=new ArrayList<List<Edge>>();
		int[] vis=new int[n+1];
		
		for(int i=0;i<=n;i++) {
			arr.add(new ArrayList<Edge>());
		}
		
		for(int i=0;i<n-1;i++) {
			String[] temp=br.readLine().split(" ");
			int a=Integer.parseInt(temp[0]);
			int b=Integer.parseInt(temp[1]);
			int w=Integer.parseInt(temp[2]);
			
			arr.get(a).add(new Edge(b,w));
			arr.get(b).add(new Edge(a,w));
		}
		
		int tmax=0;
		int tn=1;
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(new Node(1,0));
		
		while(!q.isEmpty()) {
			Node c=q.poll();
			int cn=c.num;
			int cs=c.sum;

			vis[cn]=1;
			
			for(Edge e: arr.get(cn)) {
				if(vis[e.to]!=1) {
					q.add(new Node(e.to,cs+e.w));
				}
			}
			if(cs>tmax) {
				tmax=cs;
				tn=cn;
			}
		}
		//System.out.println(tmax+" "+tn);
		
		vis=new int[n+1];
		int rmax=0;
		Queue<Node> p=new LinkedList<Node>();
		
		p.add(new Node(tn,0));
		
		while(!p.isEmpty()) {
			Node c=p.poll();
			int pn=c.num;
			int ps=c.sum;
			vis[pn]=1;
			
			for(Edge e: arr.get(pn)) {
				if(vis[e.to]!=1) {
					p.add(new Node(e.to,ps+e.w));
				}
			}
			if(ps>rmax) {
				rmax=ps;
			}
			
		}
		
		System.out.print(rmax);
		
	}

}
