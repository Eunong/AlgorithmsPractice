package algorithms.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// category : heap
// 디스크 컨트롤러
// https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class Test42627 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int idx = 0;
        int cnt = 0; // 요청 갯수
        
        // 요청시간으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 우선순위 큐로 수행시간 짧은 순으로 정렬

        while(cnt < jobs.length) {
            // 작업 완료 시점까지 들어온 요청 add
            while(idx < jobs.length && jobs[idx][0] <= end) {
                heap.add(jobs[idx++]);
            }
            
            // 큐가 비어있으면 작업이 끝난 이후 요청이 들어온 것. end 초기화
            if(heap.isEmpty()) {
                end = jobs[idx][0];
            } else { // 수행시간 짧은 것부터 수행
                int[] tmp = heap.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                cnt++;
            }
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
