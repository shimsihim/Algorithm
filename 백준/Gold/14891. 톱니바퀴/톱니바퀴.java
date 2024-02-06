import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer>list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new LinkedList[4];
		
		for(int i = 0 ; i < 4 ; ++i) {
			list[i] = new LinkedList<>();
		}
		
		String str = br.readLine();
		for(int i = 0 ; i < 8 ; ++i) {
			list[0].add(str.charAt(i)-'0');
		}
		
		str = br.readLine();
		for(int i = 0 ; i < 8 ; ++i) {
			list[1].add(str.charAt(i)-'0');
		}
		
		str = br.readLine();
		for(int i = 0 ; i < 8 ; ++i) {
			list[2].add(str.charAt(i)-'0');
		}
		
		str = br.readLine();
		for(int i = 0 ; i < 8 ; ++i) {
			list[3].add(str.charAt(i)-'0');
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t ; ++i) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int direc = Integer.parseInt(st.nextToken());
			rot(num,direc); // 1인경우 시계방향 // -1은 반시계
		}
		int sum = 0;
		for(int i = 0 ; i < 4 ; ++i) {
			if(list[i].peek()==1)
				sum+= multi(i);
		}
		System.out.println(sum);
	}
	
	static void rot(int num , int direc) {
		int[] rot = new int[4];
		rot[num-1] = direc;
		boolean left = true;
		boolean right = true;
		int leftidx=num-2,rightidx = num;
		while(right || left) {
			if(left &&leftidx>=0 &&leftidx+1<4&&list[leftidx].get(2)!=list[leftidx+1].get(6)) {
				rot[leftidx] = rot[leftidx+1]*-1;
				leftidx--;
			}
			else
				left = false;
			if(right &&rightidx<4&&rightidx-1>=0 &&list[rightidx].get(6)!=list[rightidx-1].get(2)) {
				rot[rightidx] = rot[rightidx-1]*-1;
				rightidx++;
			}
			else
				right = false;
		}
		
		for(int i = 0 ; i < 4 ; ++i) {
			if(rot[i]==0)
				continue;
			else if(rot[i]==1) {
				list[i].addFirst(list[i].pollLast());
			}
			else {
				list[i].addLast(list[i].pollFirst());
			}
		}
	}
	
	static int multi(int num) {
		if(num==0)
			return 1;
		return 2*multi(num-1);
		
	}
	
}