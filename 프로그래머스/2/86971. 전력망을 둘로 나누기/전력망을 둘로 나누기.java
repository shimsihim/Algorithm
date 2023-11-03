import java.util.*;
class Solution {
    
    static ArrayList<Integer> list[];
    static boolean visit[];
    static int cnt[];
    
    public int solution(int n, int[][] wires) {
        
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        cnt = new int[n+1];
        for(int i =1 ; i < n+1 ; ++i){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < wires.length ; ++i){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        
        dfs(1);
        int res = Integer.MAX_VALUE;
        for(int i =1 ; i <= n ; ++i){
            if(res>Math.abs(n-2*cnt[i])){
                res = Math.abs(n-2*cnt[i]);
            }
        }
        return res;
    }
    
    static int dfs(int num){
        visit[num] = true;
        int sum = 0;
        for(int c : list[num]){
            if(!visit[c]){
                sum+=dfs(c);
            }
        }
        cnt[num] = sum+1;
        return cnt[num];
    }
}