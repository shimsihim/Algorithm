import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq[] = new PriorityQueue[n+1];
		for(int i = 1 ; i <= n; ++i ) {
			pq[i] = new PriorityQueue<Integer>();
		}
		
		long order[] = new long[n+1];
		long dept[] = new long[n+1];
		
		for(int i = 0 ; i < v ; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			pq[parent].add(child);
			pq[child].add(parent);
			
		}
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		order[start] = 1;
		int cnt = 2;
		q.add(start);
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i = pq[temp].size() ; i > 0 ; --i) {
				int temp2 = pq[temp].poll();
				if(order[temp2]==0) {
					q.add(temp2);
					dept[temp2] = dept[temp]+1;
					order[temp2] = cnt++;
				}
			}
			
		}
		long sum = 0L;
		for(int i = 1 ; i < n+1 ; ++i) {
//			sb.append(order[i]*dept[i]).append('\n');
			sum += order[i]*dept[i];
		}
		
		System.out.println(sum);
	}
	
}