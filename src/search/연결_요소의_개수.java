package search;

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
public class 연결_요소의_개수 {
	public static void main(String[] args) throws IOException {// bfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[nodeCount+1]; // 인접 리스트
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		boolean[] visited = new boolean[nodeCount+1];

		// 그래프 값 세팅
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			// 방향이 없는거라 양방향을 넣어줌
			graph[node1].add(node2);
			graph[node2].add(node1);
		}


		Queue<Integer> queue = new LinkedList<>();

		int doBFS = 0;
		for (int j = 1; j < visited.length; j++) {
			if (visited[j]) {
				continue;
			}
			doBFS++;
			queue.add(j); // 시작노드를 j로 지정
			visited[j] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i : graph[node]) {
					if (!visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
		}
		System.out.println(doBFS);
	}
	public static void main1(String[] args) throws IOException { // dfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[nodeCount+1]; // 인접 리스트
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		boolean[] visited = new boolean[nodeCount+1];

		// 그래프 값 세팅
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			// 방향이 없는거라 양방향을 넣어줌
			graph[node1].add(node2);
			graph[node2].add(node1);
		}


		Stack<Integer> stack = new Stack<>();

		int doDFS = 0;
		for (int j = 1; j < visited.length; j++) {
			if (visited[j]) {
				continue;
			}
			doDFS++;
			stack.add(j); // 시작노드를 j로 지정
			visited[j] = true;
			while (!stack.isEmpty()) {
				int pop = stack.pop();
				for (int i : graph[pop]) {
					if (!visited[i]) {
						visited[i] = true;
						stack.push(i);
					}
				}
			}
		}
		System.out.println(doDFS);
	}
}
