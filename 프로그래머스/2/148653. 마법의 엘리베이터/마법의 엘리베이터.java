class Solution {
    public int solution(int storey) {
        
        int cnt = 0;
        int left = 0;
        
        
            
       dfs(0,storey);
            
            
      
        return min;
    }
    
    public static int min = Integer.MAX_VALUE;
    
    static void dfs(int cnt, int remain){
        if(remain==0){
            if(min>cnt){
                min = cnt;
            }
            return;
        }if(cnt>min){
            return;
        }
        
        int left = remain%10;
        remain = remain/10;
        
        dfs(cnt+left,remain);
        dfs(cnt+(10-left),remain+1);
        
        
    }
    
}