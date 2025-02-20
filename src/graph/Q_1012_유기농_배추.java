package graph;

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

import java.io.*;
import java.util.*;

/**
 * [조건]
 * - 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 * - 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
 * <p>
 * [입력]
 * - 첫 줄에는 테스트 케이스의 개수 T
 * - 각 테스트 케이스에 대해, 첫째줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
 * -  K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.
 * <p>
 * [출력]
 * - 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
 */
public class Q_1012_유기농_배추 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] moveX = new int[]{0, 0, -1, 1};
	static int[] moveY = new int[]{1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			int answer = field();
			sb.append(answer).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb.replace(sb.length() - 1, sb.length(), "");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int field() throws IOException {
		st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] field = new int[height][width];
		boolean[][] visited = new boolean[height][width];

		// 데이터 입력
		for(int j = 0; j < K; j++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			field[y][x] = 1;
		}


		// 연결 리스트 만들기
		HashMap<Node, HashSet<Node>> nodes = new HashMap<>();
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				Node now = new Node(w, h);
				for(int k = 0; k < moveY.length; k++) {
					if(field[h][w] == 0) {
						continue;
					}
					int x = w + moveX[k];
					int y = h + moveY[k];
					if(x >= 0 && y >= 0 && x < width && y < height && field[y][x] == 1 ) {
//						System.out.println(w+","+h +" -> "+x+","+y);
						Node node = new Node(x, y);
						nodes.compute(now, (key, value) -> {
							if(value == null) {
								value = new HashSet<>();
							}
							value.add(node);
							return value;
						});
						nodes.compute(node, (key, value) -> {
							if(value == null) {
								value = new HashSet<>();
							}
							value.add(now);
							return value;
						});
					}
				}
			}
		}

		// 배추 뭉치 세기
		int answer = 0;
		Stack<Node> stack = new Stack<>();
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				if(field[h][w] == 0 || visited[h][w]) {
					continue;
				}
				Node start = new Node(w, h);
				visited[h][w] = true;
				stack.push(start);
				answer++;

				while(!stack.isEmpty()) {
					Node now = stack.pop();
					if(nodes.get(now) == null) {
						break;
					}
					for(Node node : nodes.get(now)) {
						if(!visited[node.y][node.x]) {
							stack.push(node);
							visited[node.y][node.x] = true;
						}
					}
				}
			}
		}

		return answer;
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
