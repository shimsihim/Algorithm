import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {

        //2 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        System.out.println(get(n,x));

    }
    private static long get(int n , long x){ // n번째 햄버거에서 x번째까지 섭취
        if(x == 0) return 0;

        if(n == 0) return 1;

        long prevLen = getTotalLen(n-1);
        long prevPatty = getPattyLen(n-1);

        //x의 구간별 분리
        if(x == 1) return 0;
        else if(x <= 1 + prevLen){
            return  get(n-1 , x-1);
        }
        else if(x == 2 + prevLen){
            return 1 + prevPatty;
        }
        else if(2 + prevLen < x && x <= 2 + 2 * prevLen){
            return 1 + prevPatty + get(n-1 , x-2-prevLen);
        }
        else{
            return 1 + 2 * prevPatty;
        }
    }

    private static long getTotalLen(int n){
        if(n < 0) return 0;
        return (long)(Math.pow(2,n-1) * 8) - 3;
    }

    private static long getPattyLen(int n){
        if(n < 0) return 0;
        return (long)(Math.pow(2,n-1) * 4) - 1;
    }
}