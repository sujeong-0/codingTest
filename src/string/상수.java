package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/14/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/14/25        ggong       최초 생성
 */
public class 상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		int newA = change(a);
		int newB = change(b);
		System.out.println(newA > newB? newA : newB);

	}

	static int change(char[] chars) {
		char temp = chars[0];
		chars[0] = chars[2];
		chars[2] = temp;
		return Integer.parseInt(String.valueOf(chars));
	}
}
