
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	static int[] x= {-1,-1,0,1,1,1,0,-1};
	static int[] y= {0,-1,-1,-1,0,1,1,1};
	static ArrayList<Character> s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		char[][] arr=new char[4][10];
		
		for(int i=0;i<4;i++) {
			String temp=br.readLine();
			for(int j=0;j<10;j++) {
				arr[i][j]=temp.charAt(j);
			}
		}
		
		String r=br.readLine();
		s=new ArrayList<Character>();
		
		for(int a=0;a<9;a++) {
			s.add(r.charAt(a));
		}
		
		
		int rx=0;
		int ry=0;
		
		for(int n=1;n<3;n++) {
			boolean t=false;
			for(int m=1;m<9;m++) {
				if(!s.contains(arr[n][m])) {
					continue;
				}
				t=search(arr,n,m);
				if(t==true) {
					rx=n;
					ry=m;
					break;
				}
			}
			if(t) {
				break;
			}
		}
		System.out.print(arr[rx][ry]);
	}
	
	public static boolean search(char[][] arr,int n,int m) {
		for(int i=0;i<8;i++) {
			int tx=n+y[i];
			int ty=m+x[i];
			if(!s.contains(arr[tx][ty])) {
				return false;
			}
		}
		return true;
	}

}
