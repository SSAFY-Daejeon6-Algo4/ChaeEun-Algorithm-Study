/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 2941 - 크로아티아 알파벳
 * 
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있을까?
 * c=, c-, dz=, d-, lj, nj, s=, z= 는 하나의 알파벳으로 간주
 */
package silver.problem2941;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static String str;  // 입력된 단어
	static Stack<Character> croatia = new Stack<Character>();  // 크로아티아 알파벳을 저장할 자료구조
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();  // 단어 입력받기
		
		// 알고리즘 시작 : 크로아티아 알파벳 수 구하기
		// 크리아티아 알파벳을 발견하면 C로 바꾸어서 저장
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(croatia.isEmpty()) { croatia.push(c); }  // 스택이 비어있으면 알파벳 넣기
			else {
				// 만약 크로아티아 알파벳이라면
				if(c == '=' && (croatia.peek() == 'c' ||
						        croatia.peek() == 's' ||
						        croatia.peek() == 'z'))  // c=, s=, z= 확인하기
				{
					char temp = croatia.pop();	
					if(!croatia.isEmpty() && temp == 'z' && croatia.peek() == 'd') { croatia.pop(); }
					croatia.push('C');
				}
				else if(c == '-' && (croatia.peek() == 'c' || croatia.peek() == 'd')) {  // c-, d- 확인하기
					croatia.pop();
					croatia.push('C');
					}
				else if(c == 'j' && (croatia.peek() == 'n' || croatia.peek() == 'l')) {  // nj, lj 확인하기
					croatia.pop();
					croatia.push('C');
					}
				// 만약 크로아티아 알파벳이 아니라면
				else { croatia.push(c); }
			}
		}
		// 알고리즘 종료
		
		System.out.println(croatia.size());
	}

}
