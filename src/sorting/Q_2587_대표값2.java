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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성
 *
 *  [입력]
 *  - 첫째 줄부터 다섯 번째 줄까지 한 줄에 하나씩 자연수가 주어진다. 주어지는 자연수는 100 보다 작은 10의 배수이다.
 *
 *  [출력]
 * - 첫째 줄에는 평균을 출력하고, 둘째 줄에는 중앙값을 출력한다.
 *
 */
public class Q_2587_대표값2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = 5;
		int[] arr = new int[count];
		int sum =0;
		for(int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println(sum / count);
		System.out.println(arr[2]);
	}
}
