
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Edge1991{
	char left;
	char right;
	public Edge1991(char left,char right) {
		this.left=left;
		this.right=right;
	}
}

public class Main {
	static HashMap<Character,Edge1991> map;
	static int[] vis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		map=new HashMap<Character,Edge1991>();
		vis=new int[N];
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			char a=temp[0].charAt(0);
			char b=temp[1].charAt(0);
			char c=temp[2].charAt(0);
			
			map.put(a, new Edge1991(b,c));
		}
		
		ftree('A');
		System.out.println();
		vis=new int[N];
		mtree('A');
		System.out.println();
		vis=new int[N];
		ltree('A');
	}
	
	public static void ftree(char key) {
		System.out.print(key);
		int id=key-65;
		vis[id]=1;
		Edge1991 c=map.get(key);
		char right=c.right;
		char left=c.left;
		
		if(left!='.') {
			int lid=left-65;
			if(vis[lid]==0) {
				ftree(c.left);
			}
		}
			
		if(right!='.'){
			int rid=right-65;
			if(vis[rid]==0) {
				ftree(c.right);
			}
		}
		
	}
	
	public static void mtree(char key) {
		int id=key-65;
		Edge1991 c=map.get(key);
		char right=c.right;
		char left=c.left;
		
		if(left!='.') {
			int lid=left-65;
			if(vis[lid]==0) {
				mtree(c.left);
			}
		}
		System.out.print(key);
		vis[id]=1;
		
		if(right!='.'){
			int rid=right-65;
			if(vis[rid]==0) {
				mtree(c.right);
			}
		}
		
	}
	
	public static void ltree(char key) {
		int id=key-65;
		Edge1991 c=map.get(key);
		char right=c.right;
		char left=c.left;
		
		if(left!='.') {
			int lid=left-65;
			if(vis[lid]==0) {
				ltree(c.left);
			}
		}
		
		if(right!='.'){
			int rid=right-65;
			if(vis[rid]==0) {
				ltree(c.right);
			}
		}
		System.out.print(key);
		vis[id]=1;
	}
}
