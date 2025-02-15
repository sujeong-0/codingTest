package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class 다이얼 {
	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int answer =0;
		for(char c : br.readLine().toCharArray()) {
			switch(c) {
				case 'A':
				case 'B':
				case 'C':
					answer += 3;
					break;
				case 'D':
				case 'E':
				case 'F':
					answer += 4;
					break;
				case 'G':
				case 'H':
				case 'I':
					answer += 5;
					break;
				case 'J':
				case 'K':
				case 'L':
					answer += 6;
					break;
				case 'M':
				case 'N':
				case 'O':
					answer += 7;
					break;
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
					answer += 8;
					break;
				case 'T':
				case 'U':
				case 'V':
					answer += 9;
					break;
				default:
					answer += 10;
			}

		}
		System.out.println(answer);

	}
}
