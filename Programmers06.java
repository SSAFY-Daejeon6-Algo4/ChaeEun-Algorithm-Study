import java.util.Arrays;

class Solution {
    // 중복 순열
    // NㅠR : 3ㅠR
	static int N, R, O, order;
	static int[] input = {1, 2, 4};
	static int[] numbers;
    
    public String solution(int n) {
		String answer;
		
		switch(n) {
		case 1: answer = "1"; break;
		case 2: answer = "2"; break;
		case 3: answer = "4"; break;
		default:
			N = 3;
			R = findR(n);  // 몇개의 숫자로 만들 수 있는지 
			numbers = new int[R];  // 중복순열저장
			
			order = 0;
			permutationR(0);
			answer = Arrays.toString(numbers).replaceAll("[^0-9]", "");
			break;
		}
        
        return answer;
    }
    
	// 몇개의 숫자로 만들 수 있는지 구하는 함수
	private static int findR(int n) {
		int r = 2;
		int start = (int)Math.pow(N, r-1);
		int end = start + (int)Math.pow(N, r);

		while(true) {
			if(start < n && n <= end) {
				O = n - start;
				return r;
			}
			r++;
			start = end;
			end += (int)Math.pow(N, r);
		}
	}
	
	// 중복 순열
	private static boolean permutationR(int cnt) {
		if(cnt == R) {  // R개를 뽑음
			order++;
			if(order == O) { return true; }
			return false;
		}
		
		for(int i=0; i<N; i++) {
			numbers[cnt] = input[i];
			if(permutationR(cnt+1)) { return true; }
		}
		return false;
	}
}
