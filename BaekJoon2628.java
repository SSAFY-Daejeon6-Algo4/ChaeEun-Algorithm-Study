/**
 * 날짜 : 2021.08.14
 * 이름 : 임채은
 * 문제 : 백준 2628 - 종이자르기(S4)
 * 걸린 시간 : 2시간
 * 메모리 : 17736KB
 * 시간 : 248ms
 */
package problem2628;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon2628 {
	static int W, H, N;  // 종이의 가로길이, 세로길이, 칼로 잘라야하는 점선의 개수
	static ArrayList<Integer> wArray, hArray;  // 가로로 자르는 점선의 번호를 담을 배열, 세로로 자르는 점선의 번호를 담을 배열
	static int maxW, maxH;  // 가로가 가장 긴 변의 길이, 세로가 가장 긴 변의 길이
	static int answer;  // 가장 큰 종이 조각의 넓이
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // 입력을 받기 위한 변수
		wArray = new ArrayList<Integer>();  // 가로로 자르는 점선의 번호를 담을 배열 초기화
		hArray = new ArrayList<Integer>();  // 세로로 자르는 점선의 번호를 담을 배열 초기화
		answer = 0;  // 가장 큰 종이 조각의 넓이 초기화
		// 입력 받기
		W = scan.nextInt();  // 종이의 가로길이 입력받아서 저장하기
		H = scan.nextInt();  // 종이의 세로길이 입력받아서 저장하기
		N = scan.nextInt();  // 칼로 잘라야하는 점선의 개수 입력받아서 저장하기
		for(int n=0; n<N; n++) {  // 칼로 종이 자르기
			int number = scan.nextInt();  // 가로(0)로 자를지 세로(1)로 자를지 입력받아 저장하기
			int value = scan.nextInt();  // 몇번째 번호를 자를지 입력받아 저장하기
			if(number == 0) { wArray.add(value); }  // 가로로 자른다면 가로 점선 번호를 담는 배열에 추가하기
			else { hArray.add(value); }  // 세로로 자른다면 세로 점선 번호를 담는 배열에 추가하기
		}
		// 입력 완료
		// 알고리즘 시작 : 가장 큰 종이 조각의 넓이 구하기
		// 가로로 잘랐을때, 세로가 가장 긴 변의 길이 구하기
		if(wArray.size() > 0) {  // 가로로 자른 경우가 있을때
			Collections.sort(wArray);  // 가로로 자른 점선 번호 정렬하기
			maxH = wArray.get(0);  // 세로가 가장 긴 변의 길이 초기화
			for(int w=1; w<wArray.size(); w++) {  // 가로로 순서대로 자르기
				int len = wArray.get(w) - wArray.get(w-1);  // 가로로 잘랐을때, 생성된 변의 길이
				maxH = Math.max(len, maxH); // 세로가 가장 긴 변의 길이 갱신하기
			}
			maxH = Math.max(H - wArray.get(wArray.size()-1), maxH);  // 마지막 변의 길이 확인해서 세로가 가장 긴 변의 길이 갱신하기
		} else { maxH = H; }  // 가로로 자른 경우가 없을때, 종이의 세로 길이가 가장 긴 길이 
		// 세로로 잘랐을때, 가로가 가장 긴 변의 길이 구하기
		if(hArray.size() > 0) {  // 세로로 자른 경우가 있을때
			Collections.sort(hArray);  // 세로로 자른 점선 번호 정렬하기
			maxW = hArray.get(0);  // 가로가 가장 긴 변의 길이 초기화
			for(int h=1; h<hArray.size(); h++) {  // 세로로 순서대로 자르기
				int len = hArray.get(h) - hArray.get(h-1);  // 세로로 잘랐을때, 생성된 변의 길이
				maxW = Math.max(len, maxW);// 가로가 가장 긴 변의 길이 갱신하기
			}
			maxW = Math.max(W - hArray.get(hArray.size()-1), maxW);  // 마지막 변의 길이 확인해서 세로가 가장 긴 변의 길이 갱신하기	
		} else { maxW = W; }  // 세로로 자른 경우가 없을때, 종이의 가로 길이가 가장 긴 길이 
		answer = maxH * maxW;  // 가장 큰 종이 조각의 넓이 구하기
		// 알고리즘 종료
		System.out.println(answer);
	}
	
}
