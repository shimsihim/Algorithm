import java.util.*;
class Solution {
    public int solution(int[] a) {
        
        HashSet<Integer> set = new HashSet<>();
        int[] leftmin = new int[a.length];
        int[] rightmin = new int[a.length];
        
        leftmin[0] = a[0];
        rightmin[a.length-1] = a[a.length-1];
        set.add(a[0]);
        set.add(a[a.length-1]);
        
        for(int i = 1 ; i <a.length ; ++i ){
            if(a[i]<=leftmin[i-1]){
                set.add(a[i]);
            }
            leftmin[i] = Math.min(a[i],leftmin[i-1]);
        }
        for(int i = a.length-2 ; i >=0 ; --i ){
            if(a[i]<=rightmin[i+1]){
                set.add(a[i]);
            }
            rightmin[i] = Math.min(a[i],rightmin[i+1]);
        }
        
        return set.size();
    }
}