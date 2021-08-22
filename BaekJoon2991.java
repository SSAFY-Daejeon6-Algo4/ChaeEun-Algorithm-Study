/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 2991- 사나운 개
 * 
 * 상근이네 집에는 사나운 개 두마리가 있다.
 * 개1 : A분 공격적 -> B분 휴식 (반복)
 * 개2 : C분 공격적 -> D분 휴식 (반복)
 * 우체부, 신문배달원, 우유배달원이 상근이네 집에 도착했을때, 공격받는 개의 수 구하기
 * 우체부 도착시간 : P분
 * 신문배달원 도착시간 : M분
 * 우유배달원 도착시간 : N분
 * 아침이 시작하는 시간은 0이다. 도착 시간은 아침이 시작한 후 지난 시간을 의미한다.
 */

package bronze.problem2991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int A, B, C, D;  // 개1의 공격시간과 휴식시간, 개2의 공격시간과 휴식시간
	static int[] arrivalTime = new int[3];  // 우체부, 신문배달원, 우유배달원의 도착시간
	static int[] cnt = new int[3];  // 우체부, 신문배달원, 우유배달원이 공격받은 개의 수
	
	public static void main(String[] args) throws Exception {
		// 입력받기
		tokens = new StringTokenizer(in.readLine());  // 개의 공격시간과 휴식시간 입력받기
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());

		tokens = new StringTokenizer(in.readLine());  // 배달원의 도착시간 입력받기
		for(int i=0; i<3; i++) {
			arrivalTime[i] = Integer.parseInt(tokens.nextToken());
		}
		// 입력완료
		
		// 알고리즘 시작 : 우체부, 신문배달원, 우유배달원이 도착했을때, 공격받는 개의 수 구하기
		int dog1 = A+B;  // 개1의 반복패턴 범위
		int dog2 = C+D;  // 개2의 반복패턴 범위
		for(int i=0; i<3; i++) {
			// 개1에게 공격받는지 확인하기
			int temp = arrivalTime[i] % dog1;  // 도착시간 재정의하기
			if(arrivalTime[i] == 0) cnt[i]++;  // 0분에 도착하면 무조건 공격 받음
			if(1 <= temp && temp <= A) {  // 배달원이 개 공격시간에 도착했다면
				if(A != 0) cnt[i]++;	
			}
			// 개2에게 공격받는지 확인하기
			if(arrivalTime[i] == 0) cnt[i]++;  // 0분에 도착하면 무조건 공격 받음
			temp = arrivalTime[i] % dog2;
			if(1 <= temp && temp <= C) {  // 배달원이 개 공격시간에 도착했다면
				if(C != 0) cnt[i]++;
			}
		}
		// 알고리즘 종료
		for(int i: cnt) {
			System.out.println(i);
		}
	}

}
