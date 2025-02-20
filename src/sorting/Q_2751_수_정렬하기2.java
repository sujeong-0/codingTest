package sorting;

import java.io.*;
import java.util.Arrays;

/**
 * description    :
 * packageName    : basic_math
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */
public class Q_2751_수_정렬하기2 {
	public static void main(String[] args) throws IOException { // 병합정렬
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		BufferedWriter bw    = new BufferedWriter(new OutputStreamWriter(System.out));
		int[]          a     = new int[count];
		for(int i = 0; i < count; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		a = sort(a);

		for(int i = 0; i < count; i++) {
			bw.write(String.valueOf(a[i]));
			bw.newLine();
		}


		bw.flush();
		bw.close();
	}

	private static int[] sort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}


		int l = arr.length / 2;
		int[] lArr = sort(Arrays.copyOfRange(arr, 0, l));
		int[] rArr = sort(Arrays.copyOfRange(arr, l, arr.length));
		int[] newArr = new int[arr.length];

		int i = 0, j = 0;

		for(int k = 0; k < newArr.length; k++) {
			if(j == rArr.length) {
				newArr[k] = lArr[i++];
				continue;
			} else if(i == lArr.length) {
				newArr[k] = rArr[j++];
				continue;
			}
			if(rArr[j] < lArr[i]) {
				newArr[k] = rArr[j++];
			} else {
				newArr[k] = lArr[i++];
			}

		}
		return newArr;
	}
}
