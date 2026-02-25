import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
        if(a[1] == b[1]) return Integer.compare(a[0] , b[0]);
        return Integer.compare(a[1],b[1]);
    });
    static Map<Integer , Integer>map = new HashMap<>();
    static int[]cnt = new int[101];
    static int nr = 3;
    static int nc = 3;
    static int[][] list = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < 3 ; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; ++j) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i <=100 ; ++i){
            if(chk(list , r,c,k)){
                System.out.println(i);
                return;
            }

            if(nr >= nc){
                nc = r();
            }
            else{
                nr = c();
            }
        }
        System.out.println(-1);
    }

    private static int r(){
        int maxLen = -1;

        for(int i = 0 ; i < nr ; ++i){
            int idx = 0;
            for (int j = 0; j < nc; j++) {
                if(list[i][j] == 0) continue;
                map.merge(list[i][j], 1, (oldValue, newValue) -> oldValue + 1);
            }
            for(int k : map.keySet()){
                pq.add(new int[] {k , map.get(k)});
            }
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                list[i][idx++] = temp[0];
                list[i][idx++] = temp[1];
                if(idx >= 100) break;
            }
            for(int k = idx ; k < Math.min(2*nr , 100) ; ++k){
                list[i][k] = 0;
            }
            maxLen = Math.max(maxLen , idx);
            map.clear();
            pq.clear();
        }
        return maxLen;
    }

    private static int c(){
        int maxLen = -1;

        for(int i = 0 ; i < nc ; ++i){
            int idx = 0;
            for (int j = 0; j < nr; j++) {
                if(list[j][i] == 0) continue;
                map.merge(list[j][i], 1, (oldValue, newValue) -> oldValue + 1);
            }
            for(int k : map.keySet()){
                pq.add(new int[] {k , map.get(k)});
            }
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                list[idx++][i] = temp[0];
                list[idx++][i] = temp[1];
                if(idx >= 100) break;
            }
            for(int k = idx ; k < Math.min(2*nc , 100) ; ++k){
                list[k][i] = 0;
            }
            maxLen = Math.max(maxLen , idx);
            map.clear();
            pq.clear();
        }
        return maxLen;
    }


    private static boolean chk(int[][] list , int r , int c , int target){
        return list[r][c] == target;
    }
}