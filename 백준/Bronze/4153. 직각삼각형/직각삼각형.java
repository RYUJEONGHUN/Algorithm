import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		
		
		while(true) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			
			int rx,ry,rz;
			
			if(x>y) {
				rx=y;
				ry=x;
			}
			else {
				rx=x;
				ry=y;
			}
			
			if(ry>z) {
				rz=ry;
				ry=z;
			}
			else {
				rz=z;
			}
						
			if((rx==0) && (ry==0) && (rz==0)) {
				break;
			}
			if(rx*rx+ry*ry==rz*rz) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
		
		
	}

}