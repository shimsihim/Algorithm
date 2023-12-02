import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	
	static char[][]map;
	static boolean visit[][];
	static int n;
	static int cnt;
	static int size;
	
	public static void main(String[] args) throws Exception {
		
		list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i = 0 ; i < n ; ++i) {
			map[i] = br.readLine().toCharArray();
		}
		visit = new boolean[n][n];
		cnt = 0;
		size = 0;
		
		for(int i = 0 ; i < n ; ++i) {
			for(int j = 0 ; j < n ; ++j) {
				if(check(i,j)) {
					size = 1;
					cnt++;
					bfs(i,j);
					
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int c : list) {
			System.out.println(c);
		}
		
		
	}
	static ArrayList<Integer>list;
	
	static int dr[] = {-1,0,0,1};
	static int dc[] = {0,-1,1,0};
	static void bfs(int r , int c) {
		visit[r][c] = true;
		Queue<node> q = new LinkedList<>();
		q.add(new node(r,c));
		
		while(!q.isEmpty()) {
			node temp = q.poll();
			for(int i = 0 ; i < 4 ; ++i) {
				int row = temp.r+dr[i];
				int col = temp.c+dc[i];
				if(check(row,col)) {
					q.add(new node(row,col));
					visit[row][col] = true;
					size++;
				}
			}
		}
		list.add(size);
	}
	
	static boolean check(int r, int c) {
		if(r>=0 && c>=0 && r<n && c<n && !visit[r][c] && map[r][c]=='1' ) {
			return true;
		}
		return false;
	}
	
	static class node{
		int r;
		int c;
		node(int r , int c){
			this.r = r;
			this.c = c;
		}
	}
	
	

}