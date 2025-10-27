import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> high = new PriorityQueue<>();
		PriorityQueue<Integer>low = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		for(int i = 0 ; i < n ; ++i) {
			int temp = Integer.parseInt(br.readLine());
			
			if(i%2==0) {//현재까지 짝수일때
				if(high.peek()!=null &&high.peek()<temp) {
					low.add(high.poll());
					high.add(temp);
				}
				else {
					low.add(temp);
				}
			}
			else {// 홀수일 때
				if(low.peek()!=null &&low.peek()>temp) {
					high.add(low.poll());
					low.add(temp);
				}
				else {
					high.add(temp);
				}
			}
			sb.append(low.peek()+"\n");
			
		}
		System.out.println(sb);
		
	}
}