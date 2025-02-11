package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/8/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/8/25        ggong       최초 생성
 */

public class 문자열_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String      line = br.readLine();
		int         n    = Integer.parseInt(line.split(" ")[0]);
		int         m    = Integer.parseInt(line.split(" ")[1]);
		Set<String> s    = new HashSet<>();

		for(int i = 0; i < n; i++) {
			s.add(br.readLine());
		}

		int answer = s.size();
		for(int i = 0; i < m; i++) {
			s.add(br.readLine());
		}

		System.out.println(m - s.size() - answer);
	}
}