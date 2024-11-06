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
//todo N개의 숫자가 공백없이 써있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
// - 입력 : 1번쨰 줄에 숫자의 개수 N, 2번쨰 줄에 숫자 N개가 공백없이 주어진다.
// - 출력 : 입력으로 주어진 숫자 N개의 값을 출력한다.
// - N의 범위 : 1 ~ 100 -> int와 long형으로 받을 수 없음
public class 숫자의_합_구하기 {
	public static void main(String[] args) {
		 System.out.println(sumNumber(5,"12345"));
	}

	public static long sumNumber(long count, String number) {
		long answer = 0 ;
		char[] numbers = String.valueOf(number).toCharArray();

		for (char c : numbers) {
			//			answer+= Long.parseLong(String.valueOf(c)); 아스키코드를 이용해서 변환하면 됨
			answer += c-'0'; // 혹은 c-48
		}

		return answer;
	}
}
