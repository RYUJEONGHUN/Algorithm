

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int count=0;
		
		HashSet<Integer> set=new HashSet<>();
		int N=sc.nextInt();
				
		int[] arr=new int[N];
		int[] truearr=new int[N];
		
		for(int i=0;i<N;i++) {
			int k=sc.nextInt();
			arr[i]=k;
			set.add(k);
		}
		List<Integer> tempSet=new ArrayList<>(set);
		Collections.sort(tempSet);
		
		for(int i=0;i<tempSet.size();i++) {
			for(int j=0;j<N;j++) {
				if(arr[j]==tempSet.get(i)) {
					truearr[j]=count;
					count++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(truearr[i]+" ");
		}
	}

}
