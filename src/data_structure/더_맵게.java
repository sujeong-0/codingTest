package data_structure;

import java.util.PriorityQueue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 1.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 1.        ggong       최초 생성
 */
public class 더_맵게 {
	public static void main(String[] args) {
		//		System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
		System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 70000));
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i : scoville) {
			q.offer(i);
		}


		int count = 0;

		while (q.stream().anyMatch(x -> x < K)) {
			if (q.size() < 2) {
				count = -1;
				break;
			}

			Integer smaller = q.poll();
			Integer smaller2 = q.poll();

			count++;
			q.add(smaller + smaller2 * 2);
		}
		return count;
	}
}
