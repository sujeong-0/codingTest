package basic_math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/14/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/14/25        ggong       최초 생성
 */
public class 오븐_시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int             h  = Integer.parseInt(st.nextToken());
		int             m  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());

		if(time > 0) {
			h += time / 60;
			m += time % 60;

			if(m >= 60) {
				h++;
				m -= 60;
			}
			if(h > 23) {
				h -= 24;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(h + " " + m);
		bw.flush();
		bw.close();
	}
}
