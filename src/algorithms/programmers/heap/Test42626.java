package algorithms.programmers.heap;

import java.util.PriorityQueue;

// category : heap
// 더 맵게
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class Test42626 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 우선순위 큐로 최소힙
        for(int n : scoville) {
            minHeap.add(n);
        }

        int min1 = 0;
        int min2 = 0;
        int cnt  = 0;

        while(minHeap.peek() <= K && minHeap.size() > 1) {
            System.out.println("min : " + minHeap.peek());
            min1 = minHeap.poll();
            min2 = minHeap.poll();
            minHeap.add(min1 + min2*2);
            cnt++;
        }

        if(minHeap.peek() < K) {
            return -1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
