
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		String[] arg=br.readLine().split(" ");
		
		HashMap<Integer,Integer> M=new HashMap<Integer,Integer>();
		HashSet<Integer> S=new HashSet<Integer>();
		
		
		int[] arr=new int[200000];
		
		
		for(int i=0;i<N;i++) {
			int m=Integer.parseInt(arg[i]);
			arr[i]=m;
			S.add(arr[i]);
		}
		
		
		
		int i=0;
		int j=0;
		
		int max=Integer.MIN_VALUE;
		
		if(S.size()==1 || S.size()==2) {
			System.out.print(N);
		}
		else {
			while(j<N) {
				 M.put(arr[j], M.getOrDefault(arr[j], 0) + 1);

				    while (M.size() > 2) {
				        M.put(arr[i], M.get(arr[i]) - 1);
				        if (M.get(arr[i]) == 0) {
				            M.remove(arr[i]);
				        }
				        i++;
				    }

				    max = Math.max(max, j - i + 1);
				    j++;
				
			}
			System.out.print(max);
		}
		
	}

}
