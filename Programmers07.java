import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = speeds.length;  // 작업 개수
		int[] after = new int[len];  // 몇일후 완성하는지 저장하는 배열
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<len; i++) {  // 작업이 몇일 후 완성하는지 배열에 저정하기
			int remain = 100-progresses[i];  // 남은 퍼센트
			int day = remain / speeds[i];  // 몇일후 기능작업을 마치는지
			after[i] = (remain % speeds[i] == 0) ? day : day+1;  // 배열 저장하기
		}  // after = {5, 10, 1, 1, 20, 1}
		
		int cnt = 1;  // 배포하는 progress의 개수
		int max = after[0];  // 완성 가능한 일수 최대값
		for(int i=1; i<len; i++) {  // return 값 구하기
			if(max < after[i]) {
				max = after[i];
				result.add(cnt);
				cnt = 1;
			} else { cnt++; }
		}
		result.add(cnt);
		
		int[] answer = new int[result.size()];
		for(int i=0; i<answer.length; i++) {  // return값 배열로 변환하기
			answer[i] = result.get(i);
		}
        
        return answer;
    }
}
