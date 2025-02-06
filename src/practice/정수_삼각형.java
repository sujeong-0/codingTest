package practice;

import java.util.Arrays;

/**
 * description    :
 * packageName    : practice
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/2/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/2/25        ggong       최초 생성
 */
public class 정수_삼각형 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}) + " == 30");
	}

	public static int solution(int[][] triangle) {
		for(int i = 1; i < triangle.length; i++) {
			triangle[i][0] = triangle[i][0] + triangle[i - 1][0];
			triangle[i][triangle[i].length - 1] = triangle[i][triangle[i].length - 1] + triangle[i - 1][triangle[i].length - 2];
			for(int j = 1; j < triangle[i].length - 1; j++) {
				triangle[i][j] = triangle[i][j] + (triangle[i - 1][j - 1] > triangle[i - 1][j] ? triangle[i - 1][j - 1] : triangle[i - 1][j]);
			}
		}
		return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
	}
}
