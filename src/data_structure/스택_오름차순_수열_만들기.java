package data_structure;

import java.util.Stack;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 6.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * ------------------------------f-----------------------------
 * 24. 11. 6.        ggong       최초 생성
 */
/*
 * 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고 출력할 수 있다면,
 * push와 pop 연산을 어떤 순서로 수행해야 하는지 알아내는 프로그램을 작성해보자.
 * => 변경 1부터 N까지 오름차순으로 스택에 push를 진행하면서 필요할 때마다 pop을 하여 주어진 임의의 수열을 출력할 수 있는지
 *
 * - 입력: 1번째 줄에 수열의 개수 n(1 <= n <= 100,000) 2번쨰 줄에 n개의 줄에는 수열을 이루지 않는 1개이상 n이하의 정수가 1개씩 순서대로 주어짐
 *       * 이때  같은 정수가 두 번 이상 나오지 않음
 * - 출력: 오름차순 수열을 만들기 위한 연산 순서를 출력, push연산은 +, pop연산은 -로 출력하고 불가능시에는 NO를 출력
 */
public class 스택_오름차순_수열_만들기 {
	public static void main(String[] args) {
		System.out.println("1 ::: \n"+ solution_answer(8,new int[]{4,3,6,8,7,5,2,1}));
		System.out.println("2 ::: \n"+ solution_answer(5,new int[]{1,2,5,3,4}));
	}

	/**
	 *
	 * @param numberSize 수열의 크기
	 * @param numbers 수열
	 * @return 연산의 순서 출력
	 */
	public static String solution_answer(int numberSize, int[] numbers) {
		Stack<Integer> stack = new Stack<>(); // 스택
		StringBuilder answer = new StringBuilder();// 연산의 순서
		int stackValue=1; // 스택에 쌓일 값, 오름차순 자연수
		for (int numbersIndex = 0; numbersIndex < numberSize; numbersIndex++) {
			int number = numbers[numbersIndex];

			if (number >= stackValue) {
				while (number >= stackValue) {
					stack.push(stackValue++);
					answer.append("+\n");
				}
				stack.pop();
				answer.append("-\n");
			} else {
				int n = stack.pop();
				if (n > number) {
					answer = new StringBuilder("NO");
					break;
				} else {
					answer.append("-\n");
				}
			}
		}
		return answer.toString();
	}

	/**
	 *
	 * @param numberSize 수열의 크기
	 * @param numbers 수열
	 * @return 연산의 순서 출력
	 */
	public static String solution_ver1(int numberSize, int[] numbers) {
		Stack<Integer> stack = new Stack<>(); // 스택
		StringBuilder answer = new StringBuilder();// 연산의 순서
		int numbersIndex = 0; // 수열의 인덱스
		int stackValue=0; // 스택에 쌓일 값, 오름차순 자연수

		while (numbersIndex<numberSize) {
			int lastStackNumber = stack.isEmpty() ? -1 : stack.peek(); // 스택에서 맨 위에 올라온 값
			int number = numbers[numbersIndex];

			if (number > lastStackNumber) {
				stack.push(++stackValue);
				answer.append("+\n");
			} else if (number == lastStackNumber) {
				stack.pop();
				answer.append("-\n");
				numbersIndex++;
			} else {
				answer = new StringBuilder("NO");
				break;
			}
		}

		return answer.toString();
	}
}
