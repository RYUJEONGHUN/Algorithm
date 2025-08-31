
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Point1 {
	int x;
	int y;
	public Point1(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static ArrayList<Point1> ta;
	static int[][] arr;
	static List<List<Point1>> nr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ta=new ArrayList<Point1>();
		ArrayList<Point1> oa=new ArrayList<Point1>();
				
		String[] arg=br.readLine().split(" ");
		
		int N=Integer.parseInt(arg[0]);
		
		int M=Integer.parseInt(arg[1]);
		
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);
				if(arr[i][j]==2) {
					ta.add(new Point1(i,j));
				}
				if(arr[i][j]==1) {
					oa.add(new Point1(i,j));
				}
			}
		}	
		
		nr=new ArrayList<List<Point1>>();
		
		ArrayList<Point1> tr=new ArrayList<Point1>();
		dfs(0,M,tr);
		
		int result=Integer.MAX_VALUE;
		
		for(int j=0;j<nr.size();j++) {
			int sum=0;
			for(int i=0;i<oa.size();i++) {	
				int ox=oa.get(i).x;
				int oy=oa.get(i).y;
				
				int t=Integer.MAX_VALUE;
				
				for(int k=0;k<nr.get(j).size();k++) {
					int tx=nr.get(j).get(k).x;
					int ty=nr.get(j).get(k).y;
					
					int s=Math.abs(ox-tx)+Math.abs(oy-ty);
					t=Math.min(t, s);
				}
				sum+=t;
			}
			result=Math.min(result, sum);
		}
		
		System.out.print(result);
	}
	
	public static void dfs(int start,int M, List<Point1> cur) {
		
		if (cur.size() == M) {
            nr.add(new ArrayList<>(cur));   // ✨ 스냅샷(복사본) 저장
            return;
        }
		
		int n=ta.size();	
		
		for (int i = start; i <= n - (M - cur.size()); i++) {
            cur.add(ta.get(i));
            dfs(i + 1, M, cur);
            cur.remove(cur.size() - 1);      // 마지막 원소만 제거
        }
	}

}
