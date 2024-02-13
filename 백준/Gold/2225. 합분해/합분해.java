import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long dp[][] = new long[n+1][k+1];
        Arrays.fill(dp[0],1l);

        for (int i = 0; i < n+1; i++) {
            dp[i][1] = 1l;
        }
        for (int i = 2; i < k+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[j][i] = (dp[j-1][i]+dp[j][i-1])%1000000000l;
            }
        }
        System.out.println(dp[n][k]);




    }
}