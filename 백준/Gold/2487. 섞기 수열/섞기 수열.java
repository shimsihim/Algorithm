import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {

    static int[] list;

    public static void main(String[] args) throws Exception {

        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[]rec = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rec[i] = getRec(i , list[i], 1);
        }
        long ans = lcm((long)rec[1],(long)rec[1]);
        for(int i = 3 ; i <= n ; ++i){
            ans = lcm(ans,(long)rec[i]);
        }
        System.out.println(ans);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static int getRec(int start , int num , int depth){
        if(start == num) return depth;
        return getRec(start , list[num] , depth+1);
    }

}