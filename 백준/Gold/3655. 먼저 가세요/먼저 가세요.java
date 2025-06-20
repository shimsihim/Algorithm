import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            ArrayList<node>list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                list.add(new node(c , j));
            }
            list.sort(new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    if(o1.ch == o2.ch) return o1.originIdx-o2.originIdx;
                    return o1.ch - o2.ch;
                }
            });

            int time = 0;
            char preChar = '.';
            int lastIdx = n-1;
            for (int i = n-1; i >=0; i--) {
                node temp = list.get(i);
                node last = list.get(lastIdx);
                if(preChar != temp.ch){
                    preChar = temp.ch;
                    lastIdx = i;
                }
                else{
//                    원래 1인덱스 기다려야 함
                    time += (Math.abs(last.originIdx-temp.originIdx) - (lastIdx-i))*5;
                }
            }
            System.out.println(time);

        }
    }

    static class node{
        char ch;
        int originIdx;
        node(char ch, int originIdx){
            this.ch = ch;
            this.originIdx = originIdx;
        }
    }

}