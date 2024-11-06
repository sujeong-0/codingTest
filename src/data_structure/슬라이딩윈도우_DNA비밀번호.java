package data_structure;

/**
 * description    :
 * packageName    : data_structure
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 24. 11. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 11. 5.        ggong       최초 생성
 */

/*
 * DNA 문자열이란 모든 문자열에 등장하는 문자가 {'A', 'C', 'G', 'T'}인 문자열을 말한다.
 * 민호는 DNA문자열에서 부분문자열을 가져와 비밀번호로 사용하려고 하는데, 보안을 위해 특정 조건을 추가하려고한다.
 * 이렇게 DNA문자열과 비밀번호로 사용할 문자열의 길이, {'A', 'C', 'G', 'T'}가 각 몇번 등장해야하는 조건을 입력했을 때
 *   민호사 사용할 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하시오.
 *  * 단 부분 문자열이 등장하는 위치가 다르면, 문자열의 내용이 같더라도 다른 문자열로 취급한다.
 * - 입력: 1번쨰 줄에 민호가 임의로 만든 DNA 문자열 길이 S 와 비밀번호로 사용할 부분 문자열의 길이 P 가 주어진다.  (1 <= P <= S <= 1,000,000 )
 *          2번째 줄에 민호가 임의로 만든 DNA 문자열이 주어진다.
 *          3번쨰 줄에 부분문자열에 포함되어야할 {'A', 'C', 'G', 'T'}의 최소 개수가 공백 문자를 사이에 두고 주어진다. (각 수는 S보다 작거나 음이아닌 정수로 총 합은 S 보다 작거나 같다 )
 * - 출력: 좋은 수의 개수를 출력한다.
 */
public class 슬라이딩윈도우_DNA비밀번호 {
	public static void main(String[] args) {
		System.out.println(solution_answer(9,8,"CCTGGATTG",2,0,1,1));
		System.out.println(solution_answer(4,2,"GATA",1,0,0,1));
	}
	static int[] checkCondition ;
	static int[] statusCondition ;
	static int checkSecret;
	public static void add(char c) {
		switch (c) {
			case 'A':
				statusCondition[0]++;
				if(checkCondition[0] == statusCondition[0]) { // 같을 때 한번만 해야함
					checkSecret++;
				}
				break;
			case 'C':
				statusCondition[1]++;
				if(checkCondition[1] == statusCondition[1]) { // 같을 때 한번만 해야함
					checkSecret++;
				}
				break;
			case 'G':
				statusCondition[2]++;
				if(checkCondition[2] == statusCondition[2]) { // 같을 때 한번만 해야함
					checkSecret++;
				}
				break;
			case 'T':
				statusCondition[3]++;
				if(checkCondition[3] == statusCondition[3]) { // 같을 때 한번만 해야함
					checkSecret++;
				}
				break;
			default:
				break;
		}
	}
	public static void remove(char c) {
		switch (c) {
			case 'A':
				if(checkCondition[0] == statusCondition[0]) { // 같을 때 한번만 해야함
					checkSecret--;
				}
				statusCondition[0]--;
				break;
			case 'C':
				if(checkCondition[1] == statusCondition[1]) { // 같을 때 한번만 해야함
					checkSecret--;
				}
				statusCondition[1]--;
				break;
			case 'G':
				if(checkCondition[2] == statusCondition[2]) { // 같을 때 한번만 해야함
					checkSecret--;
				}
				statusCondition[2]--;
				break;
			case 'T':
				if(checkCondition[3] == statusCondition[3]) { // 같을 때 한번만 해야함
					checkSecret--;
				}
				statusCondition[3]--;
				break;
			default:
				break;
		}
	}

	public static int solution_answer(int dnaLen, int subLen,final String DNA, int A_COUNT, int C_COUNT, int G_COUNT, int T_COUNT){

	    checkCondition = new int[]{A_COUNT, C_COUNT, G_COUNT, T_COUNT}; // 비밀번호 체크 조건
		statusCondition = new int[]{0,0,0,0}; // 현재 상태
		int count =0 ;// 맞는 개수
		char[] DNA_DATA = DNA.toCharArray();

		checkSecret = 0 ;// checkCondition에서 몇개의 조건을 충족했는지 세는 변수
		if(A_COUNT == 0)
			checkSecret++;
		if(C_COUNT == 0)
			checkSecret++;
		if(G_COUNT == 0)
			checkSecret++;
		if(T_COUNT == 0)
			checkSecret++;

		for (int i = 0; i < subLen; i++) { // 부분 문자열 처음 받을떄 세팅
			add(DNA_DATA[i]);
		}

		if(checkSecret == 4) // 세팅 한 문자열이 바로 충족될 수 있기때문에
			count++;

		// 슬라이딩 윈도우, i는 추가되는 j는 삭제되는
		for (int i = subLen; i <dnaLen; i++) {
			int j = i - subLen;
			add(DNA_DATA[i]);
			remove(DNA_DATA[j]);
			if (checkSecret == 4) {
				count++;
			}
		}
		return count;
	}
	public static int solution_ver2(int dnaLen, int subLen,final String DNA, int A_COUNT, int C_COUNT, int G_COUNT, int T_COUNT) {

		int start_index = 0, end_index = subLen, count = 0;
		int[] checkCondition = new int[]{A_COUNT, C_COUNT, G_COUNT, T_COUNT}; // 비밀번호 체크 조건
		int[] statusCondition = new int[]{0,0,0,0}; // 현재 상태
		final String index = "ACGT";


		// 1. 부분 문자열을 자름 , 2. 부분 문자열의 내용을 현재 상태에 넣음
		for (char c : DNA.substring(start_index, end_index).toCharArray()) {
			statusCondition[index.indexOf(c)]++;
		}

		while (true) {
			// 3. 현재 상태와 비밀번호 체크조건을 비교함
			boolean isOkay = true;
			for (int i = 0; i <checkCondition.length; i++) {
				if (checkCondition[i]>statusCondition[i]) {
					isOkay = false;
					break;
				}
			}
			if (isOkay) {
				count++;
			}

			if (end_index  == dnaLen) {
				break;
			}

			// 4. 부분 문자열을 자를 조건을 이동함

			char minChar = DNA.charAt(start_index++);
			char plusChar = DNA.charAt(end_index++);
			statusCondition[index.indexOf(minChar)]--;
			statusCondition[index.indexOf(plusChar)]++;
		}

		return count;
	}
	public static int solution_ver1(int dnaLen, int subLen,final String DNA, int A_COUNT, int C_COUNT, int G_COUNT, int T_COUNT) {

		int start_index = 0, end_index = subLen, count = 0;
		while (end_index <= DNA.length()) {
			String temp = DNA.substring(start_index++, end_index++);
			int aCount = 0,cCount = 0,gCount = 0,tCount = 0;
			for (char c : temp.toCharArray()) {
				switch (c) {
					case 'A':
						aCount++;
						break;
					case 'C':
						cCount++;
						break;
					case 'G':
						gCount++;
						break;
					case 'T':
						tCount++;
						break;
					default:
						break;
				}
			}

			if (aCount == A_COUNT && cCount == C_COUNT && gCount == G_COUNT && tCount == T_COUNT) {
				System.out.print(temp + " / ");
				count++;
			}
		}

		return count;
	}
}
