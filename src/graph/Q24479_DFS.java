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
 * - N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)
 * - 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1
 * - 인접 정점은 오름차순으로 방문한다.
 * <p>
 * [문제]
 * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우의 노드의 방문 순서를 출력
 * <p>
 * [입력]
 * - 1번줄:  정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
 * - 이후 M개 줄에 간선 정보 u v,  u와 정점 v의 가중치 1인 양방향 간선 (1 ≤ u < v ≤ N, u ≠ v),  모든 간선의 (u, v) 쌍의 값은 서로 다르다
 * <p>
 * [출력]
 * - 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력
 * - i번째 줄에는 정점 i의 방문 순서를 출력
 * - 시작 정점의 방문 순서는 1, 방문 못하면 0
 * <p>
 * [예상되는 문제 구간]
 * - 오름차순으로 방문해야하는 것
 * - 여러번 DFS를 실행해야 하는것?
 */
public class Q24479_DFS {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());

		int[]       visited = new int[nodeCount + 1];
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

		// DFS
		Stack<Integer> stack = new Stack<>();
		stack.add(startNode);// start node 지정
		int count = 1;
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(visited[now] != 0) {
				continue;
			}
			visited[now] = count++;

			ArrayList<Integer> next = data[now];
			Collections.sort(next);
			Collections.reverse(next);

			for(int i = 0; i < next.size(); i++) {
				int n = next.get(i);
				if(visited[n] == 0) {
					stack.add(n);
				}
			}

		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i <= nodeCount; i++) {
			bw.write(String.valueOf(visited[i]) );
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
