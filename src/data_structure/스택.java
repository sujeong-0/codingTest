package data_structure;

import java.util.Scanner;
import java.util.Stack;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 스택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		int commandCount = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < commandCount; i++) {
			String command = sc.nextLine();
			if(command.startsWith("push ")) {
				stack.push(command.split(" ")[1]);
				continue;
			}
			switch(command) {
				case "top" -> {
					System.out.println(stack.isEmpty()? "-1":stack.peek());
				}
				case "size" -> {
					System.out.println(stack.size());
				}
				case "pop" -> {
					System.out.println(stack.isEmpty()? "-1":stack.pop());
				}
				case "empty" -> {
					System.out.println(stack.isEmpty()? "1":"0");
				}
			}
		}
	}
}
