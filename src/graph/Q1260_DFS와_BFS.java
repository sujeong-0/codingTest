package graph;

/**
 * description    :
 * packageName    : graph
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/17/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/17/25        ggong       최초 생성
 */

import java.io.*;
import java.util.*;

/**
 * [조건]
 * - 정점 번호는 1번부터 N번까지
 * - 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
 * - 더 이상 방문할 수 있는 점이 없는 경우 종료
 * - 입력으로 주어지는 간선은 양방향
 * <p>
 * [입력]
 * - 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V
 * - 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호
 * <p>
 * <p>
 * [출력]
 * - 첫째 줄에 DFS를 수행한 결과,  V부터 방문된 점을 순서대로 출력
 * - BFS를 수행한 결과,  V부터 방문된 점을 순서대로 출력
 */
public class Q1260_DFS와_BFS {
	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());

		boolean[]   visitedBFS = new boolean[nodeCount + 1];
		boolean[]   visitedDFS = new boolean[nodeCount + 1];
		ArrayList[] data    = new ArrayList[nodeCount + 1];
		for(int i = 0; i < data.length; i++) {
			data[i] = new ArrayList();
		}

		// 데이터 입력
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			data[node1].add(node2);
			data[node2].add(node1);
		}

		StringBuilder sb = new StringBuilder();
		//DFS
		Stack<Integer> stack = new Stack<>();
		stack.push(startNode);
		while(!stack.isEmpty()) {
			Integer now = stack.pop();
			if(visitedDFS[now]) {
				continue;
			}
			sb.append(now).append(" ");
			visitedDFS[now] = true;
			ArrayList<Integer> datum = data[now];
			Collections.sort(datum);
			Collections.reverse(datum);

			for(int i = 0; i < datum.size(); i++) {
				Integer d = datum.get(i);
				if(!visitedDFS[d]) {
					stack.push(d);
				}
			}
		}

		sb.replace(sb.length() - 1, sb.length(), "\n");


		//BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		while(!queue.isEmpty()) {
			Integer now = queue.poll();
			if(visitedBFS[now]) {
				continue;
			}
			visitedBFS[now] = true;
			sb.append(now).append(" ");
			ArrayList<Integer> datum = data[now];
			Collections.sort(datum);

			for(int i = 0; i < datum.size(); i++) {
				Integer d = datum.get(i);
				if(!visitedBFS[d]) {
					queue.offer(d);
				}
			}
		}
		sb.replace(sb.length() - 1, sb.length(), "\n");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
