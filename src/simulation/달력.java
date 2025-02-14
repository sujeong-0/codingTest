package simulation;

import java.io.*;
import java.util.*;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/12/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/12/25        ggong       최초 생성
 */
public class 달력 {
	public static void main(String[] args) throws IOException {
		BufferedReader        br    = new BufferedReader(new InputStreamReader(System.in));
		int                   count = Integer.parseInt(br.readLine());
		Map<Integer, Integer> data  = new HashMap<>();
		StringTokenizer       st;
		List<Integer> days = new ArrayList<>();

		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			days.add(start);
			days.add(end);

			for(int j = start; j <= end; j++) {
				data.compute(j, (k, v) -> v == null ? 1 : v + 1);
			}
		}
		Collections.sort(days);


		int answer = 0;
		int maxValue  =0;
		int startIndex = 0;
		boolean isPreValueZero = true;
		for(int i = days.get(0); i <= days.get(days.size()-1) +1; i++) {
			if(data.get(i) != null) {
				if(isPreValueZero && data.get(i -1) == null) {
					startIndex = i;
				}
				if(maxValue < data.get(i)) {
					maxValue = data.get(i);
				}
			} else {
				answer += maxValue * (i - startIndex);
				maxValue = 0;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
