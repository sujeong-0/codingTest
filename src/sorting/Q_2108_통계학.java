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
import java.util.*;

/**
 * [조건]
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * <p>
 * [입력]
 * - 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000), N은 홀수
 * - 그 다음 N개의 줄에는 정수, 입력되는 정수의 절댓값은 4,000을 넘지 않는다
 * <p>
 * <p>
 * [출력]
 * - 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * - 둘째 줄에는 중앙값을 출력한다.
 * - 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * - 넷째 줄에는 범위를 출력한다.
 */
public class Q_2108_통계학 {
	public static void main(String[] args) throws IOException {

		BufferedReader           br        = new BufferedReader(new InputStreamReader(System.in));
		int                      count     = Integer.parseInt(br.readLine());
		int                      sum       = 0;
		HashMap<String, Integer> data      = new HashMap<>();
		int[]                    arr       = new int[count];

		for(int i = 0; i < count; i++) {
			String s   = br.readLine();
			int    num = Integer.parseInt(s);
			arr[i] = num;
			sum += num;
			data.compute(s, (k, v) -> v == null ? 1 : v + 1);
		}


		// 최빈값
		int                      mostCount = 0;
		List<Integer>             mostNums  = new ArrayList<>();
		Integer max = Collections.max(data.values());

		for(Map.Entry<String, Integer> e : data.entrySet()) {
			if(max== e.getValue()) {
				mostNums.add(Integer.valueOf(e.getKey()));
			}
		}

		int mostNum = 0;
		if(mostNums.size() == 1) {
			mostNum = mostNums.get(0);
		}
		if(mostNums.size() > 1) {
			Collections.sort(mostNums);
			mostNum = mostNums.get(1);
		}


		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%d", Math.round((double) sum / count))).append("\n");
		sb.append(arr[count / 2]).append("\n");
		sb.append(mostNum).append("\n");
		sb.append(arr[count - 1] - arr[0]);


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();


	}
}
