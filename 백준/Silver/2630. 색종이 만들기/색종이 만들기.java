

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static int bCnt=0;
	static int wCnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			String[] arg=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(arg[j]);
			}
		}
		
		int size=n;
		
		divide(0,0,size);
		
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	
	public static void divide(int m,int n,int size) {
		boolean same=sameColor(m,n,size);
		
		if(same==true) {
			int color=arr[m][n];
			
			if(color==0) {
				wCnt++;
			}else {
				bCnt++;
			}
			
			return;
		}
		else {
			size=size/2;
			divide(m,n,size);
			divide(m+size,n,size);
			divide(m,n+size,size);
			divide(m+size,n+size,size);
			
		}
		
	}
	
	public static boolean sameColor(int m,int n,int size) {
		int color=arr[m][n];
		for(int i=m;i<m+size;i++) {
			for(int j=n;j<n+size;j++) {
				if(color!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
