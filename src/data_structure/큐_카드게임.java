package data_structure;

import java.util.LinkedList;
import java.util.Queue;

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
 * n장의 카드가 있고,각 카드에는 1번에서 n번까지 번호가 붙어서 1번 카드가 가장 위, n번 카드가 가장 아래인 상태로 놓여있다.
 * 아래의 동작을 카드가 1장 남을 때까지 반복하고, 가장 마지막에 남는 카드를  구하는 프로그램을 작성하시오.
 * 1. 가장 위의 카드를 바닥에 버린다.
 * 2. 그 다음 카드를 밑으로 옮긴다.
 * - 입력: 1번째 줄에 정수 n(1<=n<=500,000)이 주어진다.
 * - 출력: 1번째 줄에 남는 카드의 번호를 출력한다.
 */
public class 큐_카드게임 {
	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(6));
	}

	/**
	 *
	 * @param cardCount 주어진 카드 장수
	 * @return 마지막에 남은 카드 번호
	 */
	public static int solution(int cardCount) {

		// 카드를 순서대로 생성
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= cardCount; i++) {
			queue.offer(i);
		}

		int i =1;
		while(queue.size() != 1){
			Integer card = queue.poll();
			if (i % 2 == 0) {
				queue.offer(card);
			}
			i++;
		}
		return queue.poll();
	}
}
