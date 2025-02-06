package string;

import java.util.Scanner;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/5/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/5/25        ggong       최초 생성
 */
public class 세로읽기 {
	public static void main(String[] args) {
		Scanner       sc    = new Scanner(System.in);
		String[]      array = new String[5];
		StringBuilder sb    = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			array[i] = sc.nextLine();
		}

		int i =0;
		for(int j = 0; j < array[i].length(); j++) {
			for(i = 0; i < array.length;i ++) {
				if(array[i].length() > j) {
					sb.append(array[i].charAt(j));
				}
			}i =0;
		}


		System.out.println(sb);

	}
	public static void main1(String[] args) {
		Scanner       sc    = new Scanner(System.in);
		String[]      array = new String[5];
		StringBuilder sb    = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			array[i] = (sc.nextLine() +"                      ").substring(0,15);
		}

		int i =0;
		for(int j = 0; j < array[i].length(); j++) {
			for(i = 0; i < array.length;i ++) {
				sb.append(array[i].charAt(j));
			}i =0;
		}


		System.out.println(sb.toString().replaceAll(" ",""));

	}

}
