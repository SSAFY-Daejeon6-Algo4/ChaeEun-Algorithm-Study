import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 날짜 : 2021.08.28
 * 이름 : 임채은
 * 문제 : 백준 2164 - 카드2
 * 
 * 문제 풀이
 * step1. N장의 카드를 순서대로 Queue에 넣기 (1~N)
 * step2. 한장의 카드 dequeue 하기
 * step3. 한장의 카드 dequeue 하고, dequeue한 카드 enqueue 하기
 * step4. Queue에 한장의 카드가 남을때까지 step2~3 반복하기
 */


public class BaekJoon2164 {
	static int N;  // 카드의 개수
	static Queue<Integer> cards = new LinkedList<>();  // 카드를 저장할 큐
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		for(int n=1; n<=N; n++) {  // step1. N장의 카드를 순서대로 Queue에 넣기
			cards.offer(n);
		}
		
		// step4. Queue에 한장의 카드가 남을때까지 step2~3 반복하기
		while(cards.size() != 1) {
			cards.poll();  // step2. 한장의 카드 dequeue 하기
			cards.offer(cards.poll());  // step3. 한장의 카드 dequeue 하고, dequeue한 카드 enqueue 하기
		}
		
		System.out.println(cards.peek());
	}

}
