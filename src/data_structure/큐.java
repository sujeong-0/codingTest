package data_structure;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 큐 {
	public static void main(String[] args) {
		Scanner       sc           = new Scanner(System.in);
		Deque<String> queue        = new LinkedList<>();
		int           commandCount = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < commandCount; i++) {
			String command = sc.nextLine();
			if(command.startsWith("push ")) {
				queue.offer(command.split(" ")[1]);
				continue;
			}
			switch(command) {
				case "front" -> {
					System.out.println(queue.isEmpty()? "-1":queue.getFirst());
				}
				case "back" -> {
					System.out.println(queue.isEmpty()? "-1":queue.getLast());
				}
				case "size" -> {
					System.out.println(queue.size());
				}
				case "pop" -> {
					System.out.println(queue.isEmpty()? "-1":queue.poll());
				}
				case "empty" -> {
					System.out.println(queue.isEmpty()? "1":"0");
				}
			}
		}
	}
}
