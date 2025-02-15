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
public class 문자와_문자열 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String         str  = br.readLine();


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(str.charAt(Integer.parseInt(br.readLine()) -1 ));
		bw.flush();
		bw.close();
	}
}
