/**
 * 날짜 : 2021.08.21
 * 이름 : 임채은
 * 문제 : 백준 17413 - 단어 뒤집기2
 * 
 * 문자열 S가 주어졌을때, 이 문자열에서 단어만 뒤집는다. 알파벳은 소문자로 이루어져 있다.
 * 단, <> 안에 있는 문자열은 뒤집지 않는다!
 * a: 97, z: 122
 */
package silver.problem17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static String S;  // 문자열 S
	static Stack<Character> stack = new Stack<Character>();  // 거꾸로 출력할 단어를 저장하는 자료 구조
	static String tag;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		S = scan.nextLine();  // 문자열 저장하기
		
		for(int i=0; i<S.length(); i++) {
			char c = S.charAt(i);  // i번째 문자 가져오기
			if(c == ' ') {  // 공백이면 스택에 있는 문자 꺼내서 출력하기
				while(!stack.isEmpty()) { System.out.print(stack.pop()); }
				System.out.print(" ");
				continue;
			}
			if(c == '<') {  // 태그이면 
				while(!stack.isEmpty()) { System.out.print(stack.pop()); } // 스택에 있는 문자 꺼내서 출력하기
				for(int j=i; c != '>'; j++, i++) {  // 닫는 태그 만날때까지 출력하기
					c = S.charAt(j);  // j번째 문자 가져오기
					System.out.print(c);
				}
				i--;
				continue;
			}
			stack.push(c);  // 알파벳이나 숫자이면 스택에 문자 넣기
		}
		while(!stack.isEmpty()) { System.out.print(stack.pop()); }
	}
}
