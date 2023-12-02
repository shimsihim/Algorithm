

import java.util.*;
import java.io.*;

class Main {
	
	static int k;
	static int n;
	static long[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken()); // 존재 개수
		n = Integer.parseInt(st.nextToken()); // 필요 개수
		
		list = new long[k];
		for(int i = 0 ; i < k ; ++i) {
			list[i] = Long.parseLong(br.readLine());
		}
		
		long start = 0;
		long end = Long.MAX_VALUE;
		
		long middle = 0;
		while(start<end) {
			middle = start + (end-start)/2;
			if(check(middle)) {
				start = middle+1;
			}
			else {
				end = middle;
			}
			
		}
		System.out.println(start-1);
		
	}
	
	static boolean check(long mid) {
		
		int cnt = 0;
		for(int i = 0 ; i < k ; ++i) {
			cnt += list[i]/mid;
		}
		if(cnt >=n) return true;
		return false;
	}

}