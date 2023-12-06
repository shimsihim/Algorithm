import java.util.*;
import java.io.*;
class Main {
    
    static int[] list;
    static boolean visit[];
    static int cnt;
    static int n;
    
    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        list = new int[n+1];
        visit = new boolean[n+1];
        cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int  i= 1 ; i < n+1 ; ++i){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        
        dfs(start);
        System.out.println(cnt);
        
    }
    
    static void dfs(int num){
        if(visit[num]){
            return;
        }
        visit[num] = true;
        cnt++;
        
        if(num-list[num]>=1){
            dfs(num-list[num]);
        }
        
        if(num+list[num]<=n){
            dfs(num+list[num]);
        }
    }
}