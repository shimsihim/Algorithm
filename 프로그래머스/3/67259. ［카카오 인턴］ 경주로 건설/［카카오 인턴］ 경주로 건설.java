import java.util.*;
class Solution {
    
    static class node{
        int prer;
        int prec;
        int r;
        int c;
        int cost;
        node(int prer,int prec,int r,int c, int cost){
            this.prer = prer;
            this.prec = prec;
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    static int [][] cost;
    static Queue<node> q;
    static int[][] map;
    
    static int dr[] = {0,-1,1,0};
    static int dc[] = {-1,0,0,1};
    static int n;
    
    public int solution(int[][] board) {
        
        n=board.length;
        q = new LinkedList<node>();
        cost = new int[board.length][board.length];
        map = board;
        for(int i = 0 ; i < n ; ++i){Arrays.fill(cost[i],10000000);}
        cost[0][0] = 0;
        q.add(new node(0,0,0,0,0));
        
        while(!q.isEmpty()){
            node temp = q.poll();
            
            for(int i = 0 ; i < 4 ; ++i){
                go(temp,i);
            }
            
        }
        
        return cost[n-1][n-1];
        
    }
    static void go(node temp, int k){
        int nextr = temp.r+dr[k];
        int nextc = temp.c + dc[k];
        if(nextr == temp.prer && nextc == temp.prec ||
            !(nextr>=0&&nextr<n && nextc>=0&&nextc<n ) ||
            map[nextr][nextc]==1){
            return;
        }
        int pluscost = 100;
        if(iscorner(temp,nextr,nextc)){
            pluscost += 500;
        }
        if(cost[nextr][nextc]+600<= temp.cost+pluscost){
            return;
        }
        cost[nextr][nextc] = Math.min(cost[nextr][nextc],temp.cost+pluscost);
        if(nextr == n-1 && nextc==n-1) return;
        q.add(new node(temp.r,temp.c,nextr,nextc,temp.cost+pluscost));
        
    }
    static boolean iscorner(node temp,int nextr,int nextc){
        if(temp.prer!=nextr && temp.prec!=nextc){
            return true;
        }
        return false;
    }
}