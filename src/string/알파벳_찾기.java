package string;

import java.io.*;

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
public class 알파벳_찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String         str = br.readLine();
		for(int i = 97; i < 123; i++) {
			System.out.print(str.indexOf(i));
			System.out.print(" ");
		}
	}
}
