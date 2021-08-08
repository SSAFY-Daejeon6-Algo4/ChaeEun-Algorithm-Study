/**
 * 날짜 : 2021.08.08
 * 이름 : 임채은
 * 문제 : 백준 2491 - 수열
 * 메모리 : 113068KB
 * 시간 : 852ms
 * 풀이시간 : 1시간 30분
 */

package problem2491;

import java.util.Scanner;

public class BaekJoon2491 {
	static int[] array;    // 수열을 저장하는 배열
	static int N;    // 수열의 길이
	static int max = 1;    // 가장 긴 길이
	static int len = 1;    // 가장 긴 길이
	
	public static void main(String[] args) {
		// 입력 받기
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = scan.nextInt();
		}
		// 입력 완료
		// 알고리즘 시작
		// 오름차순
		for(int i=1; i<N; i++) {
			if(array[i] >= array[i-1]) { len++; }
			else { len = 1; }
			max = (len > max) ? len : max;
		}
		
		// 내림차순
		len = 1;
		for(int i=1; i<N; i++) {
			if(array[i] <= array[i-1]) { len++; }
			else { len = 1; }
			max = (len > max) ? len : max;
		}
		// 알고리즘 종료
		// 출력하기
		System.out.println(max);
	}

}
