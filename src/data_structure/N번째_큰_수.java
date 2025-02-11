package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

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
public class N번째_큰_수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>();


		for(int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < count; j++) {
				queue.offer( Integer.parseInt(st.nextToken()));
				if(queue.size() > count) {
					queue.poll();
				}
			}
		}
		System.out.println(queue.poll());
	}
}
