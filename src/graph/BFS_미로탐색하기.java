package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description    : 백준 2178번
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 12. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 9.        ggong       최초 생성
 */
public class BFS_미로탐색하기 {

	/*
	 * [규칙]
	 * 미로의 각 칸에 있는 숫자중 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸을 나타냄
	 * 다른 칸트으로 이동시, 서로 인접한 칸으로만 이동할 수 있음
	 * 이동한 칸을 셀 때는 시작 위치와 도착 위치를 포함함. 즉 (1,1)에서 (4,6)으로 이동시 15칸을 지나야함
	 *
	 * [질의]
	 * n * m 크기의 미로가 주어질 떄, (1,1)에서 출발해 (n,m)의 위치로 이동하기 위해 지나야하는 칸 수의 최솟값을 구하는 프로그램을 구하시오.
	 *
	 * [입력]
	 * 1번째 줄에 두 정수 n,m (2 <= n,m <= 100)
	 * 그다음 n개의 줄에는 미로의 내용이 m개의 정수로 주어지며, 각 수들은 붙어서 입력됨
	 *
	 * [출력]
	 * 1번쨰 줄에 지나야하는 칸 수의 최솟값을 출력
	 */


	public static void main(String[] args) {
		System.out.println(solution_BFS(4,6,new int[][]{
				new int[]{1,1,0,1,1,0},
				new int[]{1,1,0,1,1,0},
				new int[]{1,1,1,1,1,1},
				new int[]{1,1,1,1,0,1},
		}));
		System.out.println(solution_BFS(2,25,new int[][]{
				new int[]{1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
				new int[]{1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1},
		}));
	}

	/**
	 * moveX와 moveY는 둘이 한 쌍으로 사용되며, 의미는 문제에서 말한 미로의 칸에서 움직임을 "상, 하, 좌, 우" 4개로 할 수 있다고 한 것을 대응한 내용
	 *
	 * 예를 들어,
	 * moveX와 moveY 둘 다에 index를 0으로 한 값이면 0,1로 x를 0움직이고, y를 1움직인다면 오른쪽으로 한 칸 움직이는 것과 같고
	 * moveX와 moveY 둘 다에 index를 1으로 한 값이면 1,0로 x를 1움직이고, y를 0움직인다면 왼쪽으로 한 칸 움직이는 것과 같고
	 * moveX와 moveY 둘 다에 index를 2으로 한 값이면 0,-1로 x를 0움직이고, y를 -1움직인다면 위로 한 칸 움직이는 것과 같고
	 * moveX와 moveY 둘 다에 index를 4으로 한 값이면 -1,0로 x를 -1움직이고, y를 0움직인다면 아래로 한 칸 움직이는 것과 같다.
	 *
	 * 이렇게 해서 상 하 좌 우 로 음직이는 것에 대한 내용을 표현 할 수 있다.
	 */
	static int[] moveX = {0, 1, 0, -1};
	static int[] moveY = {1, 0, -1, 0};

	static boolean[][] visited; // 방문기록 저장배열
	static int [][] array; // 미로
	static int n, m;
	public static int solution_BFS(int N, int M, int[][] a) {
		n = N;
		m = M;
		visited = new boolean[n][m];
		array = a;

		BFS(0, 0);
		return array[n-1][m-1];
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < moveX.length; k++) { // 상하좌우 검색
				int x = moveX[k] + now[0] ;
				int y = moveY[k] + now[1] ;
				if (x >= 0 && x < n && y >= 0 && y < m ) { // 실제 배열 인덱스 중 유효한 범위인지
					if ( array[x][y]<1 || visited[x][y]) { // 갈 수 있는 곳이거나(= 값이 1인 곳),  방문했던 곳은 가지 않음
						continue;
					}
					visited[x][y] = true;
					array[x][y] = array[now[0]][now[1]] +1;
					queue.offer(new int[]{x, y});
				}
			}
		}
		return ;
	}
}
