import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		arr=new int[50001];
		arr[0]=0;
		arr[2]=2;
		arr[3]=3;
		arr[4]=1;
		int[] stat=new int[223];
		
		for(int i=1;i<=222;i++) {
			stat[i]=i*i;
			arr[i*i]=1;
		}
		
		for(int i=1;i<=n;i++) {
			int an=arr[i];
			
			switch(an) {
			case 1:
				for(int j=1;j<=222;j++) {
					if(n>=i+stat[j]) {
						if(arr[i+stat[j]]==0) {
							arr[i+stat[j]]=2;
						}
						else {
							arr[i+stat[j]]=Math.min(arr[i+stat[j]],2);
						}
						
					}
				}
				break;
			case 2:
				for(int j=1;j<=222;j++) {
					if(n>=i+stat[j]) {
						if(arr[i+stat[j]]==0) {
							arr[i+stat[j]]=3;
						}
						else {
							arr[i+stat[j]]=Math.min(arr[i+stat[j]],3);
						}
						
					}
				}
				break;
			case 3:
				for(int j=1;j<=222;j++) {
					if(n>=i+stat[j]) {
						if(arr[i+stat[j]]==0) {
							arr[i+stat[j]]=4;
						}
						else {
							arr[i+stat[j]]=Math.min(arr[i+stat[j]],4);
						}
						
					}
				}
				break;
				
			case 4:
				break;
			}
			
			
		}
		
		System.out.print(arr[n]);
		
		
		
		
	}

}
