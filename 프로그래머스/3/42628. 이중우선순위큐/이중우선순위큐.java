import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
         PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for(int i = 0 ; i < operations.length; ++i){
            if((operations[i].split(" "))[0].equals("I")){
                // "I" 연산: 값을 큐에 추가하고, 두 우선순위 큐에도 추가
                int temp = Integer.parseInt((operations[i].split(" "))[1]);
                minheap.add(temp);
                maxheap.add(temp);
            
            }
            else {
                if((operations[i].split(" "))[1].equals("1")) {
                    // "D" 연산에서 양수 또는 음수를 비교하여 최댓값 또는 최솟값 삭제
                    if (!maxheap.isEmpty()) {
                        int max = maxheap.poll();
                        minheap.remove(max);
                    }
                }
                else {
                    if (!minheap.isEmpty()) {
                        int min = minheap.poll();
                        maxheap.remove(min);
                    }
                }
            }
        }
        int [] res = new int[2];
        if (minheap.size() != 0) {
            res[1] = minheap.poll();
            res[0] = maxheap.poll();
        }
        return res;
    
    }
}