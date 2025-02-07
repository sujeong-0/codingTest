package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * description    :
 * packageName    : string
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/6/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/6/25        ggong       최초 생성
 */
public class 영단어_암기는_괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int wordCount = Integer.parseInt(st.nextToken());
		int wordLength = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> words = new HashMap<>();

		for(int i = 0; i < wordCount; i++) {
			String word = br.readLine();
			if(word.length() >= wordLength) {
//				words.put(word, words.getOrDefault(word, 0) + 1);
				words.compute(word, (k, v) -> (v == null) ? 0 : v + 1);
			}
		}


		List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(words.entrySet());
		sortedWords.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
		                           .thenComparing((Map.Entry<String, Integer> x) -> x.getKey().length(),  Comparator.reverseOrder()).thenComparing(Map.Entry ::getKey));

		for(Map.Entry<String, Integer> s : sortedWords) {
			System.out.println(s.getKey());
		}


	}
	public static void main1(String[] args) { // 시간 초과 ( 1초 제한)
		Scanner sc = new Scanner(System.in);

		int wordCount  = sc.nextInt();
		int wordLength = sc.nextInt();
		sc.nextLine();

		HashMap<String, Integer> words = new HashMap<>();

		for(int i = 0; i < wordCount; i++) {
			String word = sc.nextLine();
			if(word.length() >= wordLength) {
				words.put(word, words.getOrDefault(word, 0) + 1);
			}
		}
		words.entrySet().stream().sorted(Comparator.comparingInt((Map.Entry<String, Integer> x) -> -x.getValue())
		                                           .thenComparingInt((Map.Entry<String, Integer> x) -> -x.getKey().length()).thenComparing(x -> x.getKey())).map(x->x.getKey()).forEach(
				System.out :: println);
	}
}
