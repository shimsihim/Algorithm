import java.util.*;

class Solution {
    static char EMPTY_SPACE = ' ';
    
    public int solution(String[] storage, String[] requests) {
        
        int n = storage.length;
        int m = storage[0].length();
        char[][] store = new char[n][m];
        boolean[][] map = new boolean[n][m];

        // 저장소 초기화
        for (int i = 0; i < n; i++) {
            store[i] = storage[i].toCharArray();
        }

        // 외곽선 true
        for (int i = 0; i < n; i++) {
            map[i][0] = true;
            map[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            map[0][j] = true;
            map[n - 1][j] = true;
        }
        
        List<int[]> rmList = new ArrayList<>();

        //각 요청 별 반복
        for (String req : requests) {
            boolean isLenOne = req.length() == 1;
            char target = req.charAt(0);
            rmList.clear();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (store[i][j] == target) { // 문자가 동일하며
                        // 외곽선이거나(요청문자가 1인경우 외곽선만 제거) , 요청문자길이가 2인경우
                        if (!isLenOne || map[i][j]) { 
                            rmList.add(new int[]{i, j}); // 제거될 리스트에 추가
                        }
                    }
                }
            }

            for (int[] pos : rmList) { // 모든 제거 리스트에 대해서 외곽선이라면 외곽선 map을 spread해주기
                store[pos[0]][pos[1]] = EMPTY_SPACE;
                if (map[pos[0]][pos[1]]) {
                    spread(map, store, pos[0], pos[1]);
                }
            }
        }

        // 남은 컨테이너 세기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (store[i][j] != EMPTY_SPACE) answer++;
            }
        }
        return answer;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    //현 외각에 있는 문자 제거시 주변으로 외각TRUE여부 전파
    void spread(boolean[][] map, char[][] store, int r, int c) {
        int n = map.length;
        int m = map[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !map[nr][nc]) {
                    map[nr][nc] = true;
                    if (store[nr][nc] == ' ') {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
