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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [조건]
 * - 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수
 *
 * <p>
 * [입력]
 * - 첫째 줄에는 응시자의 수 N(1 <= N <= 1000)과 상을 받는 사람의 수 k(1 <= K <= N)가 공백을 사이에 두고 주어진다.
 * - 둘째 줄에는 각 학생의 점수
 *
 * <p>
 * [출력]
 * - 상을 받는 커트라인을 출력
 */
public class Q_25305_커트라인 {
	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int            N = Integer.parseInt(st.nextToken());
		int            kCount = Integer.parseInt(st.nextToken());


		// 점수 입력
		st = new StringTokenizer(br.readLine());
		int[] scores = new int[N];
		for(int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(scores);


		System.out.println(scores[N-kCount]);
	}
}
