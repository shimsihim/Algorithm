class Solution {
    
    static long[][]dp;
    static int seq[];
    public long solution(int[] sequence) {
        
        
        seq = sequence;
        dp = new long[2][sequence.length];
        dp[0][0] = -1*sequence[0];
        dp[1][0] = sequence[0];
       
        for(int i = 1 ; i <sequence.length;++i ){
            devide(0,i);
            devide(1,i);
        }
        long max = -10000000000l;
        for(int i = 0 ; i < sequence.length;++i){
            for(int j = 0 ; j < 2 ; ++j){
                if(max<dp[j][i]){
                    max = dp[j][i];
                }
            }
        }
        return max;
    }
    
    static void devide(int row,int col){
        if(row==0 && col%2==0){
            minus(row,col);
        }
        else if(row==0 && col%2!=0){
            plus(row,col);
        }
        else if(row==1 && col%2==0){
            plus(row,col);
        }
        else {
            minus(row,col);
        }
    }
    
    static void plus(int row,int col){
        long res = 0;
        
        res = dp[row][col-1]+seq[col];
            if(res>seq[col]){
                dp[row][col] = res;
            }
            else{
                dp[row][col] = seq[col];
            }
    }

    static void minus(int row,int col){
        long res = 0;
        
        res = dp[row][col-1]-1*seq[col];
            if(res>-1*seq[col]){
                dp[row][col] = res;
            }
            else{
                dp[row][col] = -1*seq[col];
            }
    }
}