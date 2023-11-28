class Solution {
    static int[][] lands;
    int solution(int[][] land) {
        lands = land;
        
        for(int i = 1 ; i < land.length; ++i){
            for(int j = 0 ; j < 4; ++j){
                find(i,j);
            }
        }
        int max = 0;
        for(int i = 0 ; i < 4 ; ++i){
            max = Math.max(lands[lands.length-1][i],max);
        }
        return max;
    }
    
    static void find(int r , int c){
        int max = 0;
        for(int i = 0 ; i < 4 ; ++i){
            if(i==c) continue;
            max = Math.max(max,lands[r-1][i]);
        }
        lands[r][c] = max + lands[r][c];
    }
}