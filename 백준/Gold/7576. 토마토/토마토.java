import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class node {
		int row, col, day;

		public node(int row, int col, int day) {
			super();
			this.row = row;
			this.col = col;
			this.day = day;

		}
	}

	public static void main(String[] args) throws IOException {
		int tomatocnt = 0;
		int vacant = 0;

		Queue<node> qu = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; ++i) { // 토마토 배열
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					tomatocnt++;
					qu.add(new node(i, j, 0));
				} else if (temp == -1)
					vacant++;

				arr[i][j] = temp;
			}
		} // 배열 생성 완료

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		if (tomatocnt == n * m - vacant)
			System.out.println(0);
		else {

			while (!qu.isEmpty()) { // 큐가 빌때까지 반복
				node temp = qu.poll();
				for (int k = 0; k < 4; ++k) {//4방 탐색
					if (temp.row + dr[k] >= 0 && temp.row + dr[k] < n && temp.col + dc[k] >= 0 && temp.col + dc[k] < m
							&& arr[temp.row + dr[k]][temp.col + dc[k]] == 0) {
						arr[temp.row + dr[k]][temp.col + dc[k]] = 1;
						tomatocnt++;
						if (tomatocnt == n * m - vacant) {
							System.out.println(temp.day + 1);
							break;
						}
						qu.add(new node(temp.row + dr[k], temp.col + dc[k], temp.day + 1));
					}
				}
			}
		}

		if (tomatocnt != n * m - vacant) {
			System.out.println(-1);
		}

		// 반복문을 통해서 0찾기 일단 큐를 만들어서 bfs돌리고

	}
}