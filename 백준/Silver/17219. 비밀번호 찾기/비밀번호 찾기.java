import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String,String> map=new HashMap<String,String>();
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] num=br.readLine().split(" ");
		int N=Integer.parseInt(num[0]);
		int M=Integer.parseInt(num[1]);
		
		StringBuilder sb=new StringBuilder();
		
		
		for(int i=0;i<N;i++) {
			String[] line=br.readLine().split(" ");
			map.put(line[0],line[1]);
		}
		for(int j=0;j<M;j++) {
			String ans=br.readLine();
			System.out.println(map.get(ans));
		}
		
		
		
		
		
	}

}
