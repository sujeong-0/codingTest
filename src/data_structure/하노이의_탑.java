package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/2/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/2/25        ggong       최초 생성
 */
public class 하노이의_탑 {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(2)));
	}


	public static int[][] solution(int n) {
		List<int[]> moves = new ArrayList<>();
		hanoi(n, 1,3,2,moves);
		return moves.toArray(new int[][]{});
	}

	private static void hanoi(int n, int from, int to, int aux, List<int[]> moves) {
		if (n == 1) { // 원판이 1개 남으면 바로 이동
			moves.add(new int[]{from, to});
			return;
		}

		// 1. n-1개의 원판을 보조 기둥(aux)로 이동
		hanoi(n - 1, from, aux, to, moves);

		// 2. 가장 큰 원판을 목표 기둥(to)으로 이동
		moves.add(new int[]{from, to});

		// 3. 보조 기둥(aux)에 있는 n-1개의 원판을 목표 기둥(to)으로 이동
		hanoi(n - 1, aux, to, from, moves);
	}
}
