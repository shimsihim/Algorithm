import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(st.nextToken());
		st= new  StringTokenizer(br.readLine());
		boolean[] arr = new boolean[20000001];
		for(int i =0 ; i < num; ++i) {
			arr[Integer.parseInt(st.nextToken())+10000000]=true;
		}
		st = new StringTokenizer(br.readLine());
		int num2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < num2 ; ++i) {
			if(arr[Integer.parseInt(st.nextToken())+10000000]==true)
				sb.append(1+" ");
			else
				sb.append(0+" ");
			
		}
		
		System.out.println(sb);
	}
}