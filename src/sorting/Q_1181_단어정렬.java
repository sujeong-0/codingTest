package sorting;

/**
 * description    :
 * packageName    : sorting
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/20/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/20/25        ggong       최초 생성
 */


import java.io.*;
import java.util.*;

/**
 *  길이가 짧은 것부터,  길이가 같으면 사전 순으로 정렬, 중복된 단어는 하나만 남기고 제거
 *
 *  [입력]
 *  - 첫째 줄에 단어의 개수 N(1 ≤ N ≤ 20,000)
 *  - 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진
 *  - 주어지는 문자열의 길이는 50을 넘지 않는다.
 *
 *  [출력]
 * - 정렬하여 단어들을 출력
 *
 */
public class Q_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count= Integer.parseInt(br.readLine());

		Set<String> data = new HashSet<>();

		for(int i = 0; i < count; i++) {
			data.add(br.readLine());
		}

		List<String> array =new LinkedList<>(data);
		Collections.sort(array, ((o1, o2) -> {
						if(o1.length() == o2.length()) {
							return o1.compareTo(o2);
						}
						return o1.length() - o2.length();
					}));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0; i < array.size(); i++) {
			bw.write(array.get(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
