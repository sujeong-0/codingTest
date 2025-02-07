package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
public class 나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberOfPokemons = Integer.parseInt(st.nextToken());
		int numberOfQuiz = Integer.parseInt(st.nextToken());


		HashMap<String, Integer> pokemonsString = new HashMap<>();
		HashMap<Integer, String> pokemonsNumber = new HashMap<>();

		for(int i = 0; i < numberOfPokemons; i++) {
			String name = br.readLine();
			int    number   = i + 1;
			pokemonsString.put(name, number);
			pokemonsNumber.put(number, name);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numberOfQuiz; i++) {
			String quiz = br.readLine();

			if(Character.isDigit(quiz.charAt(0))) {
				sb.append(pokemonsNumber.get(Integer.parseInt(quiz)));
			} else {
				sb.append(pokemonsString.get(quiz));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void main2(String[] args) {
		Scanner                  sc       = new Scanner(System.in);
		String[]                 counts   = sc.nextLine().split(" ");
		HashMap<String, Integer> pokemonsString = new HashMap<>();
		HashMap<Integer, String> pokemonsNumber = new HashMap<>();

		for(int i = 0; i < Integer.parseInt(counts[0]); i++) {
			String name = sc.nextLine();
			int    number   = i + 1;
			pokemonsString.put(name, number);
			pokemonsNumber.put(number, name);
		}

		for(int i = 0; i < Integer.parseInt(counts[1]); i++) {
			String quiz = sc.nextLine();

			if(quiz.matches("[0-9]+")) {
				System.out.println(pokemonsNumber.get(Integer.parseInt(quiz))); // 번호로 물어본 경우
				continue;
			}
			System.out.println(pokemonsString.get(quiz));// 이름으로 물어본 경우
		}
	}

	public static void main1(String[] args) { // 시간 초과
		Scanner      sc       = new Scanner(System.in);
		String[]     counts   = sc.nextLine().split(" ");
		List<String> pokemons = new ArrayList<>();
		pokemons.add("");

		for(int i = 0; i < Integer.parseInt(counts[0]); i++) {
			pokemons.add(sc.nextLine());
		}

		for(int i = 0; i < Integer.parseInt(counts[1]); i++) {
			String quiz = sc.nextLine();

			if(quiz.matches("[0-9]+")) {
				System.out.println(pokemons.get(Integer.parseInt(quiz))); // 번호로 물어본 경우
				continue;
			}
			System.out.println(pokemons.indexOf(quiz));// 이름으로 물어본 경우
		}
	}
}
