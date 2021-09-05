import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        int N = len / 2;
        
        if(len == 1) {
        	answer = 1;
        } else {
            // i개 단위로 자르고 마지막에 남은 문자열 그대로 붙여주기
            Queue<String> queue = new LinkedList<>();
            for(int i=N; i>0; i--) {
            	// 문자 i개 단위로 잘라서 배열에 저장
            	for(int k=0; ; k++) {
            		if((k+1)*i >= len) {
            			queue.offer(s.substring(k*i));
            			break;
            		} else {
            			queue.offer(s.substring(k*i, (k+1)*i));			
            		}
            	}
            	
            	String result = "";  // 압축한 문자열
            	String str1, str2;
            	int number = 1;
            	// 저장한 배열 비교하여 압축하기
            	while(queue.size() != 1) {
            		str1 = queue.poll();
            		str2 = queue.peek();
            		
            		if(str1.equals(str2)) {  // 앞뒤 문자가 같으면 압축하기
            			number++;
            		} else {  // 앞뒤 문자가 다르면 그대로 붙이기
            			if(number > 1) {  // 전에압축한 문자가 있다면
            				result = result + number + str1;
            				number = 1;
            				
            			} else {
            				result = result + str1;	
            			}
            		}
            	}
            	str1 = queue.poll();
            	result = (number > 1) ? result + number + str1 : result + str1;
    			answer = (result.length() < answer) ? result.length() : answer;
            }
        }
        
        return answer;
    }
}
