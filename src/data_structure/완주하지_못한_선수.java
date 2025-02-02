package data_structure;

import java.util.HashMap;

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
public class 완주하지_못한_선수 {

	public static void main(String[] args) {
		//		System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
		System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> count = new HashMap();
		for(String s : participant) {
			count.put(s, count.getOrDefault(s, 0) + 1);
		}
		for(String s : completion) {
			count.put(s, count.get(s)-1);
		}
		return count.entrySet().stream().filter(e -> e.getValue()>0).findFirst().get().getKey();

	}
}
