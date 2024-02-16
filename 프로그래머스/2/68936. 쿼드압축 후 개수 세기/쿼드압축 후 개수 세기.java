class Solution {
    public int[] solution(int[][] arr) {
        
        // 구간별로 메서드로 보내기,//해당 공간이 모두 같은 것으로 채워졌을 때 반환,  반환 값은 해당 구간 내에 0과 1의 개수 반환하기
        int n = arr.length;
        
        
        int[] answer = check(0,0,n-1,n-1 , arr);
        
     
        
        
        
        return answer;
    }
    
    static int[] check(int startR,int startC, int endR, int endC,int[][] arr){
        
        //일단 checkCnt로 보내서 개수 확인
        
        int temp[] = checkCnt(startR,startC,endR,endC,arr);
        // 둘다 0ㅣ 아니면 쪼개서 check호출
        
        int answer[] = new int[2];
        if(temp[0]!=0 && temp[1]!=0){ // 둘 다 0이 아닌경우 즉, 섞여있는 경우
            int size = (endR-startR+1)/2 -1;
            temp = check(startR,startC,startR+size,startC+size,arr);
            answer[0] += temp[0];
            answer[1] += temp[1];
            temp = check(endR-size,endC-size,endR,endC,arr);
            answer[0] += temp[0];
            answer[1] += temp[1];
            temp = check(startR,endC-size,startR+size,endC,arr);
            answer[0] += temp[0];
            answer[1] += temp[1];
            temp = check(endR-size,startC,endR,startC+size,arr);
            answer[0] += temp[0];
            answer[1] += temp[1];
            
            return answer;
        }
        
        //둘 중 1개가 0이면 return 해주기
        
        else{
            if(temp[0] == 0){
                return new int[] {0,1};
            }
            else{
                return new int[] {1,0};
            }
        }
        
        
        
    }
    
    
    static int[] checkCnt(int startR,int startC, int endR, int endC,int[][] arr){
        
        int ret[] = new int[2];
        
        for(int i = startR ; i <= endR ; ++i ){
            for(int j = startC ; j <= endC ; ++j){
                if(arr[i][j]==0){
                    ret[0]++;
                }else{
                    ret[1]++;
                }
            }
        }
        
        return ret;
        
    }
}