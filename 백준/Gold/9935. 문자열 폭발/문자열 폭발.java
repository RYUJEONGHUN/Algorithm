
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		
		String bombs=br.readLine();
		
		int sl=s.length();
		int bl=bombs.length();
		
		char[] stack=new char[sl];
		
		int top=0;
		
		for(int i=0;i<sl;i++) {
			stack[top++]=s.charAt(i);
			
			if(top>=bl && s.charAt(i)==bombs.charAt(bl-1)) {
				boolean check=true;
				for(int j=0;j<bl;j++) {
					if(stack[top-bl+j]!=bombs.charAt(j)) {
						check=false;
						break;
					}
				}
				if(check) {
					top-=bl;
				}		
			}
		}
		
		if(top==0) {
			System.out.print("FRULA");
		}else {
			System.out.print(new String(stack, 0, top));
		}		
	}
}
