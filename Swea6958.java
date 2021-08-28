import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 날짜 : 2021.08.28
 * 이름 : 임채은
 * 문제 : SWEA 6958 - 동철이의 프로그래밍 대회
 *
 * 문제 풀이
 * step1. N명의 사람들이 맞은 문제의 수를 저장할 N크기의 1차원 배열 생성하기
          (풀었다면 1, 풀지 못했다면 0)
 * step2. 1차원 배열 내림차순으로 정렬하기
 * step3. 배열을 통해서 1등이 푼 문제의 수와 1등한 사람의 수 구하기
 */

public class Swea6958 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M;  // 테스트 케이스 수, N명의 사람, M개의 문제
	static Integer[] scores;  // N명의 사람들이 맞은 문제의 수를 저장할 배열
	static int maxScore, count;   // 1등이 푼 문제의 수, 1등한 사람의 수
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokens.nextToken());  // N명의 사람
			M = Integer.parseInt(tokens.nextToken());  // M개의 문제
			scores = new Integer[N];  // N명의 사람들이 맞은 문제의 수를 저장할 배열 크기 초기화
			Arrays.fill(scores, 0);  // 점수 0으로 초기화
			
			// step1.  N명의 사람들이 맞은 문제의 수를 저장할배열 생성하기
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(in.readLine());
				for(int m=0; m<M; m++) {
					if(tokens.nextToken().equals("1")) { scores[n]++; }  // 풀었다면 1증가
				}
			}
			
			// step2. 1차원 배열 내림차순으로 정렬하기
			Arrays.sort(scores ,Collections.reverseOrder());
			
			
			// step3. 배열을 통해서 1등이 푼 문제의 수와 1등한 사람의 수 구하기
			maxScore = scores[0];  // 1등이 푼 문제의 수
			count = 0;   // 1등한 사람의 수 초기화
			for(Integer score: scores) {
				if(score == maxScore) { count++; }
				else { break; }
			}
			
			out.append("#").append(t).append(" ").append(count).append(" ").append(maxScore).append("\n");
		}
		System.out.println(out);
	}

}
