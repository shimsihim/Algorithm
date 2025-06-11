class Solution {
    
    static int[] diffs;
    static int[] times;
    static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int level = 0;
        int start = 1;
        int end = 100000;
        
        //이분 탐색을 통하여 상한 구하기
        while(start < end){
            int mid = start + (end-start)/2;
            if(isPossible(mid)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }
    
    boolean isPossible(int level){
        long totalTime = 0;
        for(int i = 0 ; i < diffs.length ; ++i){
            int prevTime = 0;
            if(i != 0){
                prevTime = times[i-1];
            }
            if(diffs[i] > level){ // 난이도가 높을 경우 (이전퍼즐시간 + 현재퍼즐시간)*(퍼즐난도-level) + 현재퍼즐시간
                totalTime += (prevTime + times[i]) * (diffs[i]-level) + times[i];
            }
            else{ // 낮을 경우 현재퍼즐시간
                totalTime += times[i];
            }
            if(totalTime > limit){
                return false;
            }
        }
        return true;
    }
}













// import java.util.*;
// import java.io.*; 
// class Solution {
//     public long solution(int[] diffs, int[] times, long limit) {
//         long answer = Long.MAX_VALUE;
//         //숙련도의 최소 = 1, 최대는 diffs 의 최댓값?
//         int start = 1;
//         int end = 100000;  
        
//         while(start<=end){
//             int mid = (start+end)/2;
            
//             //times 만큼 돌면서, 로직체크 
//             // 숫자가 limit 보다 작으면 start 를 늘리고, 크면 end 를 줄인다. 숫자는 숙련도
//             long sum = times[0];//첫번째는 무조건 통과가능 
//             for(int i=1; i<times.length; i++){
//                 if(diffs[i]<= mid){
//                     sum+=times[i];
//                 }else{
//                     sum+= (diffs[i]-mid)*(times[i]+times[i-1])+times[i];
//                 }
//             }
            
//             if(sum <= limit){ 
//                 answer = Math.min(answer, mid);
//                 end = mid-1;
//             }else{
                
//                 start = mid+1;
//             } 
            
//         }
        
//         return answer;
//     }
// }