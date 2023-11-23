import java.util.*;


class Solution {
    
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long min = 0;
        long max = (long)n*times[times.length-1];
        long mid = 0;
        long answer = Long.MAX_VALUE;
        long cnt = 0;
        
        
        while(min<=max){
            mid = (min+max)/2;
            cnt =  howmany(times,mid);
            if(cnt>=n){
                //내리기
                answer = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
            
        }
        return answer;
    }
    
    public static long howmany(int[] times,long time){
        
        long cnt = 0;
        
        for(int i = 0 ; i < times.length ; ++i){
            cnt+=(time/times[i]);
        }
        
        return cnt;
        
        
    }
}