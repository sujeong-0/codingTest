package sorting;

import java.io.*;
import java.util.*;

/**
 * description    :
 * packageName    : sorting
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2/15/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/15/25        ggong       최초 생성
 */
public class Q_10814_나이순_정렬 {
	public static void main(String[] args) throws IOException {


		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		String[] data = new String[201];

		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int age = Integer.parseInt(st.nextToken());
			data[age] =  data[age] == null ? s : String.format("%s\n%s",data[age],s);
		}

		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				continue;
			}
			bw.write(data[i]);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
	public static void main2(String[] args) throws IOException {// 더 오래걸림, 메모리는 적게씀


		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		int[] ages = new int[count];
		int[] rank = new int[count];
		String[] names = new String[count];

		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			ages[i] = age;
			rank[i] = age;
			names[i] = name;
		}

		Arrays.sort(rank);

		for(int i = 0; i < rank.length; i++) {
			for(int j = 0; j < ages.length; j++) {
				if(rank[i] == ages[j]) {
					bw.append(String.valueOf(ages[j])).append(" ").append(names[j]).append("\n");
					ages[j] = -1;
					break;
				}
			}
		}

		bw.flush();
		bw.close();
	}

	// 우선순위큐 + class 정의
	public static void main1(String[] args) throws IOException {


		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            count = Integer.parseInt(br.readLine());
		Queue<User> users = new PriorityQueue<>((o1, o2) ->{
			if(o1.age != o2.age) {
				return Integer.compare(o1.age, o2.age);
			}
			return Integer.compare(o1.order, o2.order);

		});

		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			users.offer(new User(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		for(int i = 0; i < count; i++) {
			bw.write(users.poll().toString());
		}


		bw.flush();
		bw.close();
	}


	static class User {
		int age;
		String name;
		int order;

		public User(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		public String toString() {
			return String.format("%d %s\n", this.age, this.name);
		}
	}
}