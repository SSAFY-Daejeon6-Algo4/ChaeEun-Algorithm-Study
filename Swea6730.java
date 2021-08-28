import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 날짜 : 2021.08.28
 * 이름 : 임채은
 * 문제 : SEWA 6730 - 장애물 경주 난이도
 * 
 * step1. (i번째 장애물) - (i+1번째 장애물) 의 값 구하기
 * step2. 구한 값으로 난이도 갱신하기
 *        음수라면, 올라갈 때 난이도 갱신하기
 *        양수라면, 내려갈 때 난이도 갱신하기
 */

public class Swea6730 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;  // 테스트 케이스 개수, 블록의 개수
	static int[] blocks;  // 블록의 높이를 저장할 배열
	static int uLevel, dLevel;  // 올라갈 때 난이도, 내려갈때 난이도
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=T; t++) {
			out.append("#").append(t).append(" ");
			// 입력 시작
			N = Integer.parseInt(in.readLine());  // 블록의 개수
			blocks = new int[N];  // 블록의 높이를 저장할 배열의 크기 초기화
			
			tokens = new StringTokenizer(in.readLine());
			for(int n=0; n<N; n++) {  // 블록의 높이를 저장할 배열 생성하기
				blocks[n] = Integer.parseInt(tokens.nextToken());
			}
			// 입력 완료
			
			// 알고리즘 시작 : 올라갈 때 난이도와 내려갈 때 난이도 구하기
			uLevel = 0;  // 올라갈 때 난이도 초기화
			dLevel = 0;  // 내려갈 때 난이도 초기화
			
			for(int i=0; i<N-1; i++) {
				// step1. (i번째 장애물) - (i+1번째 장애물) 의 값 구하기
				int level = blocks[i] - blocks[i+1];
				
				// step2. 구한 값으로 난이도 갱신하기
				if(level < 0) {  // 올라갈 때 난이도 갱신하기
					level = Math.abs(level);
					uLevel = (level > uLevel) ? level : uLevel;
				} else {  // 내려갈 때 난이도 갱신하기
					dLevel = (level > dLevel) ? level : dLevel;
				}
			}
			// 알고리즘 종료
			out.append(uLevel).append(" ").append(dLevel).append(" ").append("\n");
		}
		System.out.println(out);
	}

}
