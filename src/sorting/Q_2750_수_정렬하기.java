package sorting;

import java.io.*;
import java.util.Arrays;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */


/**
 * [조건]
 * -
 * <p>
 * [입력]
 * - 10의 배수 5개 입력
 * <p>
 * [출력]
 * - 1번째 줄 평균
 * - 2번쨰 줄 중앙값
 */
public class Q_2750_수_정렬하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] array = new int[count];
		for(int i = 0; i < count; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for(int i = 0; i < count; i++) {
			bw.write(String.valueOf(array[i]));
			bw.newLine();
		}


		bw.flush();
		bw.close();
	}
}
