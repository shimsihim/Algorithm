import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
         Arrays.sort(data,new Comparator<int[]>(){
	            @Override
	            public int compare(int[]o1,int[]o2){
	            if(o1[col-1]!=o2[col-1]){
	                return o1[col-1]-o2[col-1];
	            }
	            else{
	                return o2[0]-o1[0];
	            }
	            }
	        });
	        int colsize = data[0].length;
	        
	        int res = 0;
	        int temp = 0;
	        for(int i =row_begin-1 ; i<= row_end-1;++i){
	            temp = 0;
	            for(int j = 0 ; j < colsize ; ++j){
	                temp += (data[i][j])%(i+1);
	            }
	            res ^=temp;
	        }
	        
	        
	        
	        return res;
	        
	        
	    }
}