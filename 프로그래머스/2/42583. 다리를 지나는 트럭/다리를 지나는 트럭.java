import java.util.*;
class Solution {
    
    static class node{
        int wei ; 
        int dis;
        node(int wei,int dis){
            this.wei = wei;
            this.dis = dis;
        }
    }
    static int nowwei;
    static int time;
    static Queue<node> q;
    static int length;
    
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        nowwei = 0;
        time = 0;
        length = bridge_length;
        q = new LinkedList<>();
        
        for(int i = 0 ; i < truck_weights.length ;++i ){
            
            //들어갈 수 있는 지 없는지
            
            //1 들어갈 수 있다.
            if(nowwei+truck_weights[i]<=weight && q.size()<bridge_length ){
                pushone(truck_weights[i]);
            }else{
                while(!(nowwei+truck_weights[i]<=weight && q.size()<bridge_length )){
                    //들어갈 수 없다면 1개 빼기 반복 -> 
                    //여기서는 다음 1개 들어갈 때 +1초 되므로 끝 라인에만 맞추기
                    delete();
                }
                q.add(new node(truck_weights[i],1));
                nowwei += truck_weights[i];
            }
            
            
        }//전체 반복 종료
        while(q.size()>=2){
            q.poll();
        }
        if(q.size()==1){
            time += length-(q.poll()).dis+1;
        }
        return time;
    }
    static void pushone(int truck){
        time++;
        boolean flag = false;
        for(node c : q){
            c.dis = c.dis +1;
            if(c.dis ==length+1){
                flag = true;
            }
        }
        if(flag){
            node temp = q.poll();
            nowwei -= temp.wei;
        }
        q.add(new node(truck,1));
        nowwei += truck;
    }
    
    static void delete(){
        node temp = q.poll();
        int resttime = length - temp.dis+1;
        nowwei -= temp.wei;
        for(node c : q){
            c.dis = c.dis +resttime;
        }
        time += resttime;
    }
}