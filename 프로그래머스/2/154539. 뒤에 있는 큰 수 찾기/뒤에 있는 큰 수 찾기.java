import java.util.*;
class Solution {
    
    class node{
        int index;
        int num;
        node(int index,int num){
            this.index = index;
            this.num = num;
        }
    }
    public int[] solution(int[] numbers) {
        if(numbers.length==1){
            return new int[]{-1};
        }
        int[] res = new int[numbers.length];
        Stack<node> list = new Stack<>();
        list.add(new node(0,numbers[0]));
        al : for(int i=1; i <numbers.length;++i){
            while(!list.isEmpty()){
                node temp = list.peek();
                if(temp.num<numbers[i]){
                    list.pop();
                    res[temp.index] = numbers[i];
                }
                else{
                    list.add(new node(i,numbers[i]));
                    continue al;
                }
            }
            list.add(new node(i,numbers[i]));
        }
        
        while(!list.isEmpty()){
            node temp = list.pop();
            res[temp.index] = -1;
        }
        return res;
    }
}