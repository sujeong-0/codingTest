package string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/5/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/5/25        ggong       최초 생성
 */
public class 숫자의_합 {
	public static void main(String[] args) {
		Scanner sc    = new Scanner(System.in);
		int     count = sc.nextInt();
		String  str   = sc.next();
		int    sum   = Arrays.stream(str.split("")).mapToInt(x -> Integer.parseInt(x)).sum();
		System.out.println(sum);
	}
}
