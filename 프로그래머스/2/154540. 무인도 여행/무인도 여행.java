import java.util.*;
class Solution {
    
    static int cnt;
    static boolean[][] visit;
    static int sum;
    static String[] mapcopy;
    
    public int[] solution(String[] maps) {
        cnt = 0;
        sum = 0;
        mapcopy = maps;
        visit = new boolean[maps.length][maps[0].length()];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        char temp = '0';
        for(int i = 0 ; i < maps.length; ++i){
            for(int j = 0 ; j < maps[0].length();++j){
                
                temp = maps[i].charAt(j);
                if(visit[i][j] || temp == 'X') continue; // 방문했거나 바다면 pass
                sum = 0;
                visit[i][j] = true;
                dfs(i,j);
                
                list.add(sum);
                
            }
        }
        int size = list.size();
        if(size==0){
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int dr[] = {-1,0,0,1};
    static int dc[] = {0,-1,1,0};
    
    public static void dfs(int i , int j){
        
        sum += (mapcopy[i].charAt(j))-'0';
        int r = 0,c=0;
        
        for(int k = 0 ; k < 4 ; ++k){
            r = i+dr[k];
            c = j + dc[k];
            if(check(r,c)){
                visit[r][c] = true;
                dfs(r,c);
            }
        }
        
    }
    
    public static boolean check(int i , int j){
        if(i>=0 && j>=0&&i<mapcopy.length && j<mapcopy[0].length() 
           && !visit[i][j] && mapcopy[i].charAt(j)!='X'){
            return true;
        }
        return false;
    }
}