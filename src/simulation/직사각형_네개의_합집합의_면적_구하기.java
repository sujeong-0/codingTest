package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/13/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/13/25        ggong       최초 생성
 */
public class 직사각형_네개의_합집합의_면적_구하기 {
	public static void main(String[] args) throws IOException {
		// TODO 미해결 - 문제를 풀지 못함
		BufferedReader br          = new BufferedReader(new InputStreamReader(System.in));
		final int      N           = 4;
		final int      LEFT_DOWN_X = 0;
		final int      LEFT_DOWN_Y = 1;
		final int      RIGHT_UP_X  = 2;
		final int      RIGHT_UP_Y  = 3;
		final int      SQUARE      = 4;

		int[][] data   = new int[N][5];
		int     answer = 0;


		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int leftDownX = Integer.parseInt(st.nextToken());
			int leftDownY = Integer.parseInt(st.nextToken());
			int rightUpX  = Integer.parseInt(st.nextToken());
			int rightUpY  = Integer.parseInt(st.nextToken());

			int square = (rightUpX - leftDownX) * (rightUpY - leftDownY);
			answer += square;

			data[i] = new int[]{leftDownX, leftDownY, rightUpX, rightUpY, square};
		}

		for(int i = 0; i < N; i++) {
			int[] square1 = data[i];

			for(int j = 0 ; j < N; j++) {
				if(i == j ) {
					continue;
				}
				int[] square2 = data[j];

				int x = 0;
				int y = 0;

				if(square1[RIGHT_UP_X] > square2[LEFT_DOWN_X] || square1[RIGHT_UP_Y] > square2[LEFT_DOWN_Y]) { // 겹친다면

					x = square1[RIGHT_UP_X] - square2[LEFT_DOWN_X];
					if(square1[LEFT_DOWN_X] > square2[LEFT_DOWN_X]) {
						x = square1[RIGHT_UP_X] - square1[LEFT_DOWN_X];
					}
					y = square1[RIGHT_UP_Y] - square2[LEFT_DOWN_Y];
					if(square1[LEFT_DOWN_Y] > square2[LEFT_DOWN_Y]) {
						y = square1[RIGHT_UP_Y] - square1[LEFT_DOWN_Y];
					}
					answer -= x * y; // 겹치는 면적을 제거함
					System.out.println(x * y);

					// 겹치는 부분을 오려냄
					square1[RIGHT_UP_X] -= x;
					square1[RIGHT_UP_Y] -= y;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();

	}
}
