

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		String[] strarr=new String[51];
		
		String str=sc.next();
		char[] charArray = str.toCharArray();
		
		
		for(int i=1;i<N;i++) {
			String str1=sc.next();
			for(int j=0;j<str1.length();j++) {
				if(charArray[j]!=str1.charAt(j)) {
					charArray[j]='?';
				}
			}
		}
		System.out.print(new String(charArray));
		
	}

}
