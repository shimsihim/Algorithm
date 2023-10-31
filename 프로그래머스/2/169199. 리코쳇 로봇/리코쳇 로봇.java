import java.util.*;

class Solution {
	static ArrayList<Integer> rowList[];
	static ArrayList<Integer> colList[];
	static boolean[][][] visit;
	static int endrow;
	static int endcol;
	static int startrow;
	static int startcol;

	
	
	public int solution(String[] board) {

		char[][] map = new char[board.length][board[0].length()];

		int rowsize = board.length;
		int colsize = board[0].length();

		for (int i = 0; i < rowsize; ++i) {
			map[i] = board[i].toCharArray();
		}

		visit = new boolean[board.length][board[0].length()][4];
		rowList = new ArrayList[rowsize];
		colList = new ArrayList[colsize];

		for (int i = 0; i < rowsize; ++i) {
			rowList[i] = new ArrayList<>();
		}
		for (int i = 0; i < colsize; ++i) {
			colList[i] = new ArrayList<>();
		}
        
		startrow = 0;
		startcol = 0;
		endrow = 0;
		endcol = 0;
		for (int i = 0; i < rowsize; ++i) {
			for (int j = 0; j < colsize; ++j) {
				if (map[i][j] == 'D') {
					rowList[i].add(j);
					colList[j].add(i);
				} else if (map[i][j] == 'R') {
					startrow = i;
					startcol = j;
				} else if (map[i][j] == 'G') {
					endrow = i;
					endcol = j;
				}
			}
		}
		Queue<node> q = new LinkedList<>();
		q.add(new node(startrow, startcol, 0, 1));
		q.add(new node(startrow, startcol, 1, 1));
		q.add(new node(startrow, startcol, 2, 1));
		q.add(new node(startrow, startcol, 3, 1));

		int r = 0;
		int c = 0;
		int direction = 0;
		int depth = 0;

		while (!q.isEmpty()) {
			node temp = q.poll();
			r = temp.row;
			c = temp.col;
			direction = temp.direction;
			depth = temp.depth;
			visit[r][c][direction] = true;
			// 방향에 맞게 갈 수 있는 곳 보내기
			if (direction == 0) {
				r = up(r, c);
			} else if (direction == 1) {
				c = left(r, c);
			} else if (direction == 2) {
				r = down(r, c);
			} else if (direction == 3) {
				c = right(r, c);
			}
			// 목적지면 min 최신화
			if(r==temp.row && c == temp.col) continue;
			if (r == endrow && c == endcol) {
				return depth;
			}
			for (int i = 0; i < 4; ++i) {
				if (!visit[r][c][i]) {
					q.add(new node(r, c, i, depth + 1));
					visit[r][c][i] = true;
				}
			}
		}
		return -1;
	}

	static int min = Integer.MAX_VALUE;

	static class node {
		int row;
		int col;
		int direction;
		int depth;

		node(int row, int col, int direction, int depth) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.depth = depth;
		}
	}

	static int up(int r, int c) {
		for (int i = colList[c].size() - 1; i >= 0; --i) {
			if (colList[c].get(i) < r) {
				return colList[c].get(i) + 1;
			}
		}
		return 0;
	}

	static int left(int r, int c) {

		for (int i = rowList[r].size() - 1; i >= 0; --i) {
			if (rowList[r].get(i) < c) {
				return rowList[r].get(i) + 1;
			}
		}
		return 0;
	}

	static int down(int r, int c) {
		for (int i = 0; i < colList[c].size(); ++i) {
			if (colList[c].get(i) > r) {
				return colList[c].get(i)-1;
			}
		}
		return rowList.length - 1;
	}

	static int right(int r, int c) {

		for (int i = 0; i < rowList[r].size(); ++i) {
			if (rowList[r].get(i) > c) {
				return rowList[r].get(i)-1;
			}
		}

		return colList.length - 1;
	}

}