import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean flag = false;
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();  // 우선순위큐
		for(int i=0; i < scoville.length; i++) {  // 스코빌 지수 우선순위 큐에 넣기
			priorityQueue.add(scoville[i]);
		}

		while(priorityQueue.size() != 1) {  // 큐의 원소가 1개 남을때까지 반복하기
			answer++;  // 섞은 횟수 증가시키기
			priorityQueue.add(priorityQueue.poll() + priorityQueue.poll()*2);  // 섞은 음식의 스코빌 지수 큐에 넣기
			if(priorityQueue.peek() >= K) {  // 섞은 음식이 K이상이면 그만 섞기
				flag = true;
				break;
			}
		}
		answer = (flag) ? answer : -1;

        return answer;
    }
}
