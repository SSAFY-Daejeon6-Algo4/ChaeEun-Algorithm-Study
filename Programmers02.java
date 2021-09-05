import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        
        ArrayList<String> records = new ArrayList<String>(Arrays.asList(record));

		// 유저의 최종 닉네임 해쉬맵에 저장하기
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i<records.size(); i++) {
			String[] arr = ((String) records.get(i)).split(" ");
			
			if(arr.length == 2) { continue; }  // 나가는 경우, 닉네임 갱신 안됨.
			if(arr[0].equals("Change")) {  // 변경하는 경우, 나중에 메시지 결과값에 출력이 안됨.
				records.remove(i--);
			}
			map.put(arr[1], arr[2]);
		}
		
		// 메시지 결과값 구하기
		answer = new String[records.size()];
		for(int i=0; i<records.size(); i++) {
			String[] arr = ((String) records.get(i)).split(" ");
			
			if(arr[0].equals("Enter")) {  // 들어왔습니다.
				answer[i] = String.format("%s님이 들어왔습니다.", map.get(arr[1]));
			} else {  // 나갔습니다.
				answer[i] = String.format("%s님이 나갔습니다.", map.get(arr[1]));
			}
		}
                                                         
        return answer;
    }
}
