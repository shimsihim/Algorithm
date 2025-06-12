import java.io.*;
import java.util.*;

class Main {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cost[] = new int[n+1];
        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            //현 인덱스 + 날짜 -1  의 인덱스가 가능한지
            for(int j = i+day ; j <= n ; ++j){
                cost[j] = Math.max(cost[j] , cost[i] + price);
            }
        }

        System.out.println(cost[n]);
    }
}