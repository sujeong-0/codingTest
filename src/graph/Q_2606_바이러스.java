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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [입력]
 * - 1: 첫째 줄에는 컴퓨터의 수, 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다
 * - 2: 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
 * - 3~: 2의 개수 만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍
 * <p>
 * [출력]
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
 */
public class Q_2606_바이러스 {
	public static void main(String[] args) throws IOException {
		final int START_COMPUTER = 1;

		BufferedReader br            = new BufferedReader(new InputStreamReader(System.in));
		int            computerCount = Integer.parseInt(br.readLine());
		int            edgeCount     = Integer.parseInt(br.readLine());

		boolean[]   visited = new boolean[computerCount + 1];
		ArrayList[] data    = new ArrayList[computerCount + 1];
		for(int i = 1; i < data.length; i++) {
			data[i] = new ArrayList();
		}

		// 데이터 입력
		StringTokenizer st;
		for(int i = 1; i <= edgeCount; i++) {
			st = new StringTokenizer(br.readLine());

			int computer1 = Integer.parseInt(st.nextToken());
			int computer2 = Integer.parseInt(st.nextToken());
			data[computer1].add(computer2);
			data[computer2].add(computer1);
		}

		Stack<Integer> stack = new Stack<>();
		stack.add(START_COMPUTER);

		int count = 0;
		while(!stack.isEmpty()) {
			int computer = stack.pop();

			if(visited[computer]) {
				continue;
			}
			visited[computer] = true;
			count++;

			for(int i = 0; i < data[computer].size(); i++) {
				Integer nextComputer = (Integer) data[computer].get(i);
				if(!visited[nextComputer]) {
					stack.push(nextComputer);
				}
			}
		}

		System.out.println(count-1);


	}
}
