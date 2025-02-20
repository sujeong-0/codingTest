package sorting;

/**
 * description    :
 * packageName    : sorting
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/20/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/20/25        ggong       최초 생성
 */


import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
 *  위치가 같은 두 점은 없다.
 *
 *
 *  [입력]
 *  - 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)
 *  - 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수
 *
 *  [출력]
 * - 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력
 *
 */
public class Q_11650_좌표정렬하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
			if(o1[0] == o2[0 ]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		}));


		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			queue.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			bw.write(String.format("%d %d\n", p[0], p[1]));
		}
		bw.flush();
		bw.close();
	}
}
