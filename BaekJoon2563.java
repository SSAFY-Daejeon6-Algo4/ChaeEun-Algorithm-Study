/**
 * 날짜 : 2021.08.04
 * 이름 : 임채은
 * 문제 : 백준 2563 - 색종이
 * 메모리 : 17808KB
 * 시간 : 244ms
 * 풀이시간 : 30~40분
 */

package problem2563;

import java.util.Scanner;

public class BaekJoon2563 {
	static int N;    // 색종이 수
	static int[][] position;    // 색종이 위치
	static int answer = 0;    // 색종이 넓이
	static boolean[][] paper;    // 도화지
	static int maxX=0, maxY=0;    // 최대 x, y의 좌표
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력 받기
		N = scan.nextInt();
		position = new int[N][2];
		for(int n=0; n<N; n++) {
			position[n][0] = scan.nextInt();
			position[n][1] = scan.nextInt();
			maxX = (position[n][0] > maxX) ? position[n][0] : maxX;
			maxY = (position[n][1] > maxY) ? position[n][1] : maxY;
		}
		paper = new boolean[maxX+10][maxY+10];
		// 입력 완료
		// 도화지에 색종이 붙이기
		for(int n=0; n<N; n++) {
			for(int x=position[n][0]; x<position[n][0]+10; x++) {
				for(int y=position[n][1]; y<position[n][1]+10; y++) {
					if(paper[x][y] == false) paper[x][y] = true; 
				}
			}
		}
		// 색종이 넓이 구하기
		for(int x=0; x<maxX+10; x++) {
			for(int y=0; y<maxY+10; y++) {
				if(paper[x][y] == true) answer++;
			}
		}
		// 출력하기
		System.out.println(answer);
	}
	
}
