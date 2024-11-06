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
 * n개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
 * - 입력: 수의 개수 n( 1<= n <=  1,000) , n개의 줄에 숫자 (절댓값이 1,000보다 작거나 같은 정수, 수는 중복되지 않음)
 * - 출력: 1번째 줄부터 n개의 줄에 오름차순 정렬한  결과를 1줄에 1개씩 출력
 */
public class 버블_수정렬하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution_ver1(5, new int[]{5, 2, 3, 4, 1})));
		System.out.println(Arrays.toString(solution_answer(5, new int[]{5, 2, 3, 4, 1})));
	}

	public static int[] solution_answer(int count, int[] numbers) {
		for (int i = 0; i < count -1; i++) {
			boolean NoSwaping = true;
			for (int j = 0; j < count - 1 - i ; j++) {
				if (numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					NoSwaping = false;
				}
			}
			if(NoSwaping){ // 버블 정렬에서는 한번도 스왑이 일어나지 않는다면 이미 다 정렬이 되었다고 봄
				break;
			}
		}
		return numbers;
	}
	public static int[] solution_ver1(int count, int[] numbers) {
		for (int i = 0; i < count; i++) {
			boolean NoSwaping = true;
			for (int j = i + 1; j < count; j++) {
				if (numbers[j] < numbers[i]) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
					NoSwaping = false;
				}
			}
			if(NoSwaping){ // 버블 정렬에서는 한번도 스왑이 일어나지 않는다면 이미 다 정렬이 되었다고 봄
				break;
			}
		}
		return numbers;
	}
}
