package data_structure;

import java.io.*;
import java.util.*;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/23/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/23/25        ggong       최초 생성
 */

public class Q_24511_queuestack {
	public static void main(String[] args) throws IOException {
		BufferedReader br          = new BufferedReader(new InputStreamReader(System.in));

		String[] qStack = new String[Integer.parseInt(br.readLine())];

		StringTokenizer st       = new StringTokenizer(br.readLine());
		for(int i = 0; i < qStack.length; i++) {
			qStack[i] =st.nextToken();
		}

		st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i = 0; i < qStack.length; i++) {
			String num = st.nextToken();
			if(qStack[i].equals("0")) {
				list.add(num);
			}
		}
		Collections.reverse(list);


		Queue<String> queue = new LinkedList<>(list);
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < input; i++) {
			queue.add(st.nextToken());

			sb.append(queue.poll()).append("\n");
		}

		sb.replace(sb.length() - 1, sb.length(), "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void main1(String[] args) throws IOException {// 시간 초과
		BufferedReader br          = new BufferedReader(new InputStreamReader(System.in));
		int            qStackCount = Integer.parseInt(br.readLine());

		int[] qStack = new int[qStackCount];
		int[] data   = new int[qStackCount];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < qStackCount; i++) {
			int num = Integer.parseInt(st.nextToken());
			qStack[i] = num;
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < qStackCount; i++) {
			int num = Integer.parseInt(st.nextToken());
			data[i] = num;
		}


		int inputCount = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < inputCount; i++) {
			final int num = Integer.parseInt(st.nextToken());

			int prev   = data[0];
			int number = num;
			for(int j = 0; j < qStack.length; j++) {
				prev = data[j];
				if(qStack[j] == 0) {// 스택
					data[j] = number;
					number = prev;
				}
			}
			sb.append(number).append("\n");
		}
		sb.replace(sb.length() - 1, sb.length(), "");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
