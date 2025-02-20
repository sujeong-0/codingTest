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
import java.util.Arrays;
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
public class Q_11651_좌표정렬하기2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		int[][] arr = new int[count][2];

		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]= new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}

		Arrays.sort(arr, ((o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0]- o2[0];
			}
			return o1[1]- o2[1];
		}));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0; i < arr.length; i++) {
			bw.write(String.format("%d %d\n",arr[i][0], arr[i][1]));
		}
		bw.flush();
		bw.close();
	}
}
