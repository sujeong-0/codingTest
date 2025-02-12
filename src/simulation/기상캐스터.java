package simulation;

import java.io.*;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/11/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/11/25        ggong       최초 생성
 */
public class 기상캐스터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]       st = br.readLine().split(" ");
		int            h  = Integer.parseInt(st[0]);
		int            w  = Integer.parseInt(st[1]);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < h; i++) {
			String line       = br.readLine();
			int    cloudIndex = -1;
			for(int j = 0; j < w; j++) {
				if(line.charAt(j) == 'c') {
					cloudIndex = j;
					sb.append(0);
				} else {
					sb.append(cloudIndex == -1 ? -1 : j - cloudIndex);
				}
				sb.append(" ");
			}
			sb.replace(sb.length() - 1, sb.length(), "\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
