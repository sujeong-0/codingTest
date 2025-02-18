package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * description    :
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 9.        ggong       최초 생성
 */
public class 단지번호붙이기 {
	public static void main(String[] args) throws IOException {
		final int[] moveX = new int[]{0, 0, -1, 1};
		final int[] moveY = new int[]{-1, 1, 0, 0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()) + 1;

		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Integer> answer = new PriorityQueue<>();
		Map<Node, ArrayList<Node>> data = new HashMap<>();

		for (int i = 1; i < N; i++) {
			String st = br.readLine();
			for (int j = 1; j < N; j++) {
				if (st.charAt(j - 1) == '1') {
					map[i][j] = 1;
				}
			}
		}


		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				Node keyNode = new Node(i, j);
				if (data.get(keyNode) != null) {
					System.out.println(keyNode.x +", "+ keyNode.y);
				}
				data.put(keyNode, new ArrayList<>());

				for (int move = 0; move < moveX.length; move++) {
					int x = i + moveX[move];
					int y = j + moveY[move];

					if (x > 0 && x < N && y > 0 && y < N && map[x][y] == 1 ) {

						Node valueNode = new Node(x, y);
						data.compute(keyNode, (k, v) -> {
							v.add(valueNode);
							return v;
						});
					}
				}
			}
		}


		Stack<Node> stack = new Stack<>();
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}

				stack.push(new Node(i, j));
				int count = 0;
				while (!stack.isEmpty()) {
					Node pop = stack.pop();
					if (data.get(pop) == null) {
						continue;
					}
					for (Node node : data.get(pop)) {
						if (visited[node.x][node.y]) {
							continue;
						}
						count++;
						visited[node.x][node.y] = true;
						stack.push(node);
					}
					count = count ==0? 1: count;
				}
				if (count > 0) {
					answer.offer(count);
				}
			}
		}
		int size = answer.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(answer.poll());
		}
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
			if (this == o) {
				return true;
			}
			if (!(o instanceof Node)) {  // JDK 15 호환 코드
				return false;
			}
			Node node = (Node) o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
