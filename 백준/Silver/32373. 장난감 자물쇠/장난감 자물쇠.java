
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp=br.readLine().split(" ");
		
		int N=Integer.parseInt(temp[0]);
		int k=Integer.parseInt(temp[1]);
		
		int[] arr=new int[N];
		
		String[] arg=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(arg[i]);
		}
		
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		
		int[] vis=new int[N];
		
		
		for(int a=0;a<N-k;a++) {
			if(vis[a]==1) {
				continue;
			}
			int t=a;
			while(t<N) {
				q.add(arr[t]);
				vis[t]=1;
				t=t+k;
			}
			t=a;
			while(!q.isEmpty()) {
				int p=q.poll();
				arr[t]=p;
				t=t+k;
			}
		}
		
		/*for(int b=0;b<N;b++) {
			System.out.print(arr[b]+" ");
		}*/
		
		boolean check=true;
		for(int b=0;b<N-1;b++) {
			if(arr[b]>arr[b+1]) {
				check=false;
				break;
			}
		}
		
		if(check) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}

}
