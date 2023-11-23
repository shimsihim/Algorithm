import java.util.*;

class Solution {
    
    static class node implements Comparator<node>{
        int from;
        int to;
        int wei;
        public node(int from ,int to ,int wei){
            this.from = from;
            this.to = to;
            this.wei = wei;
        }
        public node(){
            
        }
        
        @Override
        public int compare(node o1, node o2){
            return o1.wei-o2.wei;
        }
    }
    
    public static int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        ArrayList<node> list = new ArrayList<>();
        parents = new int[n];
        for(int i = 0 ; i < n ; ++i){
            parents[i] = i;
        }
        
        
        for(int i = 0 ; i < costs.length; ++i){
            list.add(new node(costs[i][0],costs[i][1],costs[i][2]));
        }
        Collections.sort(list,new node());
        
        int cnt = 0;
        int res = 0;
        
        for(node c : list){
            if(union(c.from,c.to)){
                res += c.wei;
                if(++cnt==n-1){
                    break;
                }
            }
            
        }
       
        
        return res;
    }
    
    
    public static boolean union(int a, int b){
        
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB){
            return false;
        }
        parents[parentA] = parentB;
        return true;
        
    }
    
    public static int find(int a){
        
        
        if(a == parents[a]){
            return a;
        }
        parents[a] = find(parents[a]);
        return parents[a];
        
    }
}