package search;

import java.util.Arrays;

/**
 * description    :1920번
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 12. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 9.        ggong       최초 생성
 */
public class 이진탐색_원하는정수찾기 {

	/**
	 *
	 * [질의]
	 * n개의 정수 A[1],A[2],A[3],,,A[n]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오
	 *
	 * [입력]
	 *  1번째 줄에 자연수 n(1 <= n <= 100,000), 그 다음 줄에 n개의 정수
	 *  그 다음 줄에 m(1 <= m <=100,000), 그 다음줄에 m개의 정수가 주어짐
	 *
	 *  이때 m개의 수들이 n개의 수들안에 존재하는지 알아내면 된다.
	 *
	 *  모든 정수의 범위는 -231 <= 모든 정수 <231
	 *
	 *
	 *  [출력]
	 *  존재하면 1, 아니면 0 을 출력
	 */



	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution_binary(5, new int[]{4, 1, 5, 2, 3}, 5, new int[]{5, 3, 7, 9, 5})));
	}
	public static boolean[] solution_binary(int n ,int[] arrayN, int m, int[]arrayM) {
		boolean[] result = new boolean[m];


		// 데이터 정렬
		Arrays.sort(arrayN);
		for (int j = 0; j < m; j++) {
			int i = (arrayN.length +1) /2 ;
			result[j] = false;
			int findNumber = arrayM[j];
			while (true) {
				if (i < arrayN.length && arrayN[i] == findNumber) {
					result[j] = true;
					break;
				} else {
					int term = (arrayN.length+1 - i) / 2;
					if (term == 0) {
						break;
					}

					if (arrayN[i] >findNumber) {
						i = i - term;
					} else {
						i = i + term;
					}
				}
			}
		}


		return result;
	}

}
