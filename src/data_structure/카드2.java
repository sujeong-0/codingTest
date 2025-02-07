package data_structure;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
public class 카드2 {
	public static void main(String[] args) throws IOException {
		Scanner        sc        = new Scanner(System.in);
		int            cardCount = sc.nextInt();
		Queue<Integer> cards     = new LinkedList<>();
		for(int i = 1; i <= cardCount; i++) {
			cards.offer(i);
		}

		int count = 1;
		while(cards.size() > 1) {
			int card = cards.poll();

			if(count % 2 != 1) {
				cards.offer(card);
			}
			count++;
		}
		System.out.println(cards.poll());
	}
}
