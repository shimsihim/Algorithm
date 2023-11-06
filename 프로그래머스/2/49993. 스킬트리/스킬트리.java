import java.util.*;
class Solution {
    
    static String order; 
    static String[] skills;
    static HashMap<Character,Integer> map;
        
    public int solution(String skill, String[] skill_trees) {
        
        order = skill;
        skills = skill_trees;
        map = new HashMap<>();
        
        //일단 해시맵에 order를 저장 각각의 문자 순서대로 1,2,3,부과
        saveorder();
        
        
        int res = 0;
        
        //각 문자열을 순회하며  해당 스킬트리가 맞으면 res++
        for(int i = 0 ; i <skill_trees.length;++i ){
            if(find(skill_trees[i])){
                res++;
            }
        }
        
        
        return res;
    }
    
    static boolean find(String str){
        
        //선행스킬을 1,2,3의 순서이므로 가장 초반에는 0
        int preindex = 0;
        
        //문자열을 순회하며
        for(int i = 0 ; i < str.length();++i){
            // 만약 map에 저장된 문자열이라면 선행스킬세트에 포함된 것
            if(map.containsKey(str.charAt(i))){
                //이번에 나온 스킬이 선행스킬 뒤에 나온것이 아니라면 false
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