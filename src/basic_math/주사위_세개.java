package basic_math;

import java.io.*;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/14/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/14/25        ggong       최초 생성
 */
public class 주사위_세개 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]       st = br.readLine().split(" ");

		int dice1 = Integer.parseInt(st[0]);
		int dice2 = Integer.parseInt(st[1]);
		int dice3 = Integer.parseInt(st[2]);

		int money = 0;

		if(dice1 == dice2 && dice2 == dice3) {
			money = 10000 + dice1 * 1000;
		} else if(dice1 == dice2 || dice2 == dice3 || dice1 == dice3) {
			if(dice1 == dice2 || dice2 == dice3) {
				money = 1000 + dice2 * 100;
			} else {
				money = 1000 + dice1 * 100;
			}
		} else if(dice1 != dice2 && dice2 != dice3 && dice1 != dice3) {
			int max = dice1;
			if(max < dice2) {
				max = dice2;
			}
			if(max < dice3) {
				max = dice3;
			}

			money = max * 100;
		}


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(money));
		bw.flush();
		bw.close();

	}
}
