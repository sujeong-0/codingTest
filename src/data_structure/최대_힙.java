package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/8/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/8/25        ggong       최초 생성
 */
public class 최대_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>((x,y) -> y-x);


		for(int i = 0; i < count; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				System.out.println(queue.isEmpty() ? 0 : queue.poll());
			} else {
				queue.offer(temp);
			}
		}
	}
}
