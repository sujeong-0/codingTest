package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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
public class 전구 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] lights = new int[sc.nextInt()];
		int   commandCount      = sc.nextInt();
		sc.nextLine();


		String[] lightStr = sc.nextLine().split(" ");
		for(int i = 0; i < lights.length; i++) {
			lights[i] = Integer.parseInt(lightStr[i]);
		}

		for(int i = 0; i < commandCount; i++) {
			String[] s  = sc.nextLine().split(" ");
			int command = Integer.parseInt(s[0]);
			int l = Integer.parseInt(s[1]) -1 ;
			int r = Integer.parseInt(s[2]) -1;

			switch(command) {
				case 1:
					lights[l] = r+1;
					break;
				case 2:
					for(int j = l; j <= r; j++) {
						lights[j] = Math.abs(lights[j] - 1);
					}
					break;
				case 3:
					for(int j = l; j <= r; j++) {
						lights[j] = 0;
					}
					break;
				case 4:
					for(int j = l; j <= r; j++) {
						lights[j] = 1;
					}
					break;
			}
		}
		for(int i = 0; i < lights.length; i++) {
			System.out.print(lights[i] + (i != lights.length - 1 ? " " : ""));
		}

	}
}
