package data_structure;

import java.util.PriorityQueue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 6.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 6.        ggong       최초 생성
 */

/*
 * 절댓값 힙은  다음과 같은 연산을 지원하는 자료구조다.
 *  1. 배열에 정수 x( x !=0 ) 을 넣는다.
 *  2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
 *     절댓값이 가장 작은 값이 여러 개일 경우에는 그중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 *  프로그램은 처음에 비어있는 배열에서 시작한다. 절댓값 힙을 구현하시오.
 * - 입력: 1번째 줄에 연산의 개수 n(1 <= n <= 100,000)이 주어진다. 다음 n개의 줄에는 연산과 관련된 정보를 나타내는 정수  x가 주어진다.
 *        만약 x가 0이 아니라면 배열에 x라는 값을 추가하고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *        입력되는 정수는 -231보다 크고, 231보다 작다.
 * - 출력: 입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어있는데 절댓값이 가장 작은 값을 출력하라고 할 떄는 0을 출력하면 된다.
 *
 * [우선순위 큐를 새롭게 정의해서 사용하면 되는 문제]
 */
public class 절댓값_힙_구현하기 {
	public static void main(String[] args) {
		System.out.println(solution_answer(18,new int[]{1,-1,0,0,0,1,1,-1,-1,2,-2,0,0,0,0,0,0,0}));
	}

	public static String solution_answer(int size, int[] array) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			// 1. 절댓값이 작은 값이 우선
			int o1Abs = Math.abs(o1);
			int o2Abs = Math.abs(o2);

			// 2. 절대값이 같은 경우 음수 우선
			if (o1Abs == o2Abs) {
				return o1 > o2 ? 1 : -1;
			}

			/*
			 * - o1Abs - o2Abs : 1가 더 크면 양수를 리턴 2가 더 크면 음수를 리턴 == o1Abs > o2Abs ? 1 :  -1
			 * - o2Abs - o1Abs : 2가 더 크면 양수를 리턴,1이 더 크면 음수를 리턴 == o2Abs > o1Abs ? 1 :  -1
			 */
			return o1Abs - o2Abs; // 리턴값이 양수냐 음수냐에 따라 정렬의 기준을 세움
		});
		StringBuilder answer = new StringBuilder();

		for (int i : array) {
			if (i == 0) {
				answer.append(queue.isEmpty() ? "0" : queue.poll()).append("\n");
			} else {
				queue.offer(i);
			}
		}
		return answer.toString();


	}
}
