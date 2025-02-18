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

public class Q24444_BFS {
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
		Queue<Integer> queue = new LinkedList<>();
		int count = 1;
		queue.add(startNode);// start node 지정
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(visited[now] !=0) {
				continue;
			}
			visited[now] = count++;
			ArrayList<Integer> next = data[now];
			Collections.sort(next);
			Collections.reverse(next);

			for(int i = 0; i < next.size(); i++) {
				int n = next.get(i);
				if(visited[n] == 0) {
					queue.add(n);
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
