package practice;

import java.util.Arrays;

/**
 * description    : [프로그래머스] 코딩테스트 연습 > 연습문제 > 다음 큰 숫자
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
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 *
 * 		조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 		조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 * n 의 범위 1 <= n <= 1,000,000
 *
 * - 입력: n
 * - 출력: n의 다음 큰 숫자
 *
 */
public class programmers_다음_큰_숫자 {
	public static void main(String[] args) {
		System.out.println(solution_ver1(78));
		System.out.println(solution_ver1(15));
	}

	/*public static int solution_ver2(int n) {
		String binaryN = "0" + Integer.toBinaryString(n);
		String[] split = binaryN.split("01");

		// 1의 개수를 셈
		int oneCount = 0;
		for (char s : split[split.length - 1].toCharArray()) {
			if (s == '1') {
				oneCount++;
			}
		}
		// 맨 뒷자리만 새로 만듬
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < split[split.length - 1].length()  - oneCount; i++) {
			answer.append("0");
		}
		for (int i = 0; i <  oneCount; i++) {
			answer.append("1");
		}
		split[split.length - 1] = answer.toString();

	}*/

	public static int solution_ver1(int n) { // 효율성에서 떨어짐
		// 1. n을 2진수로 변환 = 배열로 표시
		char[] binaryN = ("0" + Integer.toBinaryString(n)).toCharArray();
		System.out.println("n을 2진수로 변환 ::: " + Arrays.toString(binaryN));
		// 2. 인덱스의 높은 값부터 조회하며, 타겟 왼쪽의 값이 0으로 된 곳을 찾고 찾으면 왼쪽의 0과 값을 스위치
		int indexSwitch = -1;
		int oneCount = 0; // 1이 몇개 있었는지, 시프트할 1의 개수 확인
		for (int i = binaryN.length - 1; i - 1 >= 0; i--) {
			if (binaryN[i] == '1') {
				if (binaryN[i - 1] == '0') {// 왼쪽에 0이라면 스위치
					binaryN[i] = '0';
					binaryN[i - 1] = '1';
					indexSwitch = i; // 바꾼 위치 기록
					break;
				}
				oneCount++;
			}
		}
		System.out.println("n을 1과 0 스위치 ::: " + Arrays.toString(binaryN));

		// 3. 스위치한 값보다 높은 인덱스 값을 가진 1들은 전부 인덱스값이 높은 (= 우측으로 시프트)
		for (int i = binaryN.length - 1; i > indexSwitch; i--) {
			if (oneCount > 0) {
				binaryN[i] = '1';
				oneCount--;
			} else {
				binaryN[i] = '0';
			}
		}
		System.out.println("n을 1 시프트 ::: " + Arrays.toString(binaryN));
		// 4. 2->10진수로 변환
		return Integer.parseInt(String.valueOf(binaryN), 2);
	}
}
