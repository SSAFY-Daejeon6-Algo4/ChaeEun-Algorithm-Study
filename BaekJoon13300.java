/**
 * 날짜 : 2021.08.04
 * 이름 : 임채은
 * 문제 : 백준 13300 - 방배정
 * 메모리 : 21956KB
 * 시간 : 304ms
 * 풀이시간 : 30분
 */

package problem13300;

import java.util.Scanner;

public class BaekJoon13300 {
	static int N, K;    // 학생수, 최대 인원
	static int S, Y;    // 성별(0:여, 1:남), 학년
	static int[] female = new int[7];    // 여학생 배열 - 1학년, 2학년, ..., 6학년
	static int[] male = new int[7];    // 남학생 배열 - 1학년, 2학년, ..., 6학년
	static int answer = 0;    // 최소 방의 개수
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력받기
		N = scan.nextInt();
		K = scan.nextInt();
		for(int n=0; n<N; n++) {
			S = scan.nextInt();
			Y = scan.nextInt();
			if(S == 0) female[Y]++;
			if(S == 1) male[Y]++;
		}
		// 입력완료
		// 방의 개수 구하기
		for(int n=1; n<7; n++) {    
			answer += female[n] / K;    // 학생수 / 최대인원 = 방의 개수
			answer += male[n] / K;    // 학생수 / 최대인원 = 방의 개수
			// 남은 학생이 있다면
			if((female[n] % K) != 0) answer++;
			if((male[n] % K) != 0) answer++;
		}
		System.out.println(answer);
	}

}
