/**
 * 날짜 : 2021.08.03
 * 이름 : 임채은
 * 문제 : 백준 2605
 * 메모리 : 18400KB
 * 시간 : 256ms
 * 풀이시간 : 30분
 */

package problem2605;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;    // 학생수
	static int[] stdNumbers;    // 학생들이 뽑은 번호
	static List<Integer> aList = new ArrayList<Integer>();    // 줄을 세우기 위한 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력받기
		N = scan.nextInt();
		stdNumbers = new int[N];
		for(int i=0; i<N; i++) { stdNumbers[i] = scan.nextInt(); }
		// 입력 완료
		// 줄 세우기
		for(int i=0; i<N; i++) {
			aList.add(i-stdNumbers[i], i+1);
		}
		// 줄 세우기 완료
		// 출력하기
		for(int value: aList) { System.out.print(value + " "); }
		// 출력 완료
	}

}
