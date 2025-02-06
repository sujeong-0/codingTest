package string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/5/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/5/25        ggong       최초 생성
 */
public class 단어공부 {
	public static void main(String[] args) {
		Scanner sc     = new Scanner(System.in);
		String  origin = sc.nextLine().replaceAll(" ", "");

		if(origin.equals("")) {
			System.out.println("?");
		}
		String[]             originArr = origin.split("");
		Map<String, Integer> data      = new HashMap<>();
		for(String s : originArr) {
			data.put(s.toUpperCase(), data.getOrDefault(s.toUpperCase(), 0) + 1);
		}
		int          max  = data.values().stream().max(Comparator.comparingInt(y -> y)).get();
		List<String> list = data.entrySet().stream().filter(x -> x.getValue() == max).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println(list.size() == 1 ? list.get(0) : "?");
	}
}
