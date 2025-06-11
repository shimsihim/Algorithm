import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int nowServer = 0;
        Queue<server> q = new LinkedList<>();
        for(int i = 0 ; i < 24 ; ++i){
            //필요한 서버의 수 : playsers[i] /m
            //우선 현재 증설된 서버에서 기간이 만료되면 종료시키고
            //증설이 필요한 서버의 수 큐에 
            int needServer = players[i] / m;
            if(q.size() > 0){
                server temp = q.peek();
                if(i-temp.startIdx >= k){ // 시간이 종료되었을 경우
                    q.poll();
                    nowServer -= temp.cnt;
                }
            }
            if(needServer > nowServer){
                answer += needServer - nowServer;
                q.add(new server(i,needServer - nowServer));
                nowServer = needServer;
            }
            
        }
        return answer;
    }
    
    class server{
        int startIdx;
        int cnt;
        server(int startIdx , int cnt){
            this.startIdx = startIdx;
            this.cnt = cnt;
        }
    }
}