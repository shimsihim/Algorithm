import java.util.*;
class Solution {
    static ArrayList<Integer>[]list;
    static boolean[] visit;
    static int[][] edges;
    static int main;
    public int[] solution(int[][] edges) {
        int max = 0; // 몇번 노드까지 존재하는지
        int[][] inout = new int[1000001][2];
        int maxOut = 0;// 메인노드에서 몇개 밖으로 나가는지
        main = -1;
        

        for(int i = 0 ; i < edges.length ; ++i){
            max = Math.max(max,edges[i][0]);
            max = Math.max(max,edges[i][1]);
            inout[edges[i][0]][0]++;
            inout[edges[i][1]][1]++;
        }
        visit = new boolean[max+1];
        for(int i = 1 ; i <= max ; ++i){
            if(inout[i][0] >maxOut && inout[i][1] == 0){
                main = i;
                maxOut = inout[i][0];
            }
        }
        
        list = new ArrayList[max+1];
        for(int i = 1 ; i < max+1 ; ++i){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < edges.length ; ++i){
            int from = edges[i][0];
            int to = edges[i][1];
            list[from].add(to);
        }
        
        int[] ret = new int[4];
        ret[0] = main;
        
        for(int c : list[main]){
            int[] re = getNodeLine(c);
            if(re[0] == re[1]){//node,lione
                ret[1]++;
            }
            else if(re[0] == re[1]+1){
                ret[2]++;
            }
            else{
                ret[3]++;
            }
        }
        

        
        return ret;
    }
    
    static int[] getNodeLine(int start){
        int nodeCnt = 1;
        int lineCnt = 0;
        
        Queue<Integer>q = new LinkedList<>();
        q.add(start);

        visit[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int c : list[temp]){
                if(!visit[c]){
                    visit[c]  = true;
                    q.add(c);
                    nodeCnt++;
                }
                lineCnt++;
            }
        }
        
        return new int[] {nodeCnt,lineCnt};
    }

}