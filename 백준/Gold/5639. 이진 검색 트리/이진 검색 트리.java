
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node5369{
	int c;
	Node5369 l;
	Node5369 r;
	public Node5369(int c) {
		this.c=c;	
	}	
}


public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		Node5369 s=new Node5369(Integer.parseInt(br.readLine()));
		
		String line;
		while((line=br.readLine())!=null){
			int x=Integer.parseInt(line);
			poot(s,new Node5369(x));
		}
		
		dfs(s);
	}
	public static void poot(Node5369 C,Node5369 X) {
		int cur=C.c;
		
		if(cur<X.c) {
			if(C.r==null) {
				C.r=X;
			}
			else {
				poot(C.r,X);
			}
		}
		
		else if(cur>X.c) {
			if(C.l==null) {
				C.l=X;
			}
			else {
				poot(C.l,X);
			}
		}
		
	}
	public static void dfs(Node5369 C) {
		int pc=C.c;
		if(C.l!=null) {
			dfs(C.l);
		}
		
		if(C.r!=null) {
			dfs(C.r);
		}
		System.out.println(pc);
	}
}
