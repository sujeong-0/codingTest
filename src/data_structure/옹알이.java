package data_structure;

import java.util.Arrays;

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
public class 옹알이 {
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}) + " == 1");
		System.out.println(solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}) + " == 3");
	}

	public static int solution(String[] babbling) {
		String[] possibleWord = new String[]{"aya", "ye", "woo", "ma"};
		return (int) Arrays.stream(babbling)
				.filter(x -> x.replaceAll("[ayewom]", "").isEmpty())
				.map(temp ->{
					for(String s : possibleWord) {
						if(temp.equals("")) {break;}
						temp = temp.replaceAll(s, "_");
					}
					return temp;
				}).filter(x -> x.replaceAll("_", "").isEmpty())
				.count();
	}
	public static int solution1(String[] babbling) {
		String[] possibleWord = new String[]{"aya", "ye", "woo", "ma"};

		int count = 0;
		for(String word : babbling) {
			if(word.replaceAll("[ayewom]", "").length() > 0) {
				continue;
			}

			String temp = word;
			for(String s : possibleWord) {
				if(temp.equals("")) {break;}
				temp = temp.replaceAll(s, "_");
			}
			if(temp.replaceAll("_", "").length() == 0) {
				count++;
			}
		}
		return count;

	}
}
