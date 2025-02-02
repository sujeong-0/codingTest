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
public class 의상 {
	public static void main(String[] args) {

		System.out.println(
				solution(new String[][]{new String[]{"yellow_hat", "headgear"}, new String[]{"blue_sunglasses", "eyewear"}, new String[]{"green_turban", "headgear"}}));
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> types = new HashMap<>();
		for(String[] clothe : clothes) {
			types.put(clothe[1], types.getOrDefault(clothe[1], 0) + 1);
		}

		int result = 1;
		for(Integer value : types.values()) {
			result = result * (value +1);
		}
		result -= 1;
		return result;

	}
}
