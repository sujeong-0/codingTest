package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 소가_길을_건너간_이유_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int   seeCount = Integer.parseInt(br.readLine());
		int[] cows     = new int[11]; //10마리
		Arrays.fill(cows, -1); // ✅ `for` 루프 대신 `Arrays.fill()` 사용 (빠름)

		int move = 0;
		for(int i = 0; i < seeCount; i++) {
			StringTokenizer st       = new StringTokenizer(br.readLine());
			int             cowNum   = Integer.parseInt(st.nextToken());
			int             location = Integer.parseInt(st.nextToken());
			if(cows[cowNum] != -1 && cows[cowNum] != location) { // 움직임
				move++;
			}
			cows[cowNum] = location;
		}
		System.out.println(move);
	}

	public static void main1(String[] args) throws IOException {//104ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int   seeCount = Integer.parseInt(br.readLine());
		int[] cows     = new int[11]; //10마리
		for(int i = 1; i < cows.length; i++) {
			cows[i] = -1;
		}

		int move = 0;
		for(int i = 0; i < seeCount; i++) {
			StringTokenizer st       = new StringTokenizer(br.readLine());
			int             cowNum   = Integer.parseInt(st.nextToken());
			int             location = Integer.parseInt(st.nextToken());

			if(cows[cowNum] == -1) { // 값을 처음 입력 받는 다면
				cows[cowNum] = location;
			} else if(cows[cowNum] != location) { // 움직임
				cows[cowNum] = location;
				move++;
			}
			//안움직임
		}
		System.out.println(move);
	}
}
