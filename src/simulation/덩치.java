package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 덩치 {
	public static void main(String[] args) throws IOException {
		final int HEIGHT = 0;
		final int WEIGHT = 1;
		final int RANK = 2;

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());

		int[][] members = new int[count][2];


		for(int i = 0; i < count; i++) {
			StringTokenizer st     = new StringTokenizer(br.readLine());
			int             height = Integer.parseInt(st.nextToken());
			int             weight = Integer.parseInt(st.nextToken());

			int rank = 1;
			for(int j = 0; j < i; j++) {
				if(members[j][HEIGHT] > height && members[j][WEIGHT] > weight) {
					rank++;
				} else if(members[j][HEIGHT] < height && members[j][WEIGHT] < weight){
					members[j][RANK]++;
				}
			}
			members[i] = new int[]{height, weight, rank};
		}

		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < members.length; j++) {
			sb.append(members[j][2]).append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
