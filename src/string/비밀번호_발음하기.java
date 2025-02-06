package string;

import java.util.Scanner;
import java.util.regex.Pattern;

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
public class 비밀번호_발음하기 {
	public static void main(String[] args) {

		Pattern pattern1 = Pattern.compile("[aeiou]");
		Pattern pattern2 = Pattern.compile("[aeiou]{3,}");
		Pattern pattern3 = Pattern.compile("[^aeiou]{3,}");
		Pattern pattern4 = Pattern.compile("([a-df-np-z])\\1+");

		Scanner sc = new Scanner(System.in);

		while(true) {
			String password = sc.nextLine();
			if(password.equals("end")) {
				break;
			}

			// 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
			if(!pattern1.matcher(password).find()) {
				System.out.println("<" + password + "> is not acceptable.");
				continue;
			}

			// 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
			if(pattern2.matcher(password).find() || pattern3.matcher(password).find()) {
				System.out.println("<" + password + "> is not acceptable.");
				continue;
			}


			// 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
			if(pattern4.matcher(password).find()) {
				System.out.println("<" + password + "> is not acceptable");
				continue;
			}
			System.out.println("<" + password + "> is acceptable");

		}

	}
}
