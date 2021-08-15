/**
 * 날짜 : 2021.08.13
 * 이름 : 임채은
 * 문제 : 백준 2559 - 수열(S3)
 * 걸린 시간 : 30분~40분
 * 메모리 : 113180KB
 * 시간 : 1740ms
 */

package problem2559;

import java.util.Scanner;

public class BaekJoon2559 {
	static int N, K;  // 온도를 측정한 전체 날짜의 수, 합을 구하기 위한 연속적인 날짜의 수
	static int[] temperature;  // 입력받은 온도를 저장할 배열
	static int[] sumTemperature;  // 온도의 합을 저장할 배열
	static int answer;  // 온도의 합이 가장 큰 값
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // 입력을 받기 위한 변수
		// 입력 받기
		N = scan.nextInt();  // 온도를 측정한 전체 날짜의 수 저장하기
		K = scan.nextInt();  // 합을 구하기 위한 연속적인 날짜의 수 저장하기
		temperature = new int[N];  // 입력 받을 온도를 저장할 배열 초기화하기
		sumTemperature = new int[N-K+1];  // 온도의 합을 저장할 배열 초기화하기
		answer = Integer.MIN_VALUE;  // 온도의 합이 가장 큰 값 초기화하기
		for(int i=0; i<N; i++) {  // 온도 저장하기
			temperature[i] = scan.nextInt();
		}
		// 입력 완료
		// 알고리즘 시작 : 온도의 합이 가장 큰 값 계산하기
		Solution(0);
		// 알고리즘 종료
		System.out.println(answer);
	}
	
	// 온도의 합이 가장 큰 값 계산하는 함수
	private static void Solution(int start) {
		if(start == N-K+1) return;  // 계산을 다하면 종료
		
		int sum = 0;  // 연속적인 K일의 온도의 합 초기화하기
		for(int i=start; i<start+K; i++) {  // 연속적인 K일 수만큼 온도의 합 구하기 
			sum += temperature[i];
		}
		answer = (sum > answer) ? sum : answer;  // 온도의 합이 가장 큰값 갱신하기
		
		Solution(start+1);  // 그 다음날의 연속적인 온도의 합 구하기 
	}
}
