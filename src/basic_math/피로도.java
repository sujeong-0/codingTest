package basic_math;

import java.util.Scanner;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/8/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/8/25        ggong       최초 생성
 */
public class 피로도 {
	public static void main(String[] args) {
		Scanner sc             = new Scanner(System.in);
		int     addStress      = sc.nextInt();
		int     addWork        = sc.nextInt();
		int     minusStress    = sc.nextInt();
		int     standardStress = sc.nextInt();

		int[]     status       = new int[]{0, 0};
		final int STRESS       = 0;
		final int WORK         = 1;
		final int HOURS_OF_DAY = 24;

		for(int i = 0; i < HOURS_OF_DAY; i++) {
			if(status[STRESS] + addStress <= standardStress) {
				// 일을 함
				status[STRESS] += addStress;
				status[WORK] += addWork;
			} else {
				// 쉼
				status[STRESS] = status[STRESS] - minusStress < 0 ? 0 : status[STRESS] - minusStress;
			}
		}
		System.out.println(status[WORK]);
	}
}
