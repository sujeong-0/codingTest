package basic_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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
public class 소수_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		int             count = Integer.parseInt(br.readLine());
		int primeCount = 0;
		Set<String>     split = new HashSet<>(List.of(br.readLine().split(" ")));

		for(String s : split) {
			int number = Integer.parseInt(s);
			if(number == 1) {
				continue;
			}

			boolean isPrime = true;
			for(int j = 2; j <= Math.sqrt(number); j++) {
				if(number % j == 0 && number != j) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeCount++;
			}
		}

		System.out.println(primeCount);
	}
}
