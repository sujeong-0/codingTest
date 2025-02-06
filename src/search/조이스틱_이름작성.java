package search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * description    :
 * packageName    : search
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/2/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/2/25        ggong       최초 생성
 */
public class 조이스틱_이름작성 {
	public static void main(String[] args) {
		//		System.out.println(solution("JAZ") + " == 11 ");
		System.out.println(solution("JAZAAAAAAAAAA") + " == 12 ");
		//		System.out.println(solution("JAAZ") + " == 11 ");
		//		System.out.println(solution("JABAZ") + " == 15 ");
		//		System.out.println(solution("JEROEN") + " == 56 ");
		//		System.out.println(solution("JAN") + " == 23 ");
	}

	public static int solution(String name) {
		List<String> alphabet = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
		                                "Z");
		int      count = 0;
		int      i     = 0;
		char[]   write = new char[name.length()];
		String[] as    = name.split("[^A]");


		// 초기화
		for(int j = 0; j < write.length; j++) {
			write[i] = 'A';
		}


		while(name.equalsIgnoreCase(Arrays.toString(write))) {
			int index = alphabet.indexOf(name.charAt(i));
			count += alphabet.size() - index > index ? index : alphabet.size() - index; // 상하 조절
			write[i] = name.charAt(i);// 글씨 작성

			if(true) {
				i = i - 1 < 0 ? 0 : i - 1;
			} else { // 오른쪽으로 이동
				i = i + 1 > name.length() ? 0 : i + 1;
			}
			count++; // 좌우 이동
		}
		return count;

	}

	public static int solution1(String name) {
		List<String> alphabet = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
		                                "Z");

		int count = 0;

		for(String s : name.split("")) {
			int index = alphabet.indexOf(s);
			count += alphabet.size() - index > index ? index : alphabet.size() - index;
			count++; // 오른쪽으로 이동
		}
		count--;

		if(name.replaceAll("A{1,}", "A").split("A").length == 2) {
			count -= name.length() - name.replaceAll("A", "").length();
		}

		return count;
	}
}
