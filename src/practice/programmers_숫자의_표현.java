package practice;

/**
 * description    : [프로그래머스] 코딩테스트 연습 > 연습문제 > 숫자의 표현
 * packageName    : practice
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 8.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 8.        ggong       최초 생성
 */

/*
 * Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
 *
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 *
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *
 * - 입력: n ( 1 <= n <= 10,000 )
 * - 출력: 표현하는 방법의 수
 */
public class programmers_숫자의_표현 {
	public static void main(String[] args) {
		System.out.println(solution(15));//예시
		System.out.println(solution(6));
	}

	public static int solution(int n) {
		int[] sumList = new int[n + 1]; // 수열의 합
		int answer = 1; // 결과 - 자기 자신은 이미 포함

		for (int i = 1; i <= n; i++) { // 수열의 합 세팅
			sumList[i] += sumList[i - 1] + i;
		}


		// 투 포인터
		int startIndex = 0;
		int endIndex = 0;

		while (endIndex != n) {

			int minus = sumList[startIndex];
			int value = sumList[endIndex];
			if (value - minus == n) {
				answer++;
				endIndex++;
			} else if (value - minus < n) {
				endIndex++;
			} else {
				startIndex++;
			}
		}
		return answer;
	}
}
