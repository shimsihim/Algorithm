import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i = 0 ; i < numbers.length;++i){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr,new Comparator<String>(){
            
           @Override
            public int compare(String o1, String o2){
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a);
            }
        });
        
        for(int i = 0 ; i < arr.length;++i){
            sb.append(arr[i]);
        }
        String str = sb.toString();
        if(str.charAt(0)=='0'){
            return "0";
        }
        return str;
        
        
    }
}