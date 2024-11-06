package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * description    :
 *  - 구현해야 하는 것 : 철수가 빙고를 외친 시점이, 사회자가 숫자를 몇번 외쳤을 때 인지
 *  - 입출력 조건 : 입력은 string 으로 추청, 출력은 int로 추정
 *  - 빙고판의 수는 자연수로 이루어져 있음
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 4.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 4.        ggong       최초 생성
 */
class Solution{
	public int solution(String inputData) {
		int count = 0; // 철수가 빙고를 외친 시점이, 사회자가 숫자를 몇번 외쳤을 때 인지
		int BINGGO_SIZE = 5;

		String[] lines = inputData.split("\n");

		List<List<String>> binggoBoard = Arrays.stream(lines, 0, BINGGO_SIZE)
		                                .map(line -> Arrays.stream(line.split(" "))
		                                                   .toList())
		                                .toList();

		List<List<String>> answers = Arrays.stream(lines, BINGGO_SIZE, lines.length)
		                                .map(line -> Arrays.stream(line.split(" "))
		                                                   .toList())
		                                .toList();

		boolean[][] check = new boolean[BINGGO_SIZE][BINGGO_SIZE];


		//사회자가 정답을 부르기 시작함
		for (List<String> answerLine : answers) {
			for (String answer : answerLine) {
				count++;

				// 정답을 빙고판에 표시함
				for (int i = 0; i <binggoBoard.size(); i++) {
					if (binggoBoard.get(i).contains(answer)) {
						int j = binggoBoard.get(i).indexOf(answer);

						check[i][j] = true;

						// 빙고가 된게 있는지 확인함


					}
				}
			}
		}


		return count;
	}

	public boolean checkBinggo(boolean[][]  binggoBoard,int binggoCount){

	/*	for (int i = 0; i < binggoBoard.length; i++) {
			for (int j = 0; j < binggoBoard[i].length; j++) {
				if (binggoBoard[i][j] == true && )
			}
		}
*/
		return false;
	}
}

public class 빙고 {

	public static void main(String[] args) {
		Solution s = new Solution();

		String testData = "11 12 2 24 10\n" + "16 1 13 3 25\n" + "6 20 5 21 17\n" + "19 4 8 14 9\n" + "22 15 7 23 18\n" + "5 10 7 16 2\n" + "4 22 8 17 13\n" + "3 18 1 6 25\n" + "12 19 23 14 21\n" + "11 24 9 20 15";

		System.out.println(s.solution(testData));
	}
}
