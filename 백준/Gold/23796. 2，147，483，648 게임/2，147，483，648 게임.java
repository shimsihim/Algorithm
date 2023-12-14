import java.util.*;
import java.io.*;

class Main {

	static long[][] map;
	static ArrayList<Long>[] row = new ArrayList[8];
	static ArrayList<Long>[] col = new ArrayList[8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		map = new long[8][8];

		row = new ArrayList[8];
		col = new ArrayList[8];

		for (int i = 0; i < 8; ++i) {
			row[i] = new ArrayList<>();
		}
		for (int i = 0; i < 8; ++i) {
			col[i] = new ArrayList<>();
		}

		for (int i = 0; i < 8; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; ++j) {
				long  temp = Long.parseLong(st.nextToken());
				if (temp != 0) {
					row[i].add(temp);
					col[j].add(temp);
				}
			}
		}

		char direction = br.readLine().charAt(0);

		if (direction == 'U') {
			up();
		} else if (direction == 'D') {
			down();
		} else if (direction == 'R') {
			right();
		} else {
			left();
		}

		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void up() {

		for (int c = 0; c < 8; ++c) {
			int idx = 0;
			for (int r = 0; r < col[c].size(); ++r) {
				long now = col[c].get(r);
				long next = -1;
				if (r + 1 < col[c].size())
					next = col[c].get(r + 1);
				if (next == -1) { // 마지막 수라면 그냥 넣기
					map[idx][c] = now;
					idx++;
				} else { // 다음것이 존재한다면
					if (now == next) { // 현재와 다음이 같다면
						map[idx][c] = now * 2;
						r += 1;
						idx++;
					} else {
						map[idx][c] = now;
						idx++;
					}
				}

			}
			// 이제 나머지 row값들에 0 넣기
			while (idx < 8) {
				map[idx++][c] = 0;
			}

		}

	}

	static void down() {
		for (int c = 0; c < 8; ++c) {
			int idx = 7;
			for (int r = col[c].size() - 1; r >= 0; --r) {
				long now = col[c].get(r);
				long next = -1;
				if (r - 1 >= 0)
					next = col[c].get(r - 1);
				if (next == -1) { // 마지막 수라면 그냥 넣기
					map[idx][c] = now;
					idx--;
				} else { // 다음것이 존재한다면
					if (now == next) { // 현재와 다음이 같다면
						map[idx][c] = now * 2;
						r -= 1;
						idx--;
					} else {
						map[idx][c] = now;
						idx--;
					}
				}

			}
			// 이제 나머지 row값들에 0 넣기
			while (idx >= 0) {
				map[idx--][c] = 0;
			}

		}

	}

	static void right() {
		for (int r = 0; r < 8; ++r) {
			int idx = 7;
			for (int c = row[r].size() - 1; c >= 0; --c) {
				long now = row[r].get(c);
				long next = -1;
				if (c - 1 >= 0)
					next = row[r].get(c - 1);
				if (next == -1) { // 마지막 수라면 그냥 넣기
					map[r][idx] = now;
					idx--;
				} else { // 다음것이 존재한다면
					if (now == next) { // 현재와 다음이 같다면
						map[r][idx] = now * 2;
						c -= 1;
						idx--;
					} else {
						map[r][idx] = now;
						idx--;
					}
				}

			}
			// 이제 나머지 row값들에 0 넣기
			while (idx >= 0) {
				map[r][idx--] = 0;
			}

		}
	}

	static void left() {
		for (int r = 0; r < 8; ++r) {
			int idx = 0;
			for (int c = 0; c < row[r].size(); ++c) {
				long now = row[r].get(c);
				long next = -1;
				if (c + 1 < row[r].size())
					next = row[r].get(c + 1);
				if (next == -1) { // 마지막 수라면 그냥 넣기
					map[r][idx] = now;
					idx++;
				} else { // 다음것이 존재한다면
					if (now == next) { // 현재와 다음이 같다면
						map[r][idx] = now * 2;
						c += 1;
						idx++;
					} else {
						map[r][idx] = now;
						idx++;
					}
				}

			}
			// 이제 나머지 row값들에 0 넣기
			while (idx < 8) {
				map[r][idx++] = 0;
			}

		}
	}

}