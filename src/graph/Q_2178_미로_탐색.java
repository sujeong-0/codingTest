package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : graph
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/20/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/20/25        ggong       최초 생성
 */

/**
 * [조건]
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 서로 인접한 칸으로만 이동할 수 있다.
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * <p>
 * [입력]
 * - 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)
 * - 다음 N개의 줄에는 M개의 정수로 미로(각각의 수들은 붙어서 )
 * <p>
 * [출력]
 * - 지나야 하는 최소의 칸 수를 출력
 */
public class Q_2178_미로_탐색 {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int   M       = Integer.parseInt(st.nextToken());
		final int   N       = Integer.parseInt(st.nextToken());
		final int[] moveX   = new int[]{0, 0, -1, 1};
		final int[] moveY   = new int[]{1, -1, 0, 0};
		int[][]     maze    = new int[M][N];
		boolean[][] visited = new boolean[M][N];


		// 데이터 입력
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				maze[i][j] = line.charAt(j) - 48;
			}
		}


		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));

		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(visited[now.y][now.x]) {
				continue;
			}

			visited[now.y][now.x] = true;
			for(int k = 0; k < moveX.length; k++) {
				int x = now.x + moveX[k];
				int y = now.y + moveY[k];

				if(x >= 0 && x < N && y >= 0 && y < M && maze[y][x] == 1 && !visited[y][x]) {
//					visited[y][x] = true;
					maze[y][x] += maze[now.y][now.x];
					queue.offer(new Node(x, y));
				}
			}
		}

		System.out.println(maze[M - 1][N - 1]);

	}

	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) {return true;}
			if(o == null || getClass() != o.getClass()) {return false;}
			Node node = (Node) o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
