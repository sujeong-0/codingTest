package data_structure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/12/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/12/25        ggong       최초 생성
 */
public class 생태학 {

	//TODO 미해결, 엣지 케이스를 찾지 못함
	public static void main(String[] args) throws IOException {
		Map<String, Integer> trees = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int treeCount = 0;
		for(int i = 0; i < 1_000_000; i++) {
			String         treeName  = br.readLine();
			if(treeName == null || treeName.isEmpty()) {
				treeCount = i;
				break;
			}
			trees.compute(treeName, (k, v) -> v == null ? 1 : v + 1);
		}
		Queue<String> treeNames = new PriorityQueue<>((a,b)->{
			char[] aChars = a.toCharArray();
			char[] bChars = b.toCharArray();
			int len = aChars.length < bChars.length ? aChars.length : bChars.length;

			for(int i = 0; i <len ; i++) {
				// 특수문자
				if(!Character.isLetterOrDigit(aChars[i]) && Character.isLetterOrDigit(bChars[i])) {
					return -1;
				}
				if(Character.isLetterOrDigit(aChars[i]) && !Character.isLetterOrDigit(bChars[i])) {
					return 1;
				}

				// 숫자
				if(Character.isDigit(aChars[i]) && !Character.isDigit(bChars[i])) {
					return -1;
				}
				if(!Character.isDigit(aChars[i]) && Character.isDigit(bChars[i])) {
					return 1;
				}

				// 대문자
				if(Character.isUpperCase(aChars[i]) && !Character.isUpperCase(bChars[i])) {
					return -1;
				}
				if(!Character.isUpperCase(aChars[i]) && Character.isUpperCase(bChars[i])) {
					return 1;
				}
				// 소문자
				if(Character.isLowerCase(aChars[i]) && !Character.isLowerCase(bChars[i])) {
					return -1;
				}
				if(!Character.isLowerCase(aChars[i]) && Character.isLowerCase(bChars[i])) {
					return 1;
				}
			}
			return a.compareTo(b);
		});
		treeNames.addAll(trees.keySet());

		StringBuilder sb = new StringBuilder();
		while(!treeNames.isEmpty()) {
			String tree = treeNames.poll();
			double percent = trees.get(tree).doubleValue() / treeCount * 100;
			sb.append(tree).append(String.format(" %.4f\n", percent));
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.isEmpty()? "0.0000" :sb.toString());
		bw.flush();
		bw.close();
	}
}
