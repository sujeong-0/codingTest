package basic_math;

import java.util.Scanner;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 9.        ggong       최초 생성
 */
public class 윤년 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		System.out.println(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)? 1: 0);
	}
}
