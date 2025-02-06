package challenge;

import java.util.*;
import java.util.stream.Collectors;

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
public class 전기충전기 {
	public static void main(String[] args) {
//		//		System.out.println(solution(3,8,new int[]{5,7,2,3,3,6,4,3}));
//		System.out.println(solution(4, 10, new int[]{1, 6, 7, 2, 1, 10, 3, 5, 2, 3}));
//		// 🚨 반례 테스트 케이스
//		System.out.println("Test Case 2 (충전소 재사용 문제): " + Arrays.toString(solution(2, 3, new int[]{3, 2, 1})));
//		System.out.println("Test Case 3 (음수 발생 가능성): " + Arrays.toString(solution(1, 2, new int[]{1, 1})));
//		System.out.println("Test Case 4 (시간 흐름 문제): " + Arrays.toString(solution(3, 5, new int[]{5, 3, 2, 4, 1})));
//
//		// 🚨 추가적인 반례 테스트
//		System.out.println("Test Case 5 (N=1, K=5, 작은 충전소에서 여러 대 차량 대기): " + Arrays.toString(solution(1, 5, new int[]{2, 2, 2, 2, 2})));
//		System.out.println("Test Case 6 (N=3, K=6, 충전 시간 길고 큰 값): " + Arrays.toString(solution(3, 6, new int[]{10, 15, 20, 5, 3, 2})));
//		System.out.println("Test Case 7 (N=5, K=10, 충전소 개수보다 차량 많음): " + Arrays.toString(solution(5, 10, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1})));

		System.out.println(solution(2, 5, new int[]{100, 200, 300, 400, 500}));
		System.out.println(solution(3, 6, new int[]{1, 1, 1, 1, 1, 1}));
		System.out.println(solution(1, 10, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
	}


	/**
	 * @param N       충전기 개수
	 * @param K       진구의 순서
	 * @param charges 대기중인 차량들의 소요 시간
	 * @return 진구가 충전하게 될 충전기 번호와 충전을 마치게 될 시간
	 */
	public static int[] solution(int N, int K, int[] charges) {
		Map<Integer, Integer> chargers            = new HashMap<>(N); //충전기 번호
		Queue<Integer>        emptyChargerNumbers = new PriorityQueue<>(Comparator.comparingInt(x -> x));// 현재 비어있는 충전기 번호만 관리
		for(int i = 1; i <= N; i++) {
			chargers.put(i, 0);
			emptyChargerNumbers.add(i);
		}
		int[] answer = new int[2];


		int i    = 0;
		int time = 0;
		while(i < K) {
			// 1. 차량 도착시, 비어있는 충전소가 있는지 확인해야함
			if(emptyChargerNumbers.isEmpty()) {
				for(Integer key : chargers.keySet()) {// 모두 사용중이면 시간이 흐름
					int value = chargers.get(key) - 1;
					if(value == 0) {
						emptyChargerNumbers.add(key);
					}
					chargers.put(key, value);
				}
				time++;
				continue;
			}

			// 2. 비어있는 충전소를 찾으면 번호를 확인함
			while(!emptyChargerNumbers.isEmpty())
			{
				int emptyChargerNumber = emptyChargerNumbers.poll();

				// 3. 비어있는 충전소로 해당 차량이 이동해 충전해야함
				chargers.put(emptyChargerNumber, charges[i]);
				if(i == K - 1) {
					answer[0] = emptyChargerNumber;
					answer[1] = time + charges[i];
					System.out.println(answer[0]);
					System.out.println(answer[1]);
				}
				i++;
			}

		}

		return answer;
	}

	/**
	 * @param N       충전기 개수
	 * @param K       진구의 순서
	 * @param charges 대기중인 차량들의 소요 시간
	 * @return 진구가 충전하게 될 충전기 번호와 충전을 마치게 될 시간
	 */
	public static int[] solution1(int N, int K, int[] charges) {

		Map<Integer, Integer> chargers = new HashMap<>(N);
		for(int i = 1; i <= N; i++) {
			chargers.put(i, 0);
		}
		int[] answer = new int[2];

		int i    = 0;
		int time = 0;
		while(i < charges.length) {
			// 1. 차량 도착시, 비어있는 충전소가 있는지 확인해야함
			List<Map.Entry<Integer, Integer>> emptyChargers =
					chargers.entrySet().stream().filter(x -> x.getValue() == 0).sorted(Comparator.comparingInt(x -> x.getKey()))
			                                                          .collect(Collectors.toList());
			if(emptyChargers.isEmpty()) {// 모두 사용중이면 시간이 흐름
				for(Integer key : chargers.keySet()) { //
					chargers.put(key, chargers.get(key) - 1);
				}
				time++;
				continue;
			}

			// 2. 비어있는 충전소를 찾으면 번호를 확인함
			for(Map.Entry<Integer, Integer> emptyCharger : emptyChargers) {
				int emptyChargerNumber = emptyCharger.getKey();

				// 3. 비어있는 충전소로 해당 차량이 이동해 충전해야함
				chargers.put(emptyChargerNumber, charges[i]);
				if(i == K - 1) {
					answer[0] = emptyChargerNumber;
					answer[1] = time + charges[i];
				}
				i++;
			}

		}

		return answer;


	}
}
