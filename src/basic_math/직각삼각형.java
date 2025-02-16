package basic_math;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */
public class 직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br      = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter  bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		int[]           numbers = new int[3];
		while(true) {
			st = new StringTokenizer(br.readLine());
			numbers[0] = Integer.parseInt(st.nextToken());
			numbers[1] = Integer.parseInt(st.nextToken());
			numbers[2] = Integer.parseInt(st.nextToken());

			Arrays.sort(numbers);

			boolean answer = true;

			if(numbers[0] == 0) {
				answer = false;
				if(numbers[1] == 0 && numbers[2] == 0) {
					break;
				}
			}

			if(answer) {
				answer = numbers[2] * numbers[2] == numbers[0] * numbers[0] + numbers[1] * numbers[1];
			}
			bw.write(answer ? "right" : "wrong");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
