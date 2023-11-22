import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int max  = 0;
        int index = 0;
        for(int i = citations.length-1 ; i>=0 ; --i){
            index++;
            int min = Math.min(index,citations[i]);
            max = Math.max(min,max);
        }
        return max;
    }
}