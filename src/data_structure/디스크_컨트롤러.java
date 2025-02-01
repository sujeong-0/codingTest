package data_structure;

import java.util.*;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 25. 2. 1.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 1.        ggong       최초 생성
 */
public class 디스크_컨트롤러 {
	public static void main(String[] args) {

				System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
//		System.out.println(solution(new int[][]{{0, 3}, {1, 17}, {3, 8}}));
	}

	public static int solution(int[][] jobs) {
		int time = 0;
		int workEndTime = 0;
		int result = 0;
		boolean isWorking = false;
		int[] nowJob = new int[]{};
		int endWorkCount = 0;


		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] job) -> job[1]).thenComparingInt((int[] job) -> job[0]));

		while (true) {
			if (jobs.length == endWorkCount) { // 모든 작업을 다 했다면
				break;
			}
			for (int[] jobRequest : jobs) {
				if (jobRequest[0] == time) { // 요청시간이 현재시간이라면, queue에 삽입
					q.add(jobRequest);
//					System.out.println(time+" : "+jobRequest[0]+ "초에 작업요청이 들어와 queue 추가");
				}
			}
			//작업이 끝났다면
			if (isWorking && workEndTime == time) {
				result += time - nowJob[0];
				isWorking = false;
				endWorkCount++;
//				System.out.println(time+" : "+nowJob[0]+ "초에 들어온 작업 종료 | 완료 작업 개수: "+ endWorkCount + "반환 시간 : "+  (time - nowJob[0]));
			}

			// 작업 시작
			if (!isWorking && !q.isEmpty()) {
				nowJob = q.poll();
				workEndTime = time + nowJob[1];
				isWorking = true;
//				System.out.println(time+" : "+nowJob[0]+ "초에 들어온 작업 시작 | 작업 소요시간 : "+ nowJob[1]);
			}


//			System.out.println(time);
			time++;
		}


		return result / jobs.length;

	}
}
