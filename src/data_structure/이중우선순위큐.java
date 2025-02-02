package data_structure;

import java.util.*;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/1/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/25        ggong       최초 생성
 */
public class 이중우선순위큐 {
	public static void main(String[] args) {
//		System.out.println(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
		System.out.println(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
	}
	public static int[] solution1(String[] operations) {
		Queue<Integer> queue = new LinkedList<>();

		for(String operation : operations) {
			String[] s = operation.split(" ");
			if(s[0].equalsIgnoreCase("I")) {
				queue.offer(Integer.valueOf(s[1]));
			} else if(!queue.isEmpty()) {
				Integer del = s[1].equalsIgnoreCase("1")? queue.stream().max(Integer :: compareTo).get():queue.stream().min(Integer :: compareTo).get();
				queue.removeIf(x -> x == del);
			}
		}
		return queue.isEmpty() ? new int[]{0, 0} : new int[]{queue.stream().max(Integer :: compareTo).get(), queue.stream().min(Integer :: compareTo).get()};
	}
	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for(String operation : operations) {
			String[] s = operation.split(" ");
			if(s[0].equalsIgnoreCase("I")) {
				queue.offer(Integer.valueOf(s[1]));
			} else if(!queue.isEmpty()) {
				if(s[1].equalsIgnoreCase("1")) {
					queue.stream().max(Integer::compareTo).ifPresent(x-> queue.remove(x));
				} else {
					queue.poll();
				}
			}
		}

		if(queue.isEmpty()) {
			return new int[]{0, 0};
		} else {
			return new int[]{queue.stream().max(Integer::compareTo).get(), queue.poll()};
		}
	}
}
