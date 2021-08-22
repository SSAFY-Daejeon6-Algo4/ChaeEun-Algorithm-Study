/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 3985 - 롤 케이크
 * 
 * L 미터의 롤 케이크를 방청객 N명에게 나누어 준다.
 * 롤케이크는 1미터 단위로 잘라서 줄 수 있다.
 * 가장 왼쪽 조각이 1번, 오른쪽 조각이 L번 조각이다.
 * 방청객은 종이에 자신이 원하는 조각을 적어서 낸다. (P와 K : P부터 K조각까지)
 * 1번부터 차례대로 케이크 조각을 받는다. (자신이 원했던 조각을 못받을 수 있음)
 * 가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호와
 * 실제로 가장 많은 케이크 조각을 받는 방청객의 번호 구하기
 */

package bronze.problem3985;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] cake;  // 남아 있는 롤 케이크
	static int N, L;   // 방청객의 수, 롤 케이크의 길이
	static int P, K;  // P번 조각부터 K번 조각
	static int pCnt = 0, pIndex = 0;  // 가장 많은 조각을 받을 것 같은 조각수와 방청객 번호
	static int cnt = 0, Index = 0;  // 실제로 가장 많은 조각을 받은 조각수와 방청객 번호
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		L = scan.nextInt();  // 롤 케이크의 길이 입력받기
		cake = new boolean[L+1];  // 롤 케이크 크기 초기화 (케이크는 1번부터 시작)
		Arrays.fill(cake, true);  // 롤 케이크 값 초기화
		
		N = scan.nextInt();  // 방청객의 수 입력받기
		for(int n=1; n<=N; n++) {  // 방청객에게 케이크 나눠주기
			P = scan.nextInt();  // P번 조각부터
			K = scan.nextInt();  // K번 조각까지
			
			int tempCnt = K-P+1;  // 받을 수 있는 케이크 예상 조각 수
			if(tempCnt > pCnt) {  // 가장 많은 조각을 받을 것 같은 조각수와 방청객 번호 갱신하기
				pCnt = tempCnt;
				pIndex = n;
			}
			
			tempCnt = 0;  // 실제로 받은 케이크 예상 조각 수
			for(int i=P; i<=K; i++) {
				if(cake[i] == true) {  // 케이크가 남아있다면, 케이크 받기
					cake[i] = false;
					tempCnt++;
				}
			}
			if(tempCnt > cnt) {  // 실제로 가장 많은 조각을 받은 조각수와 방청객 번호 갱신하기
				cnt = tempCnt;
				Index = n;
			}
		}
		
		System.out.println(pIndex);
		System.out.println(Index);

	}

}
