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
public class 문자열_반복 {
	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < count; i++) {
			StringTokenizer st      = new StringTokenizer(br.readLine());
			int             loop    = Integer.parseInt(st.nextToken());
			String          strings = st.nextToken();
			for(int k = 0; k < strings.length(); k++) {
				for(int j = 0; j < loop; j++) {
					bw.append(strings.charAt(k));
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
