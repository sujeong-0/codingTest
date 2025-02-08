package basic_math;

import java.util.Scanner;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/7/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/7/25        ggong       최초 생성
 */
public class 소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     m  = Integer.parseInt(sc.nextLine());
		int     n  = Integer.parseInt(sc.nextLine());

		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int number = m; number <= n; number++) {

			if(number == 1) {
				continue;
			}

			boolean isPrime = true;
			for(int i = 2; i <= Math.sqrt(number); i++) {
				if(number % i == 0 && number != i) {
					isPrime= false;
					break;
				}
			}
			if(isPrime) {
				sum += number;
				if(min > number) {
					min = number;
				}
			}
		}

		System.out.println(sum == 0 ? -1 : sum + "\n" + min);

	}
}
