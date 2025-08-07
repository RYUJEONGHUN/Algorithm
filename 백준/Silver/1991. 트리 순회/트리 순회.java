
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	static int[][] arr;
	static ArrayList<Integer> result;
	static int[] visited;
	static HashMap<Integer,Character> m;
	public static void main(String[] args) throws IOException {
		m=new HashMap<Integer,Character>();
		
		
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		
		arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			m.put(i, (char) (i+65));
		}
		
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			int a=temp[0].charAt(0) -'A';
			if(!temp[1].equals(".")) { 
				arr[a][0]=temp[1].charAt(0) -'A';
			}else {
				arr[a][0]=-1;
			}
			if(!temp[2].equals(".")) {
				arr[a][1]=temp[2].charAt(0) -'A';;
			}else {
				arr[a][1]=-1;
			}
		}
		
		visited=new int[N];
		result=new ArrayList<Integer>();
		fdfs(0);
		System.out.println();
		visited=new int[N];
		result=new ArrayList<Integer>();
		mdfs(0);
		System.out.println();
		visited=new int[N];
		result=new ArrayList<Integer>();
		bdfs(0);
		
	}

	public static void fdfs(int c) {
		System.out.print(m.get(c));
		visited[c]=1;
		if(arr[c][0]!=-1 && visited[arr[c][0]]!=1) {
			fdfs(arr[c][0]);
		}
		if(arr[c][1]!=-1 && visited[arr[c][1]]!=1) {
			fdfs(arr[c][1]);
		}
		return;
	}
	public static void mdfs(int c) {
		
		visited[c]=1;
		if(arr[c][0]!=-1 && visited[arr[c][0]]!=1) {
			mdfs(arr[c][0]);
		}
		System.out.print(m.get(c));
		if(arr[c][1]!=-1 && visited[arr[c][1]]!=1) {
			mdfs(arr[c][1]);
		}
		return;
	}
	
	public static void bdfs(int c) {
		visited[c]=1;
		if(arr[c][0]!=-1 && visited[arr[c][0]]!=1) {
			bdfs(arr[c][0]);
		}
		if(arr[c][1]!=-1 && visited[arr[c][1]]!=1) {
			bdfs(arr[c][1]);
		}
		System.out.print(m.get(c));
		return;
	}
}
