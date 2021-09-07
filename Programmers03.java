import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int M, N;  // 그림의 row 개수, col 개수
    static int[][] map;  // 그림
    static boolean[][] visited;  // 그림의 영역을 방문했는지 체크할 배열
    static ArrayList<Integer> arr;  // 모든 그림의 영역의 개수를 저장할 배열
    static int count;  // 그림의 영역의 개수
    
    public int[] solution(int m, int n, int[][] picture) {
        M = m;  // row 개수
		N = n;  // col 개수
		map = picture.clone();  // 그림
		visited = new boolean[m][n];  // 체크한 그림의 영역
		arr = new ArrayList<Integer>();  // 모든 그림의 영역의 개수
		
		// 그림의 영역 탐색하기
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) {
				 // 그림의 영역을 이미 확인했거나 값이 0인 경우, 다음 그림 영역으로
				if(visited[r][c] || map[r][c] == 0) { continue; }
				else {
					int number = map[r][c];  // 그림의 영역의 값
					count = 0;  // 그림의 영역의 개수
					Solve(r, c, number);  // 그림의 영역의 개수를 구하는 함수
					arr.add(count);  // 그림의 영역의 개수 추가하기
				}
			}
		}
        
        int[] answer = new int[2];
		answer[0] = arr.size();
		answer[1] = Collections.max(arr);
        return answer;
    }
    
    // 그림의 영역의 개수를 구하는 함수
	private static void Solve(int r, int c, int num) {
		 // 확인할 그림의 영역이 범위 안에 있고, 방문하지 않았으며, 확인하려는 그림의 영역의 값과 같다면
		if(isIn(r, c) && !visited[r][c] && map[r][c] == num) { 
			count++; // 그림의 영역의 개수 증가
			visited[r][c] = true;  // 방문 표시하기
			Solve(r-1, c, num);  // 상
			Solve(r+1, c, num);  // 하
			Solve(r, c-1, num);  // 좌
			Solve(r, c+1, num);  // 우
		} else {
			return;
		}
	}
	
	// 범위를 체크하는 함수
	private static boolean isIn(int r, int c) {
		return 0<=r && r<M && 0<=c && c<N;
	}
}
