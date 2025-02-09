package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

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
public class 경로_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()) + 1;

		boolean[][] answer = new boolean[N][N];
		ArrayList<Integer>[] graph = new ArrayList[N];
		for (int i = 1; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				if (st.nextToken().equals("1")) {
					graph[i].add(j);
				}
			}
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < N; i++) {
			stack.push(i); // 시작노드 지정
			while (!stack.isEmpty()) {
				int pop = stack.pop();
				for (int j : graph[pop]) {
					if (answer[i][j]) {
						continue;
					}
					answer[i][j] = true;
					stack.push(j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				sb.append(answer[i][j] ? "1 ":"0 ");
			}
			sb.replace(sb.length() - 1, sb.length(), "\n");
		}

		System.out.print(sb);
	}
}
