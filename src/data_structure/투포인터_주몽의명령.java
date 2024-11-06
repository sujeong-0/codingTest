package data_structure;

import java.util.Arrays;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 5.        ggong       최초 생성
 */

/*
 * 갑옷을 만드는 각 재료들은 고유한 번호가 있다.
 * 2가지 재료의 고유한 번호를 합쳐 M(1 <= M <= 10,000,000)이 되어야 갑옷이 만들어진다.
 * N(1 <= N <= 15,000)개의 재료와 M이 주어졌을 때, 갑옷을 몇 개 만들 수 있는지 구하는 프로그램을 작성하시오.
 * - 입력: 1번쨰 줄에 재료의 개수 N, 2번째 줄에 갑옷을 만드는데 필요한 수 M, 3번째 줄에 N개의 재료들이 가진 고유한 번호들(1 <= 고유한 번호 <= 100,000)이 공백을 사이에 두고 주어진다.
 * - 출력: 1번째 줄에 갑옷을 만들 수 있는 개수를 출력한다.
 *
 * 주의점 재료는 한번 쓰면 소멸된다!
 */
public class 투포인터_주몽의명령 {
	public static void main(String[] args) {
//		System.out.println(solution_ver1(6,9,new int[]{2,7,4,1,5,3}));
		System.out.println(solution_ver2(6,9,new int[]{2,7,4,1,5,3}));
	}

	/**
	 *
	 * @param n 재료의 수
	 * @param m 갑옷이 완성되는 번호의 합
	 * @param ingredients 재료들
	 * @return 만들수 있는 개수
	 */
	public static long solution_ver1(int n, long m, int[] ingredients) {

		// Q. 투 포인터에서 정렬은 꼭 필요한 걸까?
		/*
		 * 크기 비교를 하는 것이기 때문에 정렬을 한다면 좀 더 쉽게 풀 수 있음
		 * N의 최대 범위가 15,000으로 작기 때문에 정렬해도 문제가 없음
		 */

		// 변수 선언
		/*int count = 0, start_index=0,end_index=0,sum =ingredients[start_index];

		while (end_index < ingredients.length && start_index < ingredients.length) {
			if (sum == m) {
				count++;
				if (++end_index == ingredients.length) {
					break;
				}
				sum+=ingredients[end_index];
			} else if (sum > m ) {
				sum-=ingredients[start_index];
				start_index++;
			}else if (sum < m ) {
				end_index++;
				sum+=ingredients[end_index];
			}
		}
		return count;*/
		int count =0;

		for (int i = 0; i <ingredients.length; i++) {
			for (int j = i; j < ingredients.length; j++) {
				if (ingredients[i] + ingredients[j] == m) {
					count++;
					System.out.println(ingredients[i] + " + " + ingredients[j] + " = " + m);
				}
			}
		}

		return count;
	}


	/**
	 *
	 * @param n 재료의 수
	 * @param m 갑옷이 완성되는 번호의 합
	 * @param ingredients 재료들
	 * @return 만들수 있는 개수
	 */
	public static long solution_ver2(int n, long m, int[] ingredients) {
		// 1. 정렬하기
//		Arrays.sort(ingredients);
		for (int i = 0; i < ingredients.length; i++) {
			for (int j = 0; j < ingredients.length; j++) {
				if (ingredients[i] < ingredients[j]) {
					int temp = ingredients[i];
					ingredients[i] = ingredients[j];
					ingredients[j] = temp;
				}
			}
		}

		// 2. 정답 찾기
		int count =0, i=0, j=ingredients.length-1;
		while (i < j) {
			int sum = ingredients[i] + ingredients[j];
			if (sum > m) {
				j--;
			} else if (sum <m) {
				i ++;
			} else {
				System.out.println(ingredients[i] + " + " + ingredients[j] + " = " + m);
				count++;
				i++;
				j--;
			}
		}
		return count;
	}
}
