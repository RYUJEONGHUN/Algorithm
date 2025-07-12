
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
		
		int N=Integer.parseInt(br.readLine());
		
		
		int[] arr=new int[N];
		int[] sorted=new int[N];
		
		
		String[] arg=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int k=Integer.parseInt(arg[i]);
			arr[i]=k;
			sorted[i]=k;
		}
		Arrays.sort(sorted);
		
		m.put(sorted[0],0);
		
		for(int i=1;i<N;i++) {
			if(sorted[i]>sorted[i-1]) {
				m.put(sorted[i],m.get(sorted[i-1])+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
		    sb.append(m.get(arr[i])).append(" ");
		}
		System.out.println(sb);
		
	}
}

