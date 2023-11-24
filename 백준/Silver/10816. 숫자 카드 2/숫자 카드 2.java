import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n= Integer.parseInt(st.nextToken());
		int narr[] = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i <n ;++i) {
			narr[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m; ++i) {
			sb.append(narr[Integer.parseInt(st.nextToken())+10000000] +" ");
		}
		System.out.println(sb);
	}
}