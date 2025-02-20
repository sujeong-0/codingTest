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
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다.
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class Q_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String         numbers  = br.readLine();
		char[] arr = new char[numbers.length()];


		// 데이터 입력
		for(int i = 0; i < arr.length; i++) {
			arr[i] = numbers.charAt(i);
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for(int i = arr.length -1 ; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}
}
