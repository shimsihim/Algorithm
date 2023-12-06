import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int list[] = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; ++i) {
			list[i] = Integer.parseInt(st.nextToken());
			
		}
		int start = Integer.parseInt(br.readLine());
		
		boolean visit[] = new boolean[n+1];
		visit[start] = true;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		int cnt = 1;
		while(!q.isEmpty()) {
			if(cnt==n) break;
			int temp = q.poll();
			int left = temp-list[temp];
			int right = temp+list[temp];
			
			if(left>=1 && !visit[left]) {
				q.add(left);
				visit[left] = true;
				cnt++;
			}
			if(right<=n && !visit[right]) {
				q.add(right);
				visit[right] = true;
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}