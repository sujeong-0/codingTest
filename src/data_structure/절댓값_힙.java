package data_structure;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 9.        ggong       최초 생성
 */
public class 절댓값_힙 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new PriorityQueue<>((x,y) -> {
			int absX = Math.abs(x);
			int absY = Math.abs(y);

			if (absX== absY) {
				return x - y;
			}
			return absX - absY;
		});

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				queue.offer(n);
			} else {
				bw.write(String.valueOf(queue.isEmpty()? 0: queue.poll()));
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
