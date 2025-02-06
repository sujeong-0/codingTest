package data_structure;

import java.util.Scanner;
import java.util.Stack;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/3/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/3/25        ggong       최초 생성
 */
public class 괄호 {
	public static void main1(String[] args) { // 그냥 덧셈으로 푼거
		Scanner sc    = new Scanner(System.in);
		int     count = sc.nextInt();

		for(int i = 0; i < count; i++) {
			int    value = 0;
			char[] str   = sc.next().toCharArray();
			for(char c : str) {
				value += c == '(' ? 1 : -1;
				if(value < 0) {
					break;
				}
			}
			System.out.println(value == 0? "YES" : "NO");
		}
	}
	public static void main(String[] args) {
		Scanner sc    = new Scanner(System.in);
		int     count = sc.nextInt();

		for(int i = 0; i < count; i++) {
			Stack<Integer> stack = new Stack<>();
			char[] str   = sc.next().toCharArray();
			boolean isBreak = false;
			for(char c : str) {
				if('(' == c) {
					stack.push(1);
				} else {
					if(stack.isEmpty()) {
						System.out.println("NO");
						isBreak = true;
						break;
					}
					stack.pop();
				}
			}
			if(!isBreak) {
				System.out.println(stack.isEmpty()? "YES" : "NO");
			}
		}
	}
}
