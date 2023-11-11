import java.util.*;
class Solution {
    
    static String[] wants;
    static int[] numbers;
    
    static HashMap<String,Integer> dis;
    
    static HashMap<String,Integer> need;
    static Set<String> list;
    
    static String[] disclist;
    
    static int res = 0;
    
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        dis = new HashMap<>();
        need = new HashMap<>();
        list = new HashSet<>();
        disclist = discount;
        
        // 일단 처음 10일간 discount 를 dis에 채워넣기
        
        //
        // 필요한 품목 및 개수 저장
        for(int i = 0 ; i <want.length ; ++i){
            
                need.put(want[i],number[i]);
            
        }
        list = need.keySet();
        
        
        
        //오늘부터 10일간 할인 품목 및 개수 삽입
        for(int i = 0 ; i <10 ; ++i){
            add(i);
        }
        
        int remain = 0;
        for(int i = 0 ; i <discount.length ; ++i ){
            //해당 날짜 되는지 체크
            if(check()){
                res++;
            }
            //다음으로 오늘 할인 삭제하고 다음 날짜 삽입
            
            delete(i);
            
            if(i<discount.length-10){
                add(i+10);
            }
        }
        
        
      
        return res;
        
        
        
    }
    
    static boolean check(){
        
        int needcnt = 0;
        int discnt = 0;
        
        for(String c : list){
            if(dis.containsKey(c)){
                needcnt = need.get(c);
                discnt = dis.get(c);
                if(discnt<needcnt){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    static void delete(int i){
        
       int remain = dis.get(disclist[i]);
            if(remain ==1){
                dis.remove(disclist[i]);
            }
            else{
                dis.put(disclist[i],remain-1);
            }
    }
    
    static void add(int i){
        
        if(dis.containsKey(disclist[i])){
                dis.put(disclist[i],dis.get(disclist[i])+1);
            }
            else{
                dis.put(disclist[i],1);
            }
    }
}