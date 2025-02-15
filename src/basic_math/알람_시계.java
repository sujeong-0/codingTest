package basic_math;

import java.util.Scanner;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/14/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/14/25        ggong       최초 생성
 */
public class 알람_시계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); // 시간
		int m = sc.nextInt(); // 분

		m -= 45;
		if( m< 0) {
			h--;
			m += 60;
		}
		if(h < 0) {
			h = 23;
		}
		System.out.println(String.format("%d %d", h, m));
	}
}
