/**
 * 날짜 : 2021.08.08
 * 이름 : 임채은
 * 문제 : 백준 14696 - 딱지놀이
 * 메모리 : 28516KB
 * 시간 : 320ms
 * 풀이시간 : 40분
 */

package problem14696;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 별, 동그라미, 네모, 세모 : 4, 3, 2, 1
public class BaekJoon14696 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder();
	static StringTokenizer tokens;
	static int N;    // 총 라운드 수
	static int[] kid1;    // 별, 동그라미, 네모, 세모 갯수를 저장할 배열
	static int[] kid2;    // 별, 동그라미, 네모, 세모 갯수를 저장할 배열
	static boolean draw = false;
	
	public static void main(String[] args) throws Exception {
		int range = 0;
		N = Integer.parseInt(in.readLine());
		
		for(int n=0; n<N; n++) {
			kid1 = new int[5];
			kid2 = new int[5]; 
			draw = true;
			// 입력 받기
			tokens = new StringTokenizer(in.readLine());
			range = Integer.parseInt(tokens.nextToken());
			for(int i=0; i<range; i++) {
				kid1[Integer.parseInt(tokens.nextToken())]++;
			}
			
			tokens = new StringTokenizer(in.readLine());
			range = Integer.parseInt(tokens.nextToken());
			for(int i=0; i<range; i++) {
				kid2[Integer.parseInt(tokens.nextToken())]++;
			}
			// 입력 완료
			// 승부 정하기
			for(int i=4; i>0; i--) {
				if(kid1[i] == kid2[i]) continue;
				if(kid1[i] > kid2[i]) {
					draw = false;
					out.append("A").append("\n");
					break;
				} else {
					draw = false;
					out.append("B").append("\n");
					break;
				}
			}
			if(draw) { out.append("D").append("\n"); }
		}
		
		System.out.println(out);
	}

}
