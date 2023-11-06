import java.util.*;
class Solution {
    
    static boolean visit[];
    
    //현재의 노드숫자와 1로부터 떨어진 거리를 저장할 노드
    static class node{
        int num;
        int dis;
        node(int num,int dis ){
            this.num =num;
            this.dis= dis;
        }
    }
    
    public int solution(int n, int[][] edge) {
        
        //간선을 저장할 list
        ArrayList<Integer>[]list = new ArrayList[n+1];
        
        //list 초기화
        for(int i = 1 ; i <=n ; ++i){
            list[i] = new ArrayList<>();
        }
        
        //양방향 노드므로 각각에 추가
        for(int i = 0 ; i < edge.length;++i){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<node>q = new LinkedList<>();
        visit = new boolean[n+1];
        
        //1부터 시작
        visit[1] = true;
        q.add(new node(1,0));
        
        
        int cnt = 0; // max거리와 같은 노드의 개수
        int max = 0; 
        int vis = 1;
        bfs : while(!q.isEmpty()){
            node temp = q.poll();
            
            for(int c : list[temp.num]){
                if(!visit[c]){
                    visit[c] = true;
                    q.add(new node(c,temp.dis+1));
                    
                    //max보다 크면 max초기화 및 cnt초기화
                    if(max<temp.dis+1){
                        max = temp.dis+1;
                        cnt=1;
                    } //max와 같다면 cnt더하기
                    else if(max == temp.dis+1){
                        cnt++;
                    }
                    vis++;
                    if(vis==n){
                        break bfs;
                    }
                }
            }
        }
        
        return cnt;
        
    }
}