import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class node {
        int row, col;

        node() {

        }

        node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)// 현재의 객체와 비교대상 객체가 같은지
                return true;
            if (o == null || getClass() != o.getClass()) // 비교대상 객체가 null인지
                return false;                           //현재의 클래스와 비교대상 객체의 클래스가 같은지
            node temp = (node) o;
            return row == temp.row && col == temp.col;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int mod = n/5;
        int res = -1;

        while(mod>-1){
            if((n-mod*5)%3==0){
                res = mod + (n-mod*5)/3;
                break;
            }
            mod--;
        }
        System.out.println(res);

    }
}