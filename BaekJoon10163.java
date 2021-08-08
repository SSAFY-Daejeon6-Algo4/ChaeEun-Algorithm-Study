/**
 * 날짜 : 2021.08.04
 * 이름 : 임채은
 * 문제 : 백준 10163 - 색종이
 * 메모리 : 21956KB
 * 시간 : 304ms
 * 풀이시간 : 30분
 */

package problem10163;

import java.util.Scanner;

public class BaekJoon10163 {
	static int N;    // N장의 색종이
	static int[][] paperState;    // x좌표, y좌표, 너비, 높이
	static int[][] plane;    // 색종이를 놓을 평면
	static int maxX=0, maxY=0;    // 최대가로길이, 최대세로길이
	static int[] paper;    // 각 색종이가 보이는 넓이
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력받기
		N = scan.nextInt();
		paperState = new int[N][4];
		paper = new int[N+1];
		for(int n=0; n<N; n++) {
			paperState[n][0] = scan.nextInt();
			paperState[n][1] = scan.nextInt();
			paperState[n][2] = scan.nextInt();
			paperState[n][3] = scan.nextInt();
			maxX = (paperState[n][0] + paperState[n][2] > maxX) ? (paperState[n][0] + paperState[n][2]) : maxX; 
			maxY = (paperState[n][1] + paperState[n][3] > maxY) ? (paperState[n][1] + paperState[n][3]) : maxY; 
		}
		plane = new int[maxX][maxY];
		// 입력완료
		// 색종이 평면에 놓기
		for(int n=0; n<N; n++) {
			for(int x=paperState[n][0]; x<paperState[n][0]+paperState[n][2]; x++) {
				for(int y=paperState[n][1]; y<paperState[n][1]+paperState[n][3]; y++) {
					plane[x][y] = n+1;
				}
			}
		}
		// 각 색종이 면적 구하기
		for(int x=0; x<maxX; x++) {
			for(int y=0; y<maxY; y++) {
				paper[plane[x][y]]++;
			}
		}
		// 출력 하기
		for(int i=1; i<=N; i++) {
			System.out.println(paper[i]);
		}
	}

}
