import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[k+1];
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wei = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[i][0] = wei;
            list[i][1] = val;
        }
        for (int i = 0; i < n; i++) {
            int wei = list[i][0];
            int val = list[i][1];
            for(int j = k ; j >= wei ; j--) {
                value[j] = Math.max(value[j], val + value[j-wei]);
            }
        }
        System.out.println(value[k]);
    }
}
