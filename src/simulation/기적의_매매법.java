package simulation;

import java.util.Scanner;

/**
 * description    :
 * packageName    : simulation
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 기적의_매매법 {
	public static void main(String[] args) {
		int     DAY    = 14;
		Scanner sc     = new Scanner(System.in);
		int     money  = Integer.parseInt(sc.nextLine());
		int[]   prices = new int[DAY];

		int jMoney = money, sMoney = money;
		int jStock = 0, sStock = 0;

		for(int i = 0; i < DAY; i++) {
			prices[i] = sc.nextInt();
		}


		for(int i = 0; i < prices.length; i++) {
			int price = prices[i];

			// 준현이가 구매하는 방식
			if(jMoney / price > 0) {
				int buyStockCount = jMoney / price;
				jMoney = jMoney - price * buyStockCount;
				jStock += buyStockCount;
			}


			// 성민이가 구매하는 방식
			if(i < 3) {
				continue;
			}
			if(prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1]) { // 3일째 상승중 = 전량 매도
				sMoney += price * sStock;
				sStock = 0;

			}
			if(prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) { // 3일째 하락중 = 전량 구매
				int buyStockCount = sMoney / price;
				sMoney = sMoney - price * buyStockCount;
				sStock += buyStockCount;
			}

		}


		// 결과 출력
		int lastStockPrice = prices[prices.length - 1];
		int j              = lastStockPrice * jStock + jMoney;
		int s              = lastStockPrice * sStock + sMoney;
		System.out.println(j == s ? "SAMESAME" : j > s ? "BNP" : "TIMING");
	}
}
