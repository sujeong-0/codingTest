package string;

import java.io.*;
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
public class 문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			String str = br.readLine();
			sb.append(str.charAt(0));
			if(str.length() < 2) {
				sb.append(str);
			} else {
				sb.append(str.charAt(str.length() - 1));
			}
			sb.append("\n");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
