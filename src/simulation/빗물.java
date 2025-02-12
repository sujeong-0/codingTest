package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
public class 빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());
		int             h    = Integer.parseInt(st.nextToken());
		int             w    = Integer.parseInt(st.nextToken());
		int[]           data = new int[w];
		st = new StringTokenizer(br.readLine());
		int answer = 0;

		for(int i = 0; i < w; i++) {
			int d = Integer.parseInt(st.nextToken());
			data[i] = d;
		}


		for(int i = 0; i < w; i++) {
			if(data[i] == 0) {
				continue;
			}
			for(int j = i + 1; j < w; j++) {
				if(data[j] < data[i] || j - i < 2) {
					continue;
				}
				for(int k = i + 1; k < j; k++) {
					if(data[i] < data[k]) {
						break;
					}
					answer += data[i] - data[k];
					data[k] = data[i];
				}
			}
		}
		for(int i = w - 1; i > 0; i--) {
			if(data[i] == 0) {
				continue;
			}
			for(int j = i - 1; j > 0; j--) {
				if(data[j] < data[i] || i - j < 2) {
					continue;
				}
				for(int k = i - 1; k > j; k--) {
					if(data[i] < data[k]) {
						break;
					}
					answer += data[i] - data[k];
					data[k] = data[i];
				}
			}
		}

		System.out.println(answer);


	}
}
