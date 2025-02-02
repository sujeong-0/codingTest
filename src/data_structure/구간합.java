package data_structure;

import java.util.Arrays;

/**
 * description    : do it 코딩테스트 - 구간합
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 5.        ggong       최초 생성
 */
//todo 수 N개가 주어졌을 때, i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
// - 입력: 1번째 줄에서 수의 개수 N (1 <= N <= 100,000), 합을 구해야 하는 횟수 M(1 <= M <= 100,000)
//          2번째 줄에서 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다.
//          3번쨰 줄부터는 M개의 줄에 합을 구해야하는 구간 i와 j가 주어진다.
// - 출력: 총 M개의 줄에 입력으로 주어진 i번째의 수에서 j번째의 수까지의 합을 출력한다.

public class 구간합 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("5 3\n5 4 3 2 1\n1 3\n2 4\n5 5")));

		Arrays.sort(new int[]{1, 2, 3, 4});

	}

	public static long[] solution(String question) {

		int DATA_COUNT   = Integer.parseInt(question.split("\n")[0].trim().split(" ")[0]); // 데이터의 개수
		int ANSWER_COUNT = Integer.parseInt(question.split("\n")[0].trim().split(" ")[1]); // 질의 개수

		String[] dataStr = question.split("\n")[1].trim().split(" ");
		int[]    data    = new int[DATA_COUNT];// 데이터
		long[]   dataSum = new long[DATA_COUNT];// 구간합 데이터
		long[]   answer  = new long[ANSWER_COUNT];// 구간합 데이터


		// 1. 구간합 구하기
		for(int i = 0; i < dataStr.length; i++) {
			data[i] = Integer.parseInt(dataStr[i]);

			if(i == 0) {
				dataSum[i] = data[i];
			} else {
				dataSum[i] = dataSum[i - 1] + data[i];
			}
		}


		String[] questions = question.split("\n", 3)[2].split("\n");

		// 2. 질의에 대한 답 구하기
		for(int i = 0; i < ANSWER_COUNT; i++) {
			String[] indexes = questions[i].split(" ");
			int      indexI  = Integer.parseInt(indexes[1]) - 1;
			int      indexJ  = Integer.parseInt(indexes[0]) - 2;

			long Si = indexI < 0 ? 0 : dataSum[indexI];
			long Sj = indexJ < 0 ? 0 : dataSum[indexJ];

			answer[i] = Si - Sj;
		}
		return answer;
	}
}
