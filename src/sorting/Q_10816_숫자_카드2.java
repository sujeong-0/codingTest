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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *  다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성
 *
 *  [입력]
 *  - 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다
 *  - 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.(-10,000,000 <= 숫자 카드 수 <= 10,000,000)
 *  - 셋째 줄에는 M(1 ≤ M ≤ 500,000)
 *  - 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
 *
 *  [출력]
 * - 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
 *
 */
public class Q_10816_숫자_카드2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int hasCardCount = Integer.parseInt(br.readLine());
		Map<String, Integer> hasCard = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < hasCardCount; i++) {
			hasCard.compute(st.nextToken(), (k, v) -> v == null ? 1 : v + 1);
		}

		int quizCount = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < quizCount; i++) {
			sb.append(hasCard.getOrDefault(st.nextToken(), 0)).append(" ");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.replace(sb.length() - 1, sb.length(), "").toString());
		bw.flush();
		bw.close();


	}
}
