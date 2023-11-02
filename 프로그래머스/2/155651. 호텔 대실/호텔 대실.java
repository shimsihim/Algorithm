import java.util.*;
class Solution {
     class node {
        int start;
        int end;
        node(int start, int end){
        	
        	this.start = start;
            this.end = end;
        	
        }
    }
    
    public int solution(String[][] book_time) {

        node[] nodes = Arrays.stream(book_time)
            .map(str -> {
                String[] parts = str[0].split(":");
                int startHour = Integer.parseInt(parts[0]);
                int startMin = Integer.parseInt(parts[1]);

                parts = str[1].split(":");
                int endHour = Integer.parseInt(parts[0]);
                int endMin = Integer.parseInt(parts[1]);
                if(endMin>=50){
                    endHour ++;
                    endMin = (endMin+10)%60;
                }
                else{
                    endMin +=10;
                }
                return new node(startHour*100+startMin, endHour*100+endMin);
            })
            .toArray(node[]::new);
        
        Arrays.sort(nodes,new Comparator<node>(){
            
            @Override
            public int compare(node o1 , node o2){
                if(o1.start!=o2.start){
                    return o1.start-o2.start;
                }
                else{//시작 시간 같을 때
               
                    return o2.end-o1.end;
                }
            }
            
            
        });
        int res = 1;
        
        for(int i = 1 ; i < book_time.length;++i){
            int cnt = 1;
            for(int j=0;j<i ; ++j ){
                if(nodes[j].end>nodes[i].start){
                    cnt++;
                }
            }
            if(cnt > res){
                res = cnt;
            }
        }
        
        return res;
    }
}