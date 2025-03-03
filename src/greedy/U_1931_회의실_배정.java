package greedy;

/**
 * description    :
 * packageName    : greedy
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 3/3/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/3/25        ggong       최초 생성
 */


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [문제 & 조건]
 * - 1개의 회의실이 있어, N개의 회의에 대한 회의실 사용표를 만들려고 한다.
 * - 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * - 단, 회의는 한번 시작하면 중간에 중단될 수 없고, 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.(=회의 시작과 끝이 같은 경우)
 * <p>
 * [입력]
 * - 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * - 둘째 줄부터 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * - 시작 시간, 끝나는 시간의 범위: 2^31-1 보다 작거나 같음 또는 0
 *
 * <p>
 * [출력]
 * - 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 */
public class U_1931_회의실_배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		PriorityQueue<int[]> sortedStart = new PriorityQueue<>(((o1, o2) -> {
			if(o1[0] != o2[0]) {
				return o1[0] - o2[0];
			}

			if(o1[2] != o2[2]) {
				return o1[2] - o2[2];
			}
			return o1[1] - o2[1];
		}));
		PriorityQueue<int[]> sortedTime = new PriorityQueue<>(((o1, o2) -> {
			if(o1[2] != o2[2]) {
				return o1[2] - o2[2];
			}

			if(o1[0] != o2[0]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		}));
		int[][] timeTable = new int[N][];
		int[][] ignoreTimes = new int[N][];
		int finalEndTime = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			int time = endTime - startTime;

			if(finalEndTime < endTime) {
				finalEndTime = endTime;
			}

			int[] times = {startTime, endTime, time};
			timeTable[i] = times;

			sortedStart.add(times);
			sortedTime.add(times);
		}


		// 시작 시간이 같다면, 종료시간이 긴 것은 무시
		int[] prevTimes = null;
		int j = 0;
		while(!sortedStart.isEmpty()) {
			int[] times = sortedStart.poll();
			if(prevTimes == null) {
				prevTimes = times;
				continue;
			}

			if(prevTimes[0] == times[0]) {
				ignoreTimes[j++] = times;
			}
		}

		int answer = 0;
		boolean[] time = new boolean[finalEndTime+1];
		while(!sortedTime.isEmpty()) {
			int[] poll = sortedTime.poll();
			boolean isIgnore = false;
			for(int i = 0; i < j || isIgnore; i++) {
				isIgnore = ignoreTimes[i] == poll;
			}

			if(isIgnore) {
				continue;
			}

			boolean isNotOk = false;
			for(int i = poll[0]; i < poll[1]; i++) {
				isNotOk = time[i] == true;
				if(isNotOk) { break;}
			}

			if(isNotOk) {continue;}
			for(int i = poll[0]; i < poll[1] || isNotOk; i++) {
				time[i] = true;
			}

			answer++;
		}


		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
