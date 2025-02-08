package basic_math;

import java.util.Scanner;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/7/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/7/25        ggong       최초 생성
 */
public class 공약수 {
	public static void main(String[] args) {
		Scanner sc    = new Scanner(System.in);
		int     count = Integer.parseInt(sc.nextLine());

		int[] arr = new int[count];
		int   min = Integer.MAX_VALUE;
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
			if(min > arr[i]) {
				min = arr[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= min; i++) {
			boolean isOk = true;
			for(int j = 0; j < count; j++) {
				if(arr[j] % i != 0) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb);

	}
	public static void main1(String[] args) {
		Scanner sc    = new Scanner(System.in);
		int     count = Integer.parseInt(sc.nextLine());

		int[] arr = new int[count];
		int   min = Integer.MAX_VALUE;
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
			if(min > arr[i]) {
				min = arr[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= min; i++) {
			boolean isOk = true;
			for(int j = 0; j < count; j++) {
				if(arr[j] % i != 0) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb);

	}
}
