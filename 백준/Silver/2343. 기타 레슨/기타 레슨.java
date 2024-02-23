import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static int x;
    static int y,n,m;
    static int[][] map;
    static int[] list;
    public static void main(String dirs[]) throws IOException {
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n];

        st = new StringTokenizer(br.readLine());
        long end = 0;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            end += list[i];
        }
        long start = end/n;

        long middle =  0;

        while(start<end){
            middle = start + (end-start)/2;

            if(check(middle)){
                end = middle;
            }
            else{
                start = middle+1;
            }

        }
        System.out.println(start);


    }

    static boolean check(long middle){

        int cnt = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if(list[i] > middle) return false;
            sum += list[i];

            if(sum>middle){
                cnt++;
                sum = list[i];
            }
            else if(sum == middle){
                cnt++;
                sum = 0;
            }
        }
        //cnt가 작다 => true;
        //크면 false
        //같으면 => sum남았으면 false
        //0이면 true
        if(cnt<m) return true;
        if(cnt==m && sum ==0 ) return true;


        return false;
    }

}