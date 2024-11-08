package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description    : 백준 11724
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 7.        ggong       최초 생성
 */

/*
 * 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.
 * - 입력: 1번째 줄에 노드의 개수( 1<=n<=1,000)과 에지의 개수 m( 0<= m <= n * (n-1) / 2  )
 *        2번째 줄부터 m개의 줄에 에지의 양끝 점 u와 v가 주어진다. ( 1 <= u , v <= n,  u != v )
 * - 출력: 1번째 줄에 연결 요소의 개수를 출력한다.
 *
 *  * 같은 에지는 한 번만 주어진다.
 *
 *  * 에지 = 노드와 노드를 이어주는 선
 *  * 연결 요소의 개수 = DFS가 실행된 횟수 // 그래프가 모두 연결되어 있었다면, DFS는 1번만 실행 되었을 것!!!
 *  * 에지의 양 끝점만 주어진다 = 방향성이 없다 = u -> v도 가능하고, v -> u도 가능하다. = 양방향으로 움직일수 있다.
 */
public class DFS_연결_요소의_개수_구하기 {

	public static void main(String[] args) {
		System.out.println(solution_recursive(6,5,new String[]{"1 2", "2 5", "5 1", "3 4", "4 6"})); // 2
		System.out.println(solution_recursive(6,8,new String[]{"1 2", "2 5", "5 1", "3 4", "4 6", "5 4",  "2 4", "2 3"})); //1
	}

	public static int solution_recursive(int nodeCount, int edgeCount, String[] nodes) {
		boolean[] visited = new boolean[nodeCount + 1]; // 배열의 인덱스 0을 사용하지 않기 위함
		ArrayList<Integer>[] canGoList = new ArrayList[nodeCount + 1];
		for (int i = 1; i < nodeCount + 1; i++) {
			canGoList[i] = new ArrayList<>();
		}
		for (String node : nodes) {
			int n1 = Integer.parseInt(node.split(" ")[0]);
			int n2 = Integer.parseInt(node.split(" ")[1]);

			// 양방향으로 가능하기 때문에 양방향으로 넣어줌
			canGoList[n1].add(n2);
			canGoList[n2].add(n1);

			System.out.println(node + "  :::::  " + n1 + " : " + n2);
		}

		int elementCount = 0; // 요소의 개수
		for (int i = 1; i <= nodeCount; i++) {
			if (!visited[i]) {
				elementCount++;
				DFS_recursive(i, visited, canGoList);
			}
		}
		return elementCount;

	}

	private static void DFS_recursive(int i, boolean[] visited, ArrayList<Integer>[] canGoList) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int integer : canGoList[i]) {
			if (!visited[integer]) {
				DFS_recursive(integer, visited, canGoList);
			}
		}

	}

	/**
	 * 스택으로 구현해서 활용하는 방식
	 *
	 * @param nodeCount 노드의 수
	 * @param edgeCount 에지의 수
	 * @param nodes     노드들
	 * @return 요소의 개수
	 */
	public static int solution_stack(int nodeCount, int edgeCount, String[] nodes) {
		int elementCount = 0; // 요소의 개수
		List<List<Integer>> canGoList = new ArrayList<>(nodeCount);//인접리스트
		boolean[] visited = new boolean[nodeCount];// 방문 기록 저장 배열

		// 세팅
		for (boolean b : visited) {
			b = false;
		}
		for (int i = 0; i < nodeCount; i++) {
			canGoList.add(new ArrayList<>());
		}

		for (String node : nodes) {
			int n1 = Integer.parseInt(node.split(" ")[0])-1;
			int n2 = Integer.parseInt(node.split(" ")[1])-1;

			// 양방향으로 가능하기 때문에 양방향으로 넣어줌
			canGoList.get(n1).add(n2);
			canGoList.get(n2).add(n1);

			System.out.println(node + "  :::::  " + n1 + " : " + n2);
		}


		for (int i = 0; i < nodeCount; i++) {
			boolean completedVisited = true; // 모든 방문을 마쳤는가
			for (boolean b : visited) {
				if (!b) {
					completedVisited = false;
					break;
				}
			}

			if (completedVisited) {
				break;
			}
			DFS_stack(visited, canGoList);
			elementCount++;
		}


		return elementCount;
	}

	public static void DFS_stack(boolean[] visited, List<List<Integer>> canGo) {

		Stack<Integer> visitNow = new Stack<>(); // 방문 하기로 한 곳

		// 시작점
		int startIndex = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				startIndex = i;
				break;
			}
		}

		visitNow.add(startIndex);
		visited[startIndex] = true; // 방문
		System.out.println("[" + startIndex + "] 방문");

		while (!visitNow.isEmpty()) {
			int pop = visitNow.pop();
			List<Integer> nextCanGo = canGo.get(pop);
			for (int go : nextCanGo) {
				if (!visited[go]) {// 안갔으면!
					visitNow.add(go);
					visited[go] = true; // 방문
					System.out.println("[" + go + "] 방문");
				}
			}
		}

	}

}
