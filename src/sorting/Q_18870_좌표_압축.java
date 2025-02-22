package sorting;

/**
 * description    :
 * packageName    : sorting
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/22/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/22/25        ggong       최초 생성
 */

import java.io.*;
import java.util.*;

/**
 * [조건]
 * - 1 ≤ N ≤ 1,000,000
 * - -10의 9거듭제곱  ≤ Xi ≤ 10의 9거듭제곱
 * <p>
 * [입력]
 * - 첫째 줄에 N
 * - 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN
 * <p>
 * [출력]
 * - 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력
 */
public class Q_18870_좌표_압축 {
	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());

		StringTokenizer st      = new StringTokenizer(br.readLine());
		int[]           numbers = new int[count];
		Set<Integer>    sort    = new HashSet<>();

		// 데이터 입력
		for(int i = 0; i < count; i++) {
			int s = Integer.parseInt(st.nextToken());
			numbers[i] = s;
			sort.add(s);
		}

		// 데이터 정렬
		List<Integer> sorted = new ArrayList<>(sort);
		Collections.sort(sorted);
		Map<Integer, Integer> sortedData = new HashMap<>();
		for(int i = 0; i < sorted.size(); i++) {
			sortedData.put(sorted.get(i), i);
		}

		// 비교 및 정답 작성
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < numbers.length; j++) {
			sb.append(sortedData.get(numbers[j])).append(" ");
		}

		// 출력
		sb.replace(sb.length() - 1, sb.length(), "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void main1(String[] args) throws IOException { // 시간 초과

		BufferedReader        br    = new BufferedReader(new InputStreamReader(System.in));
		int                   count = Integer.parseInt(br.readLine());
		Map<Integer, Integer> data  = new HashMap<>();
		StringTokenizer       st    = new StringTokenizer(br.readLine());
		int[]                 input = new int[count];

		for(int i = 0; i < count; i++) {
			int s = Integer.parseInt(st.nextToken());
			data.compute(s, (k, v) -> v == null ? 1 : v + 1);
			input[i] = s;
		}

		List<Integer> numbers = new ArrayList<>(data.keySet());
		Collections.sort(numbers);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(numbers.indexOf(input[i])).append(" ");
		}

		sb.replace(sb.length() - 1, sb.length(), "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
