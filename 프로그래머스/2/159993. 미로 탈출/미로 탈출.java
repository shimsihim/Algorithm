import java.util.*;
class Solution {
    
    static int startr;
    static int startc;
    static int exitr;
    static int exitc;
    static int labr;
    static int labc;
    static String map[];
    static int rowsize;
    static int colsize;
    static int res;
    static boolean visit[][] ;
    
    static int dr[] = {-1,0,0,1};
    static int dc[] = {0,-1,1,0};
    
    static Queue<node>q;
    
    static class node{
        int r;
        int c;
        int cost;
        node(int r , int c , int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    public int solution(String[] maps) {
        map = maps;
        rowsize = maps.length;
        colsize = maps[0].length();
        q = new LinkedList<>();
        visit = new boolean[rowsize][colsize];
        res = -1;
        
        for(int i = 0 ; i < rowsize ; ++i){
            for(int j = 0 ; j < colsize ; ++j){
                if(maps[i].charAt(j)=='S'){
                    startr = i ; 
                    startc = j;
                }
                else if(maps[i].charAt(j)=='E'){
                    exitr = i ; 
                    exitc = j;
                }
                else if(maps[i].charAt(j)=='L'){
                    labr = i ; 
                    labc = j;
                }
            }
        }//for문 끝남
        
        //일단 초기지점 넣기
        q.add(new node(startr,startc,0));
        visit[startr][startc] = true;
        
        int row = 0;
        int col = 0;
        
        al:while(!q.isEmpty()){
            node temp = q.poll();
            for(int i = 0 ; i < 4 ; ++i){
                if(poss(temp,i)){// 4방이 가능한지
                    row = temp.r + dr[i];
                    col = temp.c + dc[i];
                    if(row == labr && col==labc){
                        res = temp.cost+1;
                        // return 10;
                        break al;
                    }
                    visit[row][col] = true;
                    q.add(new node(row,col,temp.cost+1));
                }
            }
        }
        
        //while문 내에서 레버 도착하면 일단 완전 빠져나오기.//여기서 레버까지 거리 즉 res가 -1이라면 불가능
        if(res ==-1){
            return res;
        }
        //다시 while문 돌리기
        int res2 = 0;
        q.clear();
        visit = new boolean[rowsize][colsize];
        q.add(new node(labr,labc,0));
        visit[labr][labc] = true;
        
        al:while(!q.isEmpty()){
            node temp = q.poll();
            for(int i = 0 ; i < 4 ; ++i){
                if(poss(temp,i)){// 4방이 가능한지
                    row = temp.r + dr[i];
                    col = temp.c + dc[i];
                    if(row == exitr && col==exitc){
                        res2 += temp.cost+1;
                        break al;
                    }
                    visit[row][col] = true;
                    q.add(new node(row,col,temp.cost+1));
                }
            }
        }
        
        
        if(res2==0){
            return -1;
        }
        return res+res2;
        
    }
    static boolean poss(node temp , int i){
        if(temp.r + dr[i]>=0 && temp.r + dr[i]<rowsize &&
          temp.c + dc[i]>=0 && temp.c + dc[i]<colsize &&
          (map[temp.r + dr[i]].charAt(temp.c + dc[i]) == 'O'||map[temp.r + dr[i]].charAt(temp.c + dc[i]) == 'L'||map[temp.r + dr[i]].charAt(temp.c + dc[i]) == 'E'
          ||map[temp.r + dr[i]].charAt(temp.c + dc[i]) == 'S') &&
          !visit[temp.r + dr[i]][temp.c + dc[i]]){
            return true;
        }
        return false;
    }
    
}