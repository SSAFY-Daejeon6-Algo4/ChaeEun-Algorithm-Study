/**
 * 날짜 : 2021.08.14
 * 이름 : 임채은
 * 문제 : 백준 2304 - 창고 다각형(S2)
 * 걸린 시간 : 4시간
 * 메모리 : 19984KB
 * 시간 : 284ms
 */
package problem2304;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon2304 {
	static class Bar implements Comparable<Bar> {  // 기둥 객체
		int l;  // 기둥의 왼쪽면의 위치
		int h;  // 기둥의 높이
		
		public Bar(int l, int h){  // Bar 생성자
			this.l = l;
			this.h = h;
		}
		
		@Override
		public int compareTo(Bar o) {  // 왼쪽면의 위치를 오름차순 하기 위한 비교 메소드
			if(this.l < o.l) return -1;
			else if(this.l == o.l) return 0;
			else return 1;
		}
	}
	
	static int N;  // 기둥의 개수
	static ArrayList<Bar> bars = new ArrayList<Bar>();  // 기둥의 정보를 담을 배열
	static ArrayList<Bar> tallestBar = new ArrayList<Bar>();  // 가장 긴기둥의 정보를 담을 배열
	
	public static void main(String[] args) {
		// 입력 받기
		Scanner scan = new Scanner(System.in);  // 입력을 받기 위한 변수
		N = scan.nextInt();  // 기둥의 개수 입력받아 저장하기
		int maxH = 0;  // 높이가 가장 긴 기둥의 길이
		for(int n=0; n<N; n++) {  // N개의 기둥 입력받기
			int L = scan.nextInt();  // 기둥의 왼쪽면의 위치 입력받기
			int H = scan.nextInt();  // 기둥의 높이 입력받기
			maxH = Math.max(H, maxH);  // 높이가 가장 긴 기둥의 길이 갱신하기
			bars.add(new Bar(L, H));  // 기둥의 왼쪽면의 위치, 높이 입력받아 배열에 추가하기
		}
		// 입력 완료
		// 알고리즘 시작 : 다각형의 면적 구하기
		Collections.sort(bars);  // 기둥 오름차순으로 정렬하기
		for(int n=0; n<N; n++) {  // 가장 긴기둥 구해서 배열에 담기
			if(maxH == bars.get(n).h) {
				tallestBar.add(new Bar(bars.get(n).l, bars.get(n).h));
			}
		}
		int sum = maxH * (tallestBar.get(tallestBar.size()-1).l+1 - tallestBar.get(0).l);  // 가장 긴 기둥들의 면적 구하기
		// 가장 긴 기둥의 왼쪽에 있는 기둥들의 면적 구하기
		Bar currentBar = bars.get(0);  // 현재 기둥을 첫번째 기둥으로 초기화하기
		for(int i=0; ; i++) {
			if(bars.get(i).h == maxH) {  // 새로운 기둥이 가장 긴 기둥일 경우
				if(currentBar.h == maxH) break;  // 현재 기둥이 가장 긴 기둥일 경우 break
				sum += currentBar.h * (bars.get(i).l - currentBar.l);  // 그게 아니면 새로운 기둥 이전의 면적 구하기
				break;
			}
			if(currentBar.h < bars.get(i).h) {  // 현재 기둥보다 새로운 기둥이 더 긴 경우
				sum += currentBar.h * (bars.get(i).l - currentBar.l);  // 새로운 기둥 이전의 면적 구하기
				currentBar = bars.get(i);  // 현재 기둥 갱신하기
			}
		}
		// 가장 긴 기둥의 오른쪽에 있는 기둥들의 면적 구하기
		currentBar = bars.get(bars.size()-1);  // 현재 기둥을 마지막 기둥으로 초기화하기
		for(int i=bars.size()-1; ;i--) {
			if(bars.get(i).h == maxH) {  // 새로운 기둥이 가장 긴 기둥일 경우
				if(currentBar.h == maxH) break;  // 현재 기둥이 가장 긴 기둥일 경우 break
				sum += currentBar.h * (currentBar.l - bars.get(i).l);  // 그게 아니면 새로운 기둥 이전의 면적 구하기
				break;
			}
			if(currentBar.h < bars.get(i).h) {  // 현재 기둥보다 새로운 기둥이 더 긴 경우
				sum += currentBar.h * (currentBar.l - bars.get(i).l);  // 새로운 기둥 이전의 면적 구하기
				currentBar = bars.get(i);  // 현재 기둥 갱신하기
			}
		}
		// 알고리즘 종료
		System.out.println(sum);
	}

}
