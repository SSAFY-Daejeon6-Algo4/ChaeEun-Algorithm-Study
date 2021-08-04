/**
 * 날짜 : 2021.08.04
 * 이름 : 임채은
 * 문제 : 백준 2578
 * 메모리 : 17732KB
 * 시간 : 232ms
 * 풀이시간 : 1시간 30분
 */

package problem2578;

import java.util.Scanner;

public class Main {
	static int[][] map = new int[5][5];    // 빙고판 배열
	static int[] numbers = new int[25];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력받기
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				map[r][c] = scan.nextInt();
			}
		}
		for(int i=0; i<25; i++) {
			numbers[i] = scan.nextInt();
		}
		// 빙고 시작
		int number = 0;
		Loop :
		for(int i=0; i<25; i++) {
			number = i;
			// 부른 번호 빙고 X 표시하기
			subLoop :
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(map[r][c] == numbers[i]) {
						map[r][c] = 0;
						break subLoop;
					}
				}
			}
			int count = 0;
			// 빙고 가로 확인하기
			for(int r=0; r<5; r++) {
				if(map[r][0] == 0 && sumRow(r) == 0) count++;
				if(count == 3) break Loop;
			}
			// 빙고 세로 확인하기
			for(int c=0; c<5; c++) {
				if(map[0][c] == 0 && sumColumn(c) == 0) count++;
				if(count == 3) break Loop;
			}
			// 빙고 대각선 확인하기
			if(map[0][0] == 0 && sumDiagonal1()==0) count++;
			if(count == 3) break Loop;
			if(map[0][4] == 0 && sumDiagonal2()==0) count++;
			if(count == 3) break Loop;
		}
		System.out.println(number+1);		
	}	
	// 가로의 합
	static int sumRow(int r) {
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += map[r][i];
		}
		return sum;
	}	
	// 세로의 합
	static int sumColumn(int c) {
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += map[i][c];
		}
		return sum;
	}
	// 대각선의 합1
	static int sumDiagonal1() {
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += map[i][i];
		}
		return sum;
	}
	// 대각선의 합2
	static int sumDiagonal2() {
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += map[i][4-i];
		}
		return sum;
	}

}
