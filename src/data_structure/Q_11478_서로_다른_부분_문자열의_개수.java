package data_structure;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/23/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/23/25        ggong       최초 생성
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * [조건]
 * - 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
 * - ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개
 * <p>
 * [입력]
 * - 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하
 * <p>
 * [출력]
 * - 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력
 */
public class Q_11478_서로_다른_부분_문자열의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Set<String> subStr = new HashSet<>();

		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j <= str.length(); j++) {
				subStr.add(str.substring(i, j));
			}
		}

		System.out.println(subStr.size());
	}
}
