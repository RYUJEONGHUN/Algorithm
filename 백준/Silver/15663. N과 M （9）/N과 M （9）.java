
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] vis;
	static int[] carr;
	static HashSet<String> s;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		String[] temp=br.readLine().split(" ");
		
		N=Integer.parseInt(temp[0]);
		M=Integer.parseInt(temp[1]);
		
		s=new HashSet<String>();
		
		arr=new int[N];
		carr=new int[M];
		
		String[] aa=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(aa[i]);
		}
		
		Arrays.sort(arr);
		vis=new int[N];
		
		dfs(0);
				
		System.out.print(sb);
	}
	
	public static void dfs(int level) {
		if(level==M) {
			String ss="";
			for(int j=0;j<M;j++) {
				ss+=carr[j]+" ";
			}
			if(!s.contains(ss)) {
				s.add(ss);
				sb.append(ss+"\n");
			}
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(vis[i]==0) {
				carr[level]=arr[i];
				vis[i]=1;
				dfs(level+1);
				vis[i]=0;
			}
		}
	}
	
	
}
