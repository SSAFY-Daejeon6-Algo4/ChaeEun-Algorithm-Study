/**
 * 날짜 : 2021.08.13
 * 이름 : 임채은
 * 문제 : 백준 10157 - 자리배정(S4)
 * 걸린 시간 : 5시간
 * 메모리 : 44900KB
 * 시간 : 364ms
 */
package problem10157;

import java.util.Scanner;

public class BaekJoon10157 {
	static class Seat{  //좌석의 좌표
		int x;  // 좌석의 x좌표
		int y;  // 좌석의 y좌표
		boolean isEmpty;  // 빈좌석을 체크하는 변수
		
		Seat(int x, int y, boolean isEmpty){
			this.x = x;
			this.y = y;
			this.isEmpty = isEmpty;
		}
	}
	static int C, R, number, cnt;  // 가로 개수, 세로 개수, 대기 번호, 좌석의 번호
	static Seat seat[][];  // 좌석의 좌표를 저장할 2차원 배열
	static int[][] deltas = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };  // 좌석 순회를 위한 변수 : 상, 우, 하, 좌
	static int x, y;  // 좌석 번호 (answer)
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // 입력을 받기 위한 변수
		// 입력 받기
		C = scan.nextInt();  // 가로 개수(열) 입력 받기
		R = scan.nextInt();  // 세로 개수(행) 입력 받기
		number = scan.nextInt();  // 대기 번호 입력받기
		// 입력 완료
		// 좌석번호 생성하기
		seat = new Seat[R][C];  // 좌석의 좌표를 저장할 배열 초기화하기
		for(int i=0; i<R; i++) {  // 좌석의 좌표 생성하기
			for(int j=0; j<C; j++) {
				seat[i][j] = new Seat(j+1, R-i, true);
			}
		}
		// 알고리즘 시작 : 왼쪽 아래 끝 좌표부터 상, 우, 하, 좌 순으로 순회하기
		if(number > R*C) {  // 대기번호가 좌석의 개수보다 큰 경우
			cnt = 0;
			System.out.println(cnt);
		} else {
			int[] pointer = new int[] {R-1, 0};  // 현재 좌석의 위치 : 왼쪽 아래 끝 배열의 인덱스 저장하기 (row, col)
			seat[pointer[0]][pointer[1]].isEmpty = false;  // 현재 좌석 채우기
			x = seat[pointer[0]][pointer[1]].x; // 현재 좌석 x좌표 저장하기
			y = seat[pointer[0]][pointer[1]].y; // 현재 좌석 y좌표 저장하기
			cnt = 1;
			Loop1: 
			while(number != cnt) {  // 좌석의 개수만큼 순회하기
				for(int i=0; i<deltas.length; i++) {  // 상, 우, 하, 좌 순서로 순회하기
					while(isIn(pointer[0] + deltas[i][0], pointer[1] + deltas[i][1]) &&
					      seat[pointer[0] + deltas[i][0]][pointer[1] + deltas[i][1]].isEmpty){  // 이동하는 좌표가 범위를 벗어나지 않을때 까지 이동하기
						pointer[0] += deltas[i][0];  // 좌석의 row위치 변경하기
						pointer[1] += deltas[i][1];  // 좌석의 col위치 변경하기
						cnt++;  // 다음 좌석번호로 업데이트하기
						if(number == cnt) {  // 대기번호와 좌석번호가 일치하면 순회 멈추기
							x = seat[pointer[0]][pointer[1]].x;
							y = seat[pointer[0]][pointer[1]].y;
							break Loop1;
						}  
						seat[pointer[0]][pointer[1]].isEmpty = false;  // 좌석을 채우고
					}
				}
			}
			System.out.println(x + " " + y);
		}
		// 알고리즘 종료
	}
	
	private static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C;
	}
}
