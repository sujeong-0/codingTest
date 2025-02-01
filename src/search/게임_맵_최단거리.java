package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description    :
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 1.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 1.        ggong       최초 생성
 */
public class 게임_맵_최단거리 {
	// 상하좌우
	static int[] moveX = new int[]{0, 0, -1, 1};
	static int[] moveY = new int[]{1, -1, 0, 0};

	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
	}

	public static int solution(int[][] maps) {
		visited = new boolean[maps.length][maps[0].length];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;


		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < moveX.length; i++) {
				int x = now[0] + moveX[i];
				int y = now[1] + moveY[i];

				if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length && maps[x][y] == 1) {
					if (visited[x][y]) {
						continue;
					}
					visited[x][y] = true;
					queue.offer(new int[]{x, y});
					maps[x][y]= maps[now[0]][now[1]] +1;
				}
			}
		}
		return maps[maps.length-1][maps[0].length-1];
	}
}
