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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [조건]
 * - 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 위치
 * - 수빈이는 걷거나 순간이동을 할 수 있다
 * - 걷기 :  X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
 * - 순간이동 :  X일 때 순간이동한다면 1초 후에 2*X의 위치
 * <p>
 * [입력]
 * - 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.( N과 K는 정수)
 * <p>
 * [출력]
 * - 수빈이가 동생을 찾는 가장 빠른 시간을 출력
 */
public class Q_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());

		int size = N < K ? K + 1 : N + 1;
		int[]     arr     = new int[size + 1];
		boolean[] visited = new boolean[size + 1];


		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		while(!queue.isEmpty() ) {
			int index = queue.poll();
			if(index == K) {
				break;
			}
			if(visited[index]) {
				continue;
			}
			visited[index] = true;

			int walkBack  = index - 1;
			int walkFront = index + 1;
			int jump      = index * 2;

			if(walkBack >= 0 && walkBack <=size && !visited[walkBack] && arr[walkBack] ==0) {
				arr[walkBack] = arr[index] + 1;
				queue.offer(walkBack);
			}
			if(walkFront >= 0 && walkFront <= size && !visited[walkFront] && arr[walkFront] ==0) {
				arr[walkFront] = arr[index] + 1;
				queue.offer(walkFront);
			}
			if(jump > 0 && jump <=size && !visited[jump] && arr[jump] ==0) {
				arr[jump] = arr[index] + 1;
				queue.offer(jump);
			}
		}
		System.out.println(arr[K]);
	}
}
