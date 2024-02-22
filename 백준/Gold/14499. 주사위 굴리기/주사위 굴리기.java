import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static int x;
    static int y,n,m;
    static int[][] map;
    static int[] dice;
    public static void main(String dirs[]) throws IOException {
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());


        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[6];
        //0 : 위  1:상단  2: 아래(땅)  3: 하단  4 : 좌측  5: 우측
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            boolean flag = false;
            flag = check(Integer.parseInt(st.nextToken())-1);
            if(flag){

                if(map[x][y] !=0){
                    dice[2] = map[x][y];
                    map[x][y] = 0;
                }
                else{
                    map[x][y] = dice[2];
                }
                System.out.println(dice[0]);
            }
        }




    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {1,-1,0,0};
    private static boolean check(int i) {

        //0은 오른쪽 1는 왼쪽 , 2은 위 , 3는 아래
        int row = x+dr[i];
        int col = y+dc[i];
        if(!(row>=0 && col>=0 && row<n && col<m)) return false;

        x = row;y=col;

        //0 : 위  1:상단  2: 아래(땅)  3: 하단  4 : 좌측  5: 우측
        int temp = 0;
        if (i==0){ // 오른쪽
            temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[5];
            dice[5] = temp;
        }
        else if (i==1) { // 왼쪽
            temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[4];
            dice[4] = temp;
        }
        else if (i==2) {//위
            temp = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[0];
            dice[0] = temp;
        }
        else{//아래
            temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = temp;
        }
        return true;
    }
}