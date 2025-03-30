

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int kim=sc.nextInt();
		
		int im=sc.nextInt();
		
		int round=0;
		
		if(kim>im) {
			int temp=kim;
			kim=im;
			im=temp;
		}
		
		while(true) {
			if(kim%2==1 && kim+1==im) {
				break;
			}
			if(kim==1) {
				kim=1;
				
				if(im%2==1) {
					im+=1;
				}
				im/=2;
				
			}
			else {
				if(kim%2==1) {
					kim+=1;
				}
				kim/=2;
				
				if(im%2==1) {
					im+=1;
				}
				im/=2;
			}
			round++;
		}
		System.out.println(round+1);
	}
}
