import java.util.*;
import java.io.*;

class Solution{
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][] sero = new boolean[11][11][11];
        boolean[][][] garo = new boolean[11][11][11];
        char[] direction = dirs.toCharArray();
        int nr = 5;
        int nc = 5;
        for(int i=0; i<dirs.length(); i++){
            if(direction[i]=='U' && nr-1 >= 0){
                if(!sero[nr-1][nr][nc] && !sero[nr][nr-1][nc]) {
                    sero[nr-1][nr][nc] = true;
                    sero[nr][nr-1][nc] = true;
                    answer++;
                }
                nr-=1;
            }else if(direction[i]=='D' && nr+1 <= 10){
                if( !sero[nr+1][nr][nc] && !sero[nr][nr+1][nc]){
                    answer++;
                    sero[nr+1][nr][nc] = true;
                    sero[nr][nr+1][nc] = true;
                }
                nr+=1;
            }else if(direction[i]=='L' && nc-1 >=0 ){
                if(!garo[nr][nc-1][nc] && !garo[nr][nc][nc-1]){
                    answer++;
                    garo[nr][nc-1][nc] = true;
                    garo[nr][nc][nc-1] = true;
                }
                nc-=1;
            }else if(direction[i]=='R' && nc+1 <= 10  ){
                if(!garo[nr][nc+1][nc] && !garo[nr][nc][nc+1]){
                    answer++;
                    garo[nr][nc+1][nc] = true;
                    garo[nr][nc][nc+1] = true;
                }
                nc+=1;
            }
        }

        return answer;
    }
}