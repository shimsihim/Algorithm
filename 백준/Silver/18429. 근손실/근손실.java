import java.util.*;
import java.io.*;

class Main {

	static int n;
	static int k;
	static int cnt;
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		list = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; ++i) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		
		find(0,500,0);//날짜, 현재 중량
		System.out.println(cnt);
	}
	
	static void find(int day , int wei,long visit) {
		if(wei<500) return;
		if(day == n) {
			cnt++;
		}
		
		for(int i = 0 ; i < n ; ++i) {
			if((visit&(1<<i))==0) // 반뭉
				find(day+1,wei+list[i]-k , visit|(1<<i));
		}
		
	}
	
}