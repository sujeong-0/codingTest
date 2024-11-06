package data_structure;

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
 * 어떠한 자연수 n은 몇 개의 연속된 자연수의 합으로 나ㅏ낼 수 있다.
 * n을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
 * - 입력: 1번째 줄에 정수 N이 주어진다. ( 1 <= n <= 10,000,000 )
 * - 출력: 입력된 자연수 N을 연속된 자연수의 합으로 나타내는 자짓수를 출력한다.
 */
public class 투포인터_연속된_자연수의_합_구하기 {
	public static void main(String[] args) {
		//		System.out.println("가지수 = "+ solution_ver1(15));
		System.out.println("가지수 = " + solution_ver2(15));
	}

	public static long solution_ver1(int n) {
		// 1. 자연수의 합 배열 생성(n개 까지만)
		long[] sumArray = new long[n + 1];
		for (int i = 1; i < sumArray.length; i++) {
			sumArray[i] = sumArray[i - 1] + i;
		}

		// 2. 합배열 내에 값의 차가 n인 모든 경우 세어보기
		int answer = 0;
		for (int i = 0; i < sumArray.length; i++) {
			for (int j = 0; j < i; j++) {
				if (sumArray[i] - sumArray[j] == n) {
					//					System.out.println("i = " + i + " j = " + j);
					String temp = "";
					// 만약 경우의 수를 프린트 해야한다면?
					for (int k = j + 1; k <= i; k++) {
						temp += k + " + ";
					}
					temp = temp.replaceAll(" \\+ $", " = ");
					temp += n;
					System.out.println(temp);
					answer++;
				}
			}
		}

		return answer;
	}

	public static long solution_ver2(int n) {
		// 투 포인터를 이용해 풀기
		/*
		 * 투 포인터의 알고리즘
		 * sum = 합(start_index부터 end_index까지의 합을 의미), n 찾으려는 대상의 수, start_index = 시작 인덱스, end_index = 마지막 인덱스, count = 가지수
		 *
		 * 1. sum > n 이라면   start_index 증가
		 *      1 ) sum - start_index   : 총 합에서 start_index의 값을 뺀다.
		 *      2 ) start_index++       : start_index를 증가시킨다.
		 * 2. sum < n 이라면  end_index 증가
		 *      1 ) sum + end_index     : 총 합에서 end_index의 값을 더한다.
		 *      2 ) end_index++         : end_index를 증가시킨다.
		 * 3. sum == n 이라면  end_index 증가
		 *      1 ) end_index++         : end_index를 증가시킨다.
		 *      2) count++              : count를 증가시킨다.
		 *      3 ) sum + end_index     : 총 합에서 end_index의 값을 더한다.
		 */


/*
		// 1. 데이터 선언
		int[] data = new int[n];

		for (int i = 0; i < data.length; i++) {
			data[i] = i +1 ;
		}

		// 2. 투 포인터 알고리즘
		int count =0, start_index =0, end_index=0, sum = data[start_index];
		while (start_index < data.length && end_index < data.length) {
			if (sum > n) {
				sum-=data[start_index];
				start_index++;
				continue;
			}

			if (sum < n) {
				end_index++;
				sum+=data[end_index];
				continue;
			}

			if (sum == n) {
				count++;
				String temp = "";
				for (int i =  start_index; i <=end_index; i++) {
					temp += i + " + ";
				}
				temp = temp.replaceAll(" \\+ $", " = ");
				temp += n;
				System.out.println( temp);
				if (end_index + 1 >= data.length) {
					break;
				}

				end_index++;
				sum+=data[end_index];
			}
		}

		return count;

*/

		//==================== 정 답 지 =====================

		// 1. 선언
		// count가 1인 이유는 자기 자신 스스로를 카운팅 하는 경우 ex) 6일떄, 1+2+3 과 6 이렇게 두가지 경우에서 6 자신을 하나의 경우로 치는데, 이를 의미
		int count = 1, start_index = 1, end_index = 1, sum = 1;


		// 2. 투 포인터 알고리즘 => O(n)의 복잡도를 가지고 있음
		while (end_index != n) {
			if (sum == n) {
				count++;
				end_index++;
				sum += end_index;
			} else if (sum > n) {
				sum -= start_index;
				start_index++;
			} else if (sum < n) {
				end_index++;
				sum += end_index;
			}
		}

		return count;

	}
}
