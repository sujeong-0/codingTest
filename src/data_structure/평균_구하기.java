package data_structure;

/**
 * description    : do it 코딩테스트 - 배열과 리스트
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 5.        ggong       최초 생성
 */
//todo 세준이가 성적을 고쳤을때 새로운 성적의 평균을 구하는 프로그램을 작성하시오.
// - 입력: 1번쨰 줄에 시험본 과목의 개수 N ( N <= 1,000 )  / 2번째 줄에 세준이의 현재 성적 M ( 0 <= M <= 100 )
// - 출력: 1번째 줄에 새로운 평균을 출력, 실제 정답과 출력값의 절대오차 또는 상대오차는 10^-2 이하일 것
public class 평균_구하기 {
	public static void main(String[] args) {
		System.out.println(solution_ver1("3\n40 80 60"));
		System.out.println(solution_ver1("3\n10 20 30"));
		System.out.println(solution_ver1("4\n1 100 100 100"));
		System.out.println(solution_ver1("5\n1 2 4 8 16"));
		System.out.println(solution_ver1("2\n3 10"));
		System.out.println("====");
		System.out.println(solution_ver2("3\n40 80 60"));
		System.out.println(solution_ver2("3\n10 20 30"));
		System.out.println(solution_ver2("4\n1 100 100 100"));
		System.out.println(solution_ver2("5\n1 2 4 8 16"));
		System.out.println(solution_ver2("2\n3 10"));

	}

	public static double solution_ver2(final String report) {
		// 내용을 수학적으로 정리하자면, 점수가 a,b,c 3개였을 떄
		// (a / M * 100 + b / M * 100 + c / M * 100 ) / 3 인데,
		// 이 식은 (a + b + c) * 100 / M / 3 이고,
		//   =  ( 성적의 합 ) * 100 / 성적의 최댓값 / 과목수


		final int COUNT = Integer.parseInt(report.split("\n")[0].trim()); // 과목 수
		String[] scores = report.split("\n")[1].split(" ");

		// 1. M과 과목의 합 구하기
		double M = 0.0, sum = 0.0;
		for (int i = 0; i < COUNT; i++) {
			double score = Double.parseDouble(scores[i]);// 성적표
			if (M < score) {
				M = score;
			}
			sum += score;
		}

		// 2. 정리된 식으로 계산하기
		return sum * 100 / M / COUNT;
	}

	public static double solution_ver1(final String report) {
		final int COUNT = Integer.parseInt(report.split("\n")[0].trim()); // 과목 수
		double[] scores = new double[COUNT];// 성적표
		double[] newScores = new double[COUNT];// 새 성적표

		String[] scoresStr = report.split("\n")[1].split(" ");

		for (int i = 0; i < COUNT; i++) {
			scores[i] = Double.parseDouble(scoresStr[i]);
		}


		// 1. 실제 성적 중 최댓값을 구할 것 = M
		/*int M = Arrays.stream(report.split("\n")[1].split(" "))
		              .map(Integer::parseInt)
		              .max(Integer::compareTo)
				.get();*/

		// 1-1. 실제 성적 정렬
		for (int i = 0; i < COUNT; i++) {
			for (int j = i +1; j < COUNT; j++) {
				if(scores[i] < scores[j]){
					double temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;
				}
			}
		}

		// 1-2. M 구하기
		double M = scores[0];



		// 2. 점수 / 최댓값(M) * 100 으로 성적을 변경할 것
		for (int i = 0; i < COUNT; i++) {
			newScores[i] =  scores[i] / M * 100;
		}


		// 3. 새로운 성적의 평균을 구할 것
		double sum = 0;
		for (int i = 0; i < COUNT; i++) {
			sum += newScores[i];
		}
		return sum / COUNT;
	}
}
