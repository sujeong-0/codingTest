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

/**
 * [문제 & 조건]
 * - 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * - 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * <p>
 * [입력]
 * - 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * - 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * <p>
 * [출력]
 * - 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 */
public class Q_11047_동전_0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		final int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		int[] coins = new int[N];

		for(int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(K >= coin) {
				coins[i] = coin;
			}
		}

		int answer = 0; // coin 개수

		for(int i = N - 1; i >= N || K > 0; i--) {
			int coin = coins[i];

			if(coin > 0 && K >= coin) { // while로 돌면서 하던 계산을 한번에
				answer += (K / coin);
				K = K % coin;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	public static void main1(String[] args) throws IOException { // 112ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		final int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		int[] coins = new int[N];

		for(int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(K >= coin) {
				coins[i] = coin;
			}
		}

		int answer = 0; // coin 개수
		int sum = 0; // 계산

		for(int i = N - 1; i >= N || sum != K; i--) {
			int coin = coins[i];

			while(coin > 0 && sum + coin <= K) {
				sum += coin;
				answer++;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
