package sorting;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */
public class U_10989_수_정렬하기3 {
	// TODO 메모리 초과, 해결하지 못하였음
	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		BufferedWriter bw    = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> a = new PriorityQueue<>();
		for(int i = 0; i < count; i++) {
			a.offer(Integer.parseInt(br.readLine()));
		}
		for(int i = 0; i < count; i++) {
			bw.write(String.valueOf(a.poll()));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
