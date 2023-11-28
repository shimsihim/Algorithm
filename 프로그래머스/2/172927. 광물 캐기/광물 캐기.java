
class Solution {
    
    public static int inven;//장비 개수
    public static int min;
    public static int listsize;// 광물 5개씩 묶어놓은 개수
    public static int[] pick;
    public static int[][] list;

    
    public static int solution(int[] picks, String[] minerals) {
        
        min =  Integer.MAX_VALUE;
        pick = picks;
        listsize = 0;
        inven = 0;
        
        for(int i = 0 ; i < 3 ; ++i){
            inven += picks[i];
        }
        
        int minesize = minerals.length;
        
        if(minesize%5 !=0){
            list = new int[minesize/5+1][3];
            listsize = minesize/5+1;
        }else{
            list = new int[minesize/5][3];
            listsize = minesize/5;
        }
        int index = -1;
        for(int i = 0 ; i <minesize ; ++i ){
            if(i%5==0){
                index++;
            }
            add(index,minerals[i]);
        }
        
        
        find(0,0);
        
        
        return min;
    }
    
    public static void find(int depth, int loss){
        if(loss>min) return;
        if(depth == listsize || depth == inven){
            min = Math.min(min,loss);
            return;
        }
        
        for(int i = 0 ; i < 3 ; ++i){
            if(pick[i]<=0) continue;
            pick[i]--;
            find(depth+1,loss+list[depth][i]);
            pick[i]++;
        }
        
    }
    
    public static void add(int index , String mine){
        
        if(mine.equals("diamond")){
            list[index][0] += 1;
            list[index][1] += 5;
            list[index][2] += 25;
        }else if(mine.equals("iron")){
            list[index][0] += 1;
            list[index][1] += 1;
            list[index][2] += 5;
        }
        else{
            list[index][0] += 1;
            list[index][1] += 1;
            list[index][2] += 1;
        }
        
    }
    
}