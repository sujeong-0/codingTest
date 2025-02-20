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
 * - 인접 정점은 내림차순으로 방문
 *
 * [입력]
 * - 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
 * - 다음 M개 줄에 간선 정보 u v , (1 ≤ u < v ≤ N, u ≠ v) , 간선의 가중치 1
 *
 * [출력]
 * - 출력 양식: 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력
 * - 출력 내용: i번째 줄에는 정점 i의 방문 순서를 출력, 시작 정점에서 방문할 수 없는 경우 0을 출력
 */
public class Q_24480_DFS2 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());

		int[]   visited = new int[nodeCount + 1];
		PriorityQueue[] data    = new PriorityQueue[nodeCount + 1];
		for(int i = 0; i < data.length; i++) {
			data[i] = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
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

			PriorityQueue<Integer> next = data[now];

			while(!next.isEmpty()) {
				int n = next.poll();
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
