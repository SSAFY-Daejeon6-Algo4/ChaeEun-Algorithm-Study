/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 2999 - 비밀 이메일
 * 
 * - 암호 알고리즘
 * 1. N글자의 메시지를 보낼 경우, R*C=N인 R(행)과 C(열)를 고르기. (R이 큰값 선택)
 * 2. R행 C열인 행렬을 만들기
 * 3. 메시지를 행렬에 옮기기
 * 4. 첫번째 열의 첫번째 행부터 R번째 행까지 차례대로 읽으면서 다시 받아 적기
 */
package bronze.problem2999;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String secretMsg;  // 비밀 메시지
	static int N, R, C;  // 메시지 길이, R행, C열
	static char[][] arr;  // 메시지를 해독하기 위한 배열
	
	public static void main(String[] args) {
		// 입력 하기
		Scanner scan = new Scanner(System.in);
		secretMsg = scan.nextLine();  // 비밀 메시지 입력 받기
		N = secretMsg.length();  // 메시지 길이 저장하기
		// 입력 완료
		
		// 알고리즘 시작 : 비밀메시지를 해독하시오.
		findRC();  // 행과 열의 길이 찾기
		arr = new char[R][C];  // 배열 크기 초기화하기
		findArray(0);  // 메시지 해독을 위한 배열 생성하기
		// 알고리즘 종료
		
		// 출력
		for(char[] c: arr) {  // 해독한 메시지 출력하기
			System.out.print(c);
		}
		// 출력 종료
	}
	
	// R과 C를 구하는 함수
	private static void findRC() {
		for(int i=N-1; i>0; i--) {
			if(N % i == 0) {  // i로 나누어 떨어지는 경우, 그 값이 R행에 해당함
				R = i;
				C = N / i;
				if(R <= C) { return; }  // 범위 체크
			}
		}
	}
	
	// 암호화 했을 때 사용한 배열을 생성하는 함수
	private static void findArray(int i) {
		for(int c=0; c<C; c++) {  // 비밀 메시지를 배열 넣기(열순회)
			for(int r=0; r<R; r++) {
				arr[r][c] = secretMsg.charAt(i++);
			}
		}
	}
}
