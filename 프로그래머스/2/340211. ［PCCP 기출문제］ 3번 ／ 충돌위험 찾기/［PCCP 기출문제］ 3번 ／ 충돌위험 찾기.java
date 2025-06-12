import java.util.*;
class Solution {
    static int[][] points;
    public int solution(int[][] points, int[][] routes) {
        this.points = points;

        //현재 로봇이 있는 곳
        HashMap<node , Boolean> crush = new HashMap<>();
        int crushCnt = 0;
        
        //로봇 리스트(현 좌표와 목적지 좌표 보유)
        ArrayList<robot> list = new ArrayList<>();
        
        for(int[]c : routes){
            int startIdx = c[0] - 1;
            //시작 좌표
            node start = new node(points[startIdx][0] , points[startIdx][1]);
            list.add(new robot(start , 0,c));
        }
        
        while(list.size() > 0){
            crush.clear();
            Iterator<robot> it = list.iterator();
            
            while (it.hasNext()) {
                robot temp = it.next();
                node now = temp.pos;
                int nowIdx = temp.idx;
                //일단 현재 지점 충돌 리스트에 넣기(충돌횟수 카운트)
                crushCnt += addMap(new node(now.r,now.c) , crush);
                
                //다음 지점이 존재한다면 이동 , 없다면 제거
                if(temp.move()){
                    it.remove();
                }
            }
        }
        
        //1칸 옮기며 충돌 체크
        return crushCnt;
        
        
    }
               
    int addMap(node start , HashMap<node , Boolean> crush){
        if(crush.containsKey(start)){
            if(crush.get(start) == false){
                crush.put(start,true);
                return 1;
            }
        }
        else{
            crush.put(start,false);
        }
        return 0;
    }
    
    class node {
        int r;
        int c;
        node(int r , int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof node)) return false;
            node other = (node) obj;
            return this.r == other.r && this.c == other.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    
    class robot{ // 현재 위치 , 현재 인덱스 , 루트 전체
        node pos;
        int idx;
        int[] route;
        robot(node pos , int idx , int[] route){
            this.pos = pos;
            this.idx = idx;
            this.route = route;
        }
    
        
        boolean move(){
            if(idx == route.length-1) return true;
            
            int nextPoint = route[idx+1];
            int nextR = points[nextPoint-1][0];
            int nextC = points[nextPoint-1][1];
            if(pos.r != nextR){
                pos.r += (nextR-pos.r)/(Math.abs(nextR-pos.r));
            }
            else if(pos.c != nextC){
                pos.c += (nextC-pos.c)/(Math.abs(nextC-pos.c));
            }
            if(pos.r == nextR && pos.c == nextC){
                idx++;
            }

            return false;
        }
    }
}





// import java.util.HashMap;
// import java.util.Objects;

// class Solution {

//     public  int solution(int[][] points, int[][] routes) {

//         //routes 가 가리키는 숫자는 1이상으로 -1해야함

//         //0 초에 동시출발, r또는 c 1씩 변환 가능
//         // r이 먼저 이동
//         //마지막 포인트 도착 시

//         // 2대 이상 모이면 충돌, 충돌횟수 (시작, 종료지점 포함)
//         int size = routes.length;
//         int cnt = size;

//         int end = routes[0].length - 1;

        
//         HashMap<node,Boolean> map = new HashMap<>();
//         node[] position = new node[size];
//         int []idx = new int[size];// getPosNum(i,idx[i],routes) => i번째 사람의idx번째 갈 곳의 포인트 인덱스를 받음

//         for (int i = 0; i < size; i++) {
//             int posIdx = getPosNum(i,idx[i],routes);
//             position[i] = new node(points[posIdx][0],points[posIdx][1]);
//         }

//         int res = 0;

//         for (int i = 0; i < size; i++) {
//             if(map.containsKey(position[i])){ // 이미 존재하는 것이 있고
//                 if(!map.get(position[i])){ // 다른건 방문 없었다면
//                     res++;
//                     map.put(position[i],true);
//                 }
//             }else{
//                 map.put(position[i],false);
//             }
//         }

//         while(cnt > 0){
//             map.clear();
//             //현 위치를 넣고 충돌인지 확인한다.

            
//             //1초 후의 위치로 옮긴다.
//             for (int i = 0; i < size; i++) {
//                 //다음 인덱스가 존재한다면
//                 if(idx[i] == end) continue;
//                 //다음 인덱스의 방향으로 가기
//                 int nextIdx = getPosNum(i,idx[i]+1,routes);
//                 int nextR = points[nextIdx][0];
//                 int nextC = points[nextIdx][1];

//                 if(position[i].r != nextR){// r옮기기
//                     position[i].r += (nextR-position[i].r)/Math.abs(nextR-position[i].r);
//                 }
//                 else{//c옮기기
//                     position[i].c += (nextC-position[i].c)/Math.abs(nextC-position[i].c);
//                 }


//                 if(map.containsKey(position[i])){ // 이미 존재하는 것이 있고
//                     if(!map.get(position[i])){ // 다른건 방문 없었다면
//                         res++;
//                         map.put(position[i],true);
//                     }
//                 }else{
//                     map.put(position[i],false);
//                 }


//                 // 현 지점이 다음 지점이라면 idx를 옮긴다.
//                 if(position[i].r == nextR && position[i].c == nextC){
//                     idx[i]++;
//                 }

//                 //현 지점이 종료점이라면 cnt--를 한다.
//                 if(idx[i] == end){
//                     cnt--;
//                 }


//             }
            

//         }

//         return res;


//     }

//     static int getPosNum(int i , int idx , int[][] routes){

//         return routes[i][idx]-1;
//     }
    
//     static class node{
//         int r,c;
//         node(int r,int c){
//             this.r=r;
//             this.c=c;
//         }
        
//         @Override
//         public int hashCode(){
//             return Objects.hash(r,c);
//         }
        
//         @Override
//         public boolean equals(Object o){
//            if(o == null) return false;
//            if(o == this) return true;
//            if(o instanceof node){
//                node n = (node)o;
//                return n.r==r && n.c==c;
               
//            }
//            return false;
//         }
//     }
// }