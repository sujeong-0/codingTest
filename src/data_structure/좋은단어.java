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
public class 좋은단어 {
	public static void main(String[] args) {
		Scanner          sc            = new Scanner(System.in);
		int              wordCount     = sc.nextInt();
		int              goodWordCount =0;
		Stack<Character> stack         = new Stack<>();
		sc.nextLine();
		for(int i = 0; i < wordCount; i++) {
			String word = sc.nextLine();

			for(char c : word.toCharArray()) {
				if(stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
					continue;
				}
				if(stack.peek() == c) {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				goodWordCount++;
			}
			stack.clear();
		}
		System.out.println(goodWordCount);
	}
}
