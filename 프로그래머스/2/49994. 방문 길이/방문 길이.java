import java.util.*;

class Solution {
    
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    
    public int solution(String dirs) {
        
        HashSet<fromTo> set = new HashSet<>();
        
        int row = 0,col = 0;
        int cnt=0;
        
        for(int i = 0 ; i < dirs.length();++i){
            int dir = 0;
            if(dirs.charAt(i)== 'U'){
                dir = 0;
            }
            else if(dirs.charAt(i)== 'L'){
                dir = 1;
            }
            else if(dirs.charAt(i)== 'R'){
                dir = 2;
            }
            else if(dirs.charAt(i)== 'D'){
                dir = 3;
            }
            fromTo temp = new fromTo(row,col,row+dr[dir],col+dc[dir]);
            row += dr[dir];
            col += dc[dir];
            if(!(row>=-5 && row<=5 && col >=-5 && col<=5)) {
                row -= dr[dir];
                col -= dc[dir];
                continue;
            }
            if(!set.contains(temp)){
                set.add(temp);
                cnt++;
            }
        }
        
        
        return cnt;
    }
    
    static class fromTo{
        int startR;
        int startC;
        int endR;
        int endC;
        
        fromTo(int startR,int startC,int endR,int endC){
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
        }
        @Override
public int hashCode() {
    int result = Integer.hashCode(Math.min(startR, endR));
    result = 31 * result + Integer.hashCode(Math.max(startR, endR));
    result = 31 * result + Integer.hashCode(Math.min(startC, endC));
    result = 31 * result + Integer.hashCode(Math.max(startC, endC));
    return result;
}
        @Override
        public boolean equals( Object o){
            if(this == o) return true;
            if(this == null || getClass() != o.getClass()) return false;
            fromTo temp = (fromTo)o;
            return startR == temp.startR && startC == temp.startC && endR==temp.endR && endC == temp.endC
                ||endR == temp.startR && endC == temp.startC && startR==temp.endR && startC == temp.endC;
        }
    }
}