class Solution {
    static int n;
    static int[][] q;
    static int[] ans;
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        answer = 0;
        
        comb(0 , 0 , 0); //depth , 마지막 숫자 , 방문체크
        
        return answer;
    }
    
    void comb(int depth , int lastNum , int visit){
        if(depth == 5){ // 5개 조합 전부 구했으므로 조건 체크
            for(int i = 0 ; i < q.length ; ++i){
                int cnt = 0;
                for(int j = 0 ; j < 5 ; ++j){
                    if((visit & (1 << q[i][j])) != 0){
                        cnt++;
                    }
                }
                if(ans[i] != cnt){
                    return;
                }
            }
            answer++;
            return;
        }
        for(int i = lastNum + 1 ; i <= n ; ++i){
            comb(depth+1 , i , visit | (1<<i));
        }
    }
}