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
public class 진법_변환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String number    = sc.next().toUpperCase();
		int    formation = sc.nextInt();
		long   answer    = 0;
		char[] numbers   = number.toCharArray();

		for(int i = 0; i < numbers.length; i++) {
			int num = Character.isDigit(numbers[i]) ? Integer.parseInt(String.valueOf(numbers[i])) : (int) numbers[i] - 55;
			answer += num * Math.pow(formation, numbers.length - 1 - i);
		}
		System.out.println(answer);
	}
}
