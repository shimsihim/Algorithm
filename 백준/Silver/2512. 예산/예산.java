import java.io.*;
import java.util.*;

class Main {

	
	static int[] list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = 0 ; i < n ; ++i) {
			list[i] = Integer.parseInt(st.nextToken());
			sum += list[i];
		}
		
		total = Integer.parseInt(br.readLine());
		Arrays.sort(list);
		if(total>=sum) {
			System.out.println(list[n-1]);
		}
		else {
			search(0,list[n-1]);
		}
		
	}
	static int total;
	static int n;
	static void search(int start,int end) {
		
		int mid = 0;
		
		while(start<end) {
			mid = start+(end-start)/2;
			if(can(mid)) {
				start = mid+1;
			}
			else {
				end = mid;
			}
			
			
		}
		System.out.println(start-1);
	}
	
	static boolean can(int mid) {
		
		int sum = 0;
		for(int i = 0 ; i < n ; ++i) {
			if(list[i]<mid) {
				sum+=list[i];
			}
			else {
				sum+=mid;
			}
		}
		if(sum<=total) {
			return true;
		}
		else {
			return false;
		}
	}

}