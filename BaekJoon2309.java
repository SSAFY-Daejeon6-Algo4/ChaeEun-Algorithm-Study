/**
 * 날짜 : 2021.08.01
 * 이름 : 임채은
 * 문제 : 백준 2309
 * 메모리 : 17704KB
 * 시간 : 240ms
 * 풀이시간 : 1시간 30분
 */

package problem2309;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[9];    // 난쟁이 키를 저장할 배열
		int n;    // 난쟁이 키 입력받는 변수
		int sum9 = 0;    // 9명의 난쟁이의 키의 합
		int sum2 = 0;    // 2명의 난쟁이의 키의 합
		
		// 9명의 난쟁이 키 입력 받기
		for(int i=0; i<array.length; i++) {
			n = scan.nextInt();
			array[i] = n;
			sum9 += n;    // 9명의 난쟁이의 키의 합 구하기
		}
		// 7명의 난쟁이의 키는 100이므로
		// 9명의 난쟁이의 키 - 2명의 난쟁이의 키 = 100이 되는 2명의 난쟁이의 키 찾기
		Loop :
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				sum2 = array[i] + array[j];
				// 2명의 난쟁이 키를 찾으면, 키값 0으로 주기
				if((sum9 - sum2) == 100) {
					array[i] = 0;
					array[j] = 0;
					break Loop;
				}
			}
		}
		
		// 오름차순 정렬
		Arrays.sort(array);
		
		// 7명의 난쟁이 키 출력하기
		for(int i=2; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}
