package string;

import java.io.*;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */
public class 그래도_출력하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while((s = br.readLine())  != null && !s.isEmpty()) {
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
