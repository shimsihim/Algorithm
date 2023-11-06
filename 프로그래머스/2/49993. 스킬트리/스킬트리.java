import java.util.*;
class Solution {
    
    static String order; 
    static String[] skills;
    static HashMap<Character,Integer> map;
        
    public int solution(String skill, String[] skill_trees) {
        
        order = skill;
        skills = skill_trees;
        map = new HashMap<>();
        
        //일단 해시맵에 order를 저장
        saveorder();
        
        int res = 0;
        //각 문자열을 순회하며 
        for(int i = 0 ; i <skill_trees.length;++i ){
            if(find(skill_trees[i])){
                res++;
            }
        }
        
        
        return res;
    }
    
    static boolean find(String str){
        
        int preindex = 0;
        
        for(int i = 0 ; i < str.length();++i){
            if(map.containsKey(str.charAt(i))){
                if(map.get(str.charAt(i))!=preindex+1){
                    return false;
                }
                preindex++;
            }
        }
        return true;
        
        
    }
    
    static void saveorder(){
        
        int index = 1;
        
        for(int i = 0 ; i < order.length();++i){
            map.put(order.charAt(i),index++);
        }
    }
}