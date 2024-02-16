import java.util.*;

class Solution {

    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]>[] fare;
    
      public int solution(int n, int s, int a, int b, int[][] fares) {
          
         fare = new ArrayList[n];
        s -= 1;
        a -= 1;
        b -= 1;

         for (int i = 0; i < n; ++i) {
             fare[i] = new ArrayList<>();
         }

         for (int i = 0; i < fares.length; ++i) {
             fare[fares[i][0]-1].add(new int[]{fares[i][1]-1, fares[i][2]});
             fare[fares[i][1]-1].add(new int[]{fares[i][0]-1, fares[i][2]});
         }
          
          int[][]dist = new int[n][n]; // 각각의 지점을 출발지로 할때 해당 다른 지점까지의 거리
          
          for(int i = 0 ; i < n ; ++i){
              Arrays.fill(dist[i],Integer.MAX_VALUE);
          }
          
          for(int i = 0 ; i < n ; ++i){ // 각 출발지별로 거리
              
              PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
              pq.add(new int[] {i,0});
              dist[i][i] = 0;
              
              while(!pq.isEmpty()){
                  
                  int[] temp = pq.poll(); // temp는 현 지점
                  
                  if(dist[i][temp[0]]< temp[1]) continue;
                  
                  for(int[] c : fare[temp[0]]){ 
                      if (dist[i][c[0]] > temp[1] + c[1]) {
                            dist[i][c[0]] = temp[1] + c[1];
                            // 갱신된 경우에만 큐에 넣는다.
                            pq.offer(new int[] {c[0],dist[i][c[0]]});
                        }
                  }
                  
              }
              
          }
          
          
          for(int i = 0 ; i < n ; ++i){
              int sum = 0;
              sum += dist[s][i];
              sum+= dist[i][a];
              sum+= dist[i][b];
              min = Math.min(min , sum);
          }
          
          
          return min;
          
          
          
      }

    
//     public int solution(int n, int s, int a, int b, int[][] fares) {


//         fare = new ArrayList[n];

//         for (int i = 0; i < n; ++i) {
//             fare[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < fares.length; ++i) {
//             fare[fares[i][0]-1].add(new int[]{fares[i][1]-1, fares[i][2]});
//             fare[fares[i][1]-1].add(new int[]{fares[i][0]-1, fares[i][2]});
//         }


//         // 일단 크게 같이 가는 길에 2사람 도착지가 동시에 있으면 해당 길까지가 요금

//         //1사람 도착지가 존재하면 해당 사람 내리고 나머지 1사람에 대해서 bfs를 돌리기, 근데 여기서 기존 bfs를 가져가서 왔던 길 돌아가지 않기
//         // 두 사람다 도착지 아님 => 각자 bfs하기 마찬가지로 기존 bfs를 가져가서 왔던 길 돌아가지 않기

//         int[] visit = new int[n];
//         Arrays.fill(visit, Integer.MAX_VALUE);

//         Queue<int[]> q = new LinkedList<>(); // 현 지점과 비용
//         s -= 1;
//         a -= 1;
//         b -= 1;

//         q.add(new int[]{s, 0});
//         visit[s] = 0;

//         while (!q.isEmpty()) {
//             int[] now = q.poll(); // 현 지점과 비용
//             if (now[1] >= min) continue;

//             int tempSum = now[1];
//             int temp = findMyWay(now[0], a, visit);
//             if(temp == Integer.MAX_VALUE) continue;
//             tempSum += temp;
//             temp = findMyWay(now[0], b, visit);
//             if(temp == Integer.MAX_VALUE) continue;
//             tempSum += temp;
//             min = Math.min(tempSum, min);


//             for (int[] c : fare[now[0]]) { // 현재 위치에서 갈 수 있는 곳 모두 더하기 // 방문 비용이 더 싸야 갈 수 있음
//                 if (visit[c[0]] > now[1] + c[1]) {
//                     if(c[1] == Integer.MAX_VALUE) continue;
//                     visit[c[0]] = now[1] + c[1];
//                     q.add(new int[]{c[0], now[1] + c[1]});
//                 }
//             }

//         }
//         return min;
//     }

//     static int findMyWay(int now, int des, int[] visit) {

//         int[] visitCopy = new int[visit.length];
//         Arrays.fill(visitCopy,Integer.MAX_VALUE);


//         // 여기서는 현재 위치를 기준으로 목적지까지의 최소값을 반환할 것임

//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{now, 0});
//         visitCopy[now] = 0;

//         int localMin = Integer.MAX_VALUE;

//         while (!q.isEmpty()) {
//             int[] temp = q.poll();
//             if (temp[1] > localMin) continue;

//             if (temp[0] == des) {
//                 localMin = Math.min(localMin, temp[1]);
//             }

//             for (int[] c : fare[temp[0]]) {
//                 if (visitCopy[c[0]] > temp[1] + c[1]) {
//                     visitCopy[c[0]] = temp[1] + c[1];
//                     q.add(new int[]{c[0], temp[1] + c[1]});
//                 }
//             }
//         }

//         return localMin;
//     }


}