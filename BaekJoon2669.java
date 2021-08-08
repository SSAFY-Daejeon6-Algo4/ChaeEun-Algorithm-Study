/**
 * 날짜 : 2021.08.04
 * 이름 : 임채은
 * 문제 : 백준 2669 - 직사각형 네개의 합집합의 면적 구하기
 * 메모리 : 17624KB
 * 시간 : 228ms
 * 풀이시간 : 30~40분
 */

package problem2669;

import java.util.Scanner;

public class BaekJoon2669 {
	static int[][] position = new int[4][4];    // x1좌표, y1좌표, x2좌표, y2좌표
	static int maxX=0, maxY=0;    // 최대 x, y좌표
	static boolean[][] plane;    // 좌표
	static int answer=0;    // 면적
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력 받기
		for(int n=0; n<4; n++) {
			position[n][0] = scan.nextInt();
			position[n][1] = scan.nextInt();
			position[n][2] = scan.nextInt();
			position[n][3] = scan.nextInt();
			maxX = (position[n][2] > maxX) ? position[n][2] : maxX;
			maxY = (position[n][3] > maxY) ? position[n][3] : maxY;
		}
		plane = new boolean[maxX][maxY];
		// 입력 완료
		// 좌표에 직사각형 놓기
		for(int n=0; n<4; n++) {
			for(int x=position[n][0]; x<position[n][2]; x++) {
				for(int y=position[n][1]; y<position[n][3]; y++) {
					if(plane[x][y] == false) plane[x][y] = true;
				}
			}
		}
		// 면적 구하기
		for(int x=0; x<maxX; x++) {
			for(int y=0; y<maxY; y++) {
				if(plane[x][y] == true) answer++;
			}
		}
		// 출력하기
		System.out.println(answer);
	}

}
