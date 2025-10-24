class Solution {
    public int[] solution(int[][] arr){
        this.map = arr;
        return getArr(0,0,arr.length);
    }

    static int[][] map;

    int[] getArr(int startR , int startC ,int length){

        if(length == 1) return toArr(map[startR][startC]);

        int nowVal = map[startR][startC];
        boolean isSuccessFlag = true;
        all : for (int i = startR; i < startR + length ; i++) {
            for (int j = startC; j < startC + length; j++) {
                if (nowVal != map[i][j]) {
                    isSuccessFlag = false;
                    break all;
                }
            }
        }
        if(isSuccessFlag){
            return toArr(nowVal);
        }


        int[] ans1 = getArr(startR , startC , length/2);
        int[] ans2 = getArr(startR + length/2 , startC , length/2);
        int[] ans3 = getArr(startR , startC + length/2 , length/2);
        int[] ans4 = getArr(startR + length/2 , startC + length/2 , length/2);

        ans1[0] += ans2[0] + ans3[0] + ans4[0];
        ans1[1] += ans2[1] + ans3[1] + ans4[1];
        return ans1;
    }

    int[] toArr(int val){
        if(val == 0){
            return new int[] {1,0};
        }
        return new int[] {0,1};
    }
}