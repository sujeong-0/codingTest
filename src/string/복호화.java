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
public class 복호화 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     count = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < count; i++) {
			String origin = sc.nextLine().replaceAll(" ", "");
			String[] originArr = origin.split("");
			Map<String, Integer> data =new HashMap<>();
			for(String s : originArr) {
				data.put(s, data.getOrDefault(s, 0) + 1);
			}

			List<Map.Entry<String, Integer>> list = data.entrySet().stream().filter(x -> x.getValue() == data.values().stream().max(Comparator.comparingInt(y -> y))
			                                                                                                 .get()).collect(Collectors.toList());
			System.out.println(list.size()>1? "?":list.get(0).getKey());
		}
	}
}
