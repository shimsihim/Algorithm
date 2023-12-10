import java.util.*;

class Solution {
    
    static HashMap<Integer,Integer> sizeToCnt;
    static ArrayList<Integer> cntToSize;// 0번인덱스는 개수, 1번은 사이즈
    
    static int min;
    
    public int solution(int k, int[] tangerine) {
        
        sizeToCnt = new HashMap<>();
        cntToSize = new ArrayList<>();
        min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < tangerine.length; ++i){
            if(sizeToCnt.containsKey(tangerine[i])){
                sizeToCnt.put(tangerine[i],sizeToCnt.get(tangerine[i])+1);
            }
            else{
                sizeToCnt.put(tangerine[i],1);
            }
        }
        
        Set<Integer> keys = sizeToCnt.keySet();
        
        
        for(int c : keys){
            cntToSize.add(sizeToCnt.get(c));
        }
        
        Collections.sort(cntToSize);
        
        int sum =0;
        int cnt = 0;
        
        for(int i = cntToSize.size()-1 ; i >=0 ; --i){
            sum += cntToSize.get(i);
            cnt++;
            if(sum>=k) break;
        }
        
        return cnt; 
        
    }
    
    
}