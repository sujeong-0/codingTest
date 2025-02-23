package data_structure;

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

import java.io.*;
import java.util.Stack;

/**
 * [조건]
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 *
 * [입력]
 * - 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * - 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 *
 * [출력]
 * - 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력
 */
public class Q_28278_스택2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		Stack<String> stack = new Stack<>();


		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			String command = br.readLine();

			if(command.startsWith("1 ")) {
				stack.push(command.split(" ")[1]);
				continue;
			}
			switch(command) {
				case "2":
					sb.append(stack.isEmpty() ? "-1" : stack.pop());
					break;
				case "3":
					sb.append(stack.size());
					break;
				case "4":
					sb.append(stack.isEmpty()? "1":"0");
					break;
				case "5":
					sb.append(stack.isEmpty()? "-1":stack.peek());
					break;
			}
			sb.append("\n");
		}
		sb.replace(sb.length() - 1, sb.length(), "");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
