import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n*n배열
        int l = Integer.parseInt(st.nextToken()); // 최소
        int r = Integer.parseInt(st.nextToken()); // 최대

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = -1;
        boolean flag = true;
        while(flag){
            cnt++;
            flag = false;
            boolean visit[][] = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visit[i][j]){
                        flag |= bfs(map,visit,i,j,l,r,n);
                    }
                }
            }

        }

        System.out.println(cnt);




    }
    static int dr[] = {-1,0,0,1};
    static int dc[] = {0,-1,1,0};

    private static boolean bfs(int[][] map, boolean[][] visit, int i, int j,int l,int r,int n) {

        Queue<int[]>q = new LinkedList<>();
        visit[i][j] = true;
        q.add(new int[]{i,j});

        List<int[]>list = new ArrayList<>();
        list.add(new int[]{i,j});
        int sum = map[i][j];
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for (int k = 0; k < 4; k++) {
                int row = temp[0]+dr[k];
                int col = temp[1]+dc[k];
                if(row>=0 && col >=0 && row<n && col < n && !visit[row][col]
                        && Math.abs(map[temp[0]][temp[1]]-map[row][col])>=l && Math.abs(map[temp[0]][temp[1]]-map[row][col])<=r){
                    list.add(new int[]{row,col});
                    visit[row][col] = true;
                    q.add(new int[]{row,col});
                    sum += map[row][col];
                }
            }

        }
        sum /= list.size();
        for(int[] c : list){
            map[c[0]][c[1]] = sum;
        }

        if (list.size()>1){
            return true;
        }
        return false;
    }
}