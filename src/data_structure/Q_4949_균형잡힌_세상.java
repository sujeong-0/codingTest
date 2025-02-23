package data_structure;

import java.io.*;
import java.util.Stack;

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
public class Q_4949_균형잡힌_세상 {
	public static void main(String[] args) throws IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		String         line = "";
		boolean        isOk = true;

		Stack<Character> stack = new Stack<>();
		StringBuilder    sb    = new StringBuilder();
		while(!(line = br.readLine()).equals(".")) {
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '.') {
					break;
				}
				if(line.charAt(i) == '[' || line.charAt(i) == '(') {
					stack.push(line.charAt(i));
				}

				if(line.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						isOk = false;
						break;
					}
					stack.pop();
				}

				if(line.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						isOk = false;
						break;
					}
					stack.pop();
				}
			}
			sb.append(isOk && stack.isEmpty()? "yes\n" : "no\n");
			isOk = true;
			stack.clear();
		}
		sb.replace(sb.length() - 1, sb.length(), "");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
