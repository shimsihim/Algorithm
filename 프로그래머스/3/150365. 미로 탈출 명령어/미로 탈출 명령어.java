import java.util.*;
class Solution {
    
    static int n,m,startR , startC , endR, endC, k;
    static StringBuilder sb;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();
        this.n = n ; 
        this.m = m;
        startR = x;
        startC = y;
        endR = r;
        endC = c;
        this.k = k;
        dfs(startR , startC , k);
        if(sb.length() == 0) return "impossible";
            
        return sb.reverse().toString();
    }
    
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static char[] c = {'d' , 'l' , 'r' , 'u'};
    //d(아래) , l(왼쪽) , r(오른쪽) , u(위)
    
    public static void dfs(int nowR , int nowC ,int k){
        
        if(k == 0 && nowR == endR && nowC == endC) return;
        
        if(!canGo(nowR , nowC , k)) return;
        
        for(int i = 0 ; i < 4 ; ++i){
            int nextR = nowR + dr[i];
            int nextC = nowC + dc[i];
            if(canGo(nextR, nextC , k-1)){
                dfs(nextR, nextC , k-1);
                sb.append(c[i]);
                break;
            }
        }
        return;
    }
    
    public static boolean canGo(int nowR,int nowC , int leftK){
        
        if(nowR < 1 || nowR > n || nowC < 1 || nowC > m) return false;
        
        int remain = Math.abs(endR - nowR) + Math.abs(endC - nowC);
        
        if(remain > leftK || (leftK - remain) % 2 != 0) return false;
        
        return true;
    }
}