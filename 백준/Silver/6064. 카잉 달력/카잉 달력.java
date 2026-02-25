import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < t ; ++tc){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int max = multi(m,n);
            System.out.println(solve(max , m , n , x,y));
        }


    }

    private static int solve(int max , int m , int n , int x , int y){
        int ret = -1;

        int maxmulti = Math.max(m,n);
        int year = maxmulti == m ? x : y;

        while(ret == -1 && year <= max){
            if((year - y >=0) && (year - x >= 0) &&
                    (year - y) % n == 0 && (year -x) % m == 0){
                ret = year;
                break;
            }
            year += maxmulti;
        }
        return ret;
    }



    private static int multi(int a , int b){
        return (a == 0 || b == 0) ? 0 : (a/maxmod(a,b)) * b;
    }
    private static int maxmod(int a , int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;

        }
        return a;
    }
}