package basic_math;

import java.util.*;

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
public class 최대공약수와_최소공배수 {
	public static void main(String[] args) {
		Scanner sc     = new Scanner(System.in);
		int     n      = sc.nextInt();
		int     m      = sc.nextInt();


		List<Integer>                   nDivision = new LinkedList<>();
		List<Integer>                   mDivision = new LinkedList<>();

		// 약수 구하기
		for(int i = n; i >0; i--) {
			if(n / i > 0 && n % i == 0) {
				nDivision.add(i);
			}
		}
		for(int i = m; i >0; i--) {
			if(m / i > 0 && m % i == 0) {
				mDivision.add(i);
			}
		}

		// 최대 공약수 구하기
		int maxCommonDivision = 1;
		for(Integer key : nDivision) {
			if(mDivision.contains(key)) { // 둘 다 있는 약수라면
				maxCommonDivision = key;
				break;
			}
		}
		System.out.println(maxCommonDivision);

		// 4. 최소 공약수 구하기
		System.out.println(n / maxCommonDivision * m);

	}
}
