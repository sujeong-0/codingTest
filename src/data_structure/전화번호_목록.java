package data_structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 1/31/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/25        ggong       최초 생성
 */
public class 전화번호_목록 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
		System.out.println(solution(new String[]{"123", "456", "789"}));
		System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
	}

	public static boolean solution1(String[] phone_book) {
		return !Arrays.stream(phone_book).anyMatch(x -> Arrays.stream(phone_book).anyMatch(y -> !x.equals(y) && y.startsWith(x)));
	}

	public static boolean solution(String[] phone_book) {
		HashSet<String> phone_books = new HashSet<>(List.of(phone_book));
		boolean         exist       = false;
		for(String p : phone_books) {
			for(int i = 0; i < p.length(); i++) {
				exist = phone_books.contains(p.substring(0, i));
				if(exist) {
					break;
				}
			}
			if(exist) {
				break;
			}
		}
		return exist;
	}
}
