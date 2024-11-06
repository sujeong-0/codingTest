package sorting;

import java.util.Arrays;

/**
 * description    :
 * packageName    : sorting
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 6.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 6.        ggong       최초 생성
 */

/*
 * [선택 정렬]
 *  : 최솟값 또는 최댓값을 찾고, 남은 정렬 부분의 가장 앞에 있는 데이터와 swap하는 것이 선택정렬의 핵심
 *  : 시간 복잡도 O(n^2)
 *
 * 배열을 정리하는 것은 쉽다. 수가 주어지면 그 수의 각 자릿수를 내림차순으로 정렬하시오.
 * - 입력: 정렬할 수 n이 주어진다. n은  1,000,000,000보다 작거나 같은 자연수
 * - 출력: 1번째 줄에 자릿수를 내림차순 정렬한 수를 출력한다.
 */
public class 선택_수정렬하기 {
	public static void main(String[] args) {
		System.out.println(solution_answer(2143));
		System.out.println(solution_answer(92837561));
	}

	public static int solution_answer(int number) {
		// 세팅
		String str = String.valueOf(number);
		int[] A = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.split("")[i]);
		}

		// 선택정렬
		for (int i = 0; i < A.length; i++) {
			int maxIndex = i;
			for (int j = i+1; j < A.length; j++) {
				if (A[j]>A[maxIndex]) {
					maxIndex  =   j;
				}
			}
			if (A[i] < A[maxIndex]) {
				//swap
				int temp = A[i];
				A[i]= A[maxIndex];
				A[maxIndex]= temp;
			}
		}



		// 정렬된 배열을 숫자로 바꿔주기
		StringBuilder answer  = new StringBuilder();
		for (int j : A) {
			answer.append(j);
		}

		return Integer.parseInt(answer.toString());
	}

	public static int solution(int number) {
		int[] numbers = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int index = numbers.length - 1;
		int answer =0;

		// 세팅
		while (number != 0) {
			numbers[index--] =  number % 10;
			number = number / 10;
		}

		// 내림차순 정렬 - 선택 정렬
		for (int j = 0; j < numbers.length; j++) {
			if (numbers[j] == -1) {
				continue;
			}
			// max 값 찾기
			int max =  Integer.MIN_VALUE;
			int maxIndex = -1;
			for (int i = j; i < numbers.length; i++) {
				int n = numbers[i];
				if (max < n) {
					max = n  ;
					maxIndex  =i;
				}
			}
			// swap
			int temp = numbers[j];
			numbers[j] =  numbers[maxIndex];
			numbers[maxIndex] = temp;
		}

		// 정렬된 배열을 숫자로 바꿔주기
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == -1) {
				continue;
			}
			answer = answer * 10 + numbers[i];
		}
		return answer;
	}
}
