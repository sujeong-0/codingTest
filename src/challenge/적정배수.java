package challenge;

/**
 * description    :
 * packageName    : challenge
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/5/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/5/25        ggong       최초 생성
 */
public class 적정배수 {
	public static void main(String[] args) {
		printSolution(22, 9);
		printSolution(25, 15);
		printSolution(222, 7);
		printSolution(1, 999999967);
		printSolution(987654321, 1000000007);
		printSolution(77, 999983);
		printSolution(1, 99999);
		printSolution(555, 99999);
		printSolution(711  , 51);
	}

	public static void printSolution(int a, int b) {
		long startTime = System.nanoTime(); // ⏱️ 실행 시작 시간

		int result = solution(a, b); // ✅ 함수 실행 및 결과 저장

		long endTime = System.nanoTime(); // ⏱️ 실행 종료 시간
		long elapsedTime = endTime - startTime; // 실행 시간 계산

		// 🖨️ 결과 출력
		System.out.println("solution(" + a + ", " + b + ") = " + result
				                   + " (Execution time: " + elapsedTime + " ns)");
	}

	public static int solution(int n, int k) {
		int answer = 1;
		int nSize = String.valueOf(n).length() ;

		long number = n;
		long nextNumber = nextNum(number, nSize, n);
		while(number % k !=0 ) {
			number = nextNumber;
			nextNumber = nextNum(nextNumber, nSize, n);
			answer++;
			if(number <= 0 || (k > number &&  nextNumber <=0)) {
				return -1;
			}
		}
		return answer;

	}

	private static long nextNum(long number, int nSize, int n) {
		return number * ((long) Math.pow (10 , nSize))+ n;
	}
	public static int solution1(int n, int k) {
		int answer = 1;

		String str = String.valueOf(n);
		StringBuilder temp = new StringBuilder(str);
		while(Long.valueOf(String.valueOf(temp)) % k != 0) {
			temp.append(str);
			answer++;
		}

		return answer;
	}
}
