import java.util.*;
import java.io.*;



class Main {
    
    static int[] position;
    static int[][] map;
    static int cnt;
    static int n,m;
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        position = new int[3];
        
        st = new StringTokenizer(br.readLine());
        position[0] = Integer.parseInt(st.nextToken());
        position[1] = Integer.parseInt(st.nextToken());
        position[2] = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < n ; ++i){ // map초기화
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        boolean flag = false;
        int row = 0;
        int col = 0;
        
        while(true){
            if(map[position[0]][position[1]]==0){
                cnt++;
                map[position[0]][position[1]] = -1;
            }
            flag = false;
            for(int i = 0 ; i < 4 ; ++i){//4방향 중 청소하지 않은 칸 있는지
                row = position[0] + dr[i];
                col = position[1] + dc[i];
                if(check(row,col) && map[row][col]==0){ // 청소하지 않은 칸이 존재
                    flag = true;
                    break;
                }
            }
            
            if(flag){ // 청소해야 할 칸 존재할 시
                //1. 반시계방향으로 회전
                position[2]--;
                if(position[2]==-1) position[2] = 3;
                //2. 바라보는 방향 기준으로 앞칸이 청소 필요할 시 한칸 전진
                row = position[0] + dr[position[2]];
                col = position[1] + dc[position[2]];
                if(check(row,col) && map[row][col] ==0){
                    position[0] = row;
                    position[1] = col;
                }
                
            }
            else{ // 4방 깨끗할 시
                row = position[0] - dr[position[2]];
                col = position[1] - dc[position[2]]; 
                if(check(row,col) && map[row][col]!=1){
                    position[0] = row;
                    position[1] = col;
                }
                else{
                    break;
                }
            }
        }
        System.out.print(cnt);
        
        
    }
    
    static boolean check(int row,int col){
        if(row>=0 && row<n && col >=0 && col <m){
            return true;
        }
        return false;
    }
}