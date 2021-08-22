/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 8320 - 직사각형을 만드는 방법
 * 
 * 변의 길이가 1인 정사각형 n개를 이용하여 만들 수 있는 직사각형의 총 개수 구하기
 */

package bronze.problem8320;

import java.util.Scanner;

public class Main {
	static int N;  // 가지고 있는 정사각형의 개수
	static int totalCount;  // 만들 수 있는 직사각형의 개수
	static int input[];  // 만들 수 있는 직사각형 변의 길이(최소변~최대변)
	static int numbers[];  // 직사각형 2개의 변
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();  // 정사각형의 개수 입력 받기
		
		totalCount = 0;  // 만들 수 있는 직사각형의 개수 초기화하기
		input = new int[N];  // 직사각형의 최소 변의 길이부터 최대 변의 길이 저장하기
		numbers = new int[2];  // 직사각형 2개의 변
		
		for(int i=0; i<N; i++) {  // 만들 수 있는 직사각형 변의 길이 저장하기
			input[i] = i+1;
		}
		
		generateSquare(0, 0);  // 만들 수 있는 직사각형 개수 구하기
		System.out.println(totalCount);
	}
	
	// 만들 수 있는 직사각형 개수 구하는 함수
	private static void generateSquare(int start, int cnt) {
		if(cnt == 2) {  // 변의 길이 2개 선택완료되면
			if(numbers[0] * numbers[1] <= N) {  // 넓이가 N보다 작은 경우만 직사각형 만들 수 있음
				totalCount++;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];  // 변의 길이중 하나 뽑기
			generateSquare(i, cnt+1);  // 중복 허용하면서 순서상관 없이 변의 길이 뽑기
		}
	}

}

