package data_structure;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/2/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/2/25        ggong       최초 생성
 */
public class 프로세스 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 3, 2}, 2) + " == 1");
		System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0) + " == 5");
		System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 2) + " == 3");
		System.out.println(solution(new int[]{1, 1, 1}, 1) + " == 2");

	}

	public static int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq    = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
		Queue<int[]>           queue = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			queue.add(new int[]{i, priorities[i]});
			pq.add(priorities[i]);
		}

		int count = 1;
		while(!queue.isEmpty()) {
			int[] job  = queue.poll();

			if( pq.peek() > job[1]) { // 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습
				queue.add(job);
				continue;
			}
			pq.poll();

			if(job[0] == location) {
				break;
			}
			count++;
		}

		return count;
	}

	public static int solution1(int[] priorities, int location) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			queue.add(new int[]{i, priorities[i]});
		}

		int count = 1;
		while(!queue.isEmpty()) {
			int   high = queue.stream().max(Comparator.comparingInt(x -> x[1])).get()[1];
			int[] job  = queue.poll();


			if(high > job[1]) { // 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습
				queue.add(job);
				continue;
			}

			if(job[0] == location) {
				break;
			}
			count++;
		}
		return count;

	}

}
