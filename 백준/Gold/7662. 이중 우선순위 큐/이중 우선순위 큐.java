
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		TreeMap<Integer,Integer> m;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			m=new TreeMap<Integer,Integer>();
			int k=Integer.parseInt(br.readLine());
			for(int a=0;a<k;a++) {
				String[] temp=br.readLine().split(" ");
				String c=temp[0];
				int v=Integer.parseInt(temp[1]);
				
				switch(c) {
				case "I":
					if(m.get(v)==null) {
						m.put(v,1);
					}else {
						m.put(v,m.get(v)+1);
					}
					break;	
				case "D":
					if(m.isEmpty()) continue;
					
					int key;
					if(v==1) {
						key=m.lastKey();
						if(m.get(key)==1) {
							m.remove(key);
						}else {
							m.put(key, m.get(key)-1);;
						}
					}else {
						key=m.firstKey();
						if(m.get(key)==1) {
							m.remove(key);
						}else {
							m.put(key, m.get(key)-1);
						}
					}
					break;
				}
				
			}
			if(m.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(m.lastKey()+" "+m.firstKey());
			}
		}
	}

}
