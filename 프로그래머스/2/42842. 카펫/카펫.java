
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int poss = (brown-4)/2;
        int hori = 0;
        int verti = 0;
        if(poss%2==0){
            hori = poss/2;
            verti = poss/2;
        }else{
            hori = poss/2+1;
            verti = poss/2;
        }
        while(verti>=1){
            if(hori*verti == yellow){
                return new int[] {hori+2,verti+2};
            }
            hori++;
            verti--;
        }
        return new int[]{0,0};
    }
}