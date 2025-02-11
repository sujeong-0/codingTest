package data_structure;

import java.util.*;


/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/8/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/8/25        ggong       최초 생성
 */
public class 빈도_정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String[]           numbers = sc.nextLine().split(" ");
		Map<String, int[]> data    = new HashMap<>();

		for(int i = 0; i < numbers.length; i++) {
			int finalI = i;
			data.compute(numbers[i], (k, v) -> {
				if(v == null) {
					return new int[]{1, finalI, Integer.parseInt(numbers[finalI])};
				}
				v[0] = v[0] + 1;
				return v;
			});
		}

		Queue<int[]> queue = new PriorityQueue<>((x, y) -> {
			if(x[0] == y[0]) {
				return x[1] - y[1];
			}
			return y[0] - x[0];
		});
		queue.addAll(data.values());

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int[] i = queue.poll();
			for(int j = 0; j < i[0]; j++) {
				sb.append(i[2]).append(" ");
			}
		}
		System.out.println(sb.substring(0, sb.length()));

	}
}
