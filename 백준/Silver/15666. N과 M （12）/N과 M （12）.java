
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	static ArrayList<Integer> a;
	static int[] r;
	
	static int M;
	static int N;
	//static int[] arr;
	static int size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		a=new ArrayList<Integer>();
		
		String[] arg=br.readLine().split(" ");
		
		N=Integer.parseInt(arg[0]);
		M=Integer.parseInt(arg[1]);
						
		r=new int[M];
		String[] temp=br.readLine().split(" ");
		
		//arr=new int[N];
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(temp[i]);
			if(!a.contains(n)) {
				a.add(n);
			}
		}
		
		Collections.sort(a);
		size=a.size();
		dfs(0,a.get(0));
	}
	
	public static void dfs(int level,int prev) {
		
		if(level==M) {
			for(int j=0;j<M;j++) {
				System.out.print(r[j]+" ");
			}
			System.out.println();
			return;
		}
		int[] visited=new int[10001];
		
		for(int i=0;i<size;i++) {
			int temp=a.get(i);
			if(visited[temp]!=1 && temp>=prev) {
				r[level]=temp;
				visited[temp]=1;
				dfs(level+1,a.get(i));
				visited[temp]=0;
			}
		}
	}

}
