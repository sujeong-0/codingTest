package string;

import java.util.*;
import java.util.stream.Collectors;

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
public class 듣보잡 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     noSeeCount  = sc.nextInt();
		int     noListenCount  = sc.nextInt();
		sc.nextLine();

		Map<String, Integer> data = new HashMap<>();
		for(int i = 0; i < noListenCount + noSeeCount; i++) {
			String s = sc.nextLine();
			data.put(s, data.getOrDefault(s, 0) + 1);
		}

		List<String> noSeeListen = data.entrySet().stream().filter(x -> x.getValue() == 2).map(x -> x.getKey()).sorted().collect(Collectors.toList());

		System.out.println(noSeeListen.size());
		for(String s : noSeeListen) {
			System.out.println(s);
		}
	}
	public static void main1(String[] args) { // 효율성이 안좋음
		Scanner sc = new Scanner(System.in);
		int     noSeeCount  = sc.nextInt();
		int     noListenCount  = sc.nextInt();
		sc.nextLine();
		List<String> noSee = new ArrayList<>(noSeeCount);
		List<String> noSeeListen = new ArrayList<>(noSeeCount);

		for(int i = 0; i < noSeeCount; i++) {
			noSee.add(sc.nextLine());
		}
		for(int i = 0; i < noListenCount; i++) {
			String noListen = sc.nextLine();
			if(noSee.contains(noListen)) {
				noSeeListen.add(noListen);
			}
		}

		System.out.println(noSeeListen.size());
		for(String s : noSeeListen) {
			System.out.println(s);
		}
	}
}
