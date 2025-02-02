package data_structure;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/1/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/25        ggong       최초 생성
 */
public class 기능개발 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
		System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1,1,1,1,1,1})));
		System.out.println(Arrays.toString(solution(new int[]{95, 90}, new int[]{1,1})));
//		System.out.println(Arrays.toString(solution(new int[]{90, 95}, new int[]{1,1})));
//		System.out.println(Arrays.toString(solution(new int[]{10, 95}, new int[]{1,1})));
//		System.out.println(Arrays.toString(solution(new int[]{95, 95}, new int[]{4,1})));
		System.out.println(Arrays.toString(solution(new int[]{90, 90, 90}, new int[]{1,5,4})));
		System.out.println(Arrays.toString(solution(new int[]{95, 94, 93}, new int[]{3, 3, 3})));
		System.out.println(Arrays.toString(solution(new int[]{98, 99, 97, 98}, new int[]{1,1,1,1})));
		System.out.println(Arrays.toString(solution(new int[]{85, 80, 90, 85}, new int[]{5, 5, 5, 5})));
		System.out.println(Arrays.toString(solution(new int[]{95, 95, 95, 95}, new int[]{4, 3, 2, 1})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] days = new int[progresses.length];

		for(int i = 0; i < progresses.length; i++) {
			days[i] = (100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] != 0 ? 1 : 0);
		}

		List<Integer> result     = new ArrayList<>();
		int           release    = 0;
		int           max = days[0];
		for(int i = 0; i < days.length; i++) {
			release++;
			if(max<days[i]) {
				result.add(release-1);
				release = 1;
				max = days[i];
			}
			if(i == days.length-1) {
				result.add(release);
			}
		}


		int[] res = new int[result.size()];
		for(int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}

		return res;
	}
}
