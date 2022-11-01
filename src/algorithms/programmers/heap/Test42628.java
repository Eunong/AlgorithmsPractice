package algorithms.programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// category : heap
// 이중우선순위큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42628
public class Test42628 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        // heap은 root 노드만 정렬이 됨. 최소, 최대 기준으로 queue 각각 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        String[] split;
        int min;
        int max;

        for(String operation : operations) {
            split = operation.split(" ");

            if("I".equals(split[0])) { // I 숫자
                minHeap.add(Integer.parseInt(split[1]));
                maxHeap.add(Integer.parseInt(split[1]));
            } else if(!minHeap.isEmpty() && "-1".equals(split[1])){ // D -1
                min = minHeap.poll();
                maxHeap.remove(min);
            } else if(!maxHeap.isEmpty() && "1".equals(split[1])) { // D 1
                max = maxHeap.poll();
                minHeap.remove(max);
            }
        }

        answer[0] = (maxHeap.peek() == null) ? 0 : maxHeap.peek();
        answer[1] = (minHeap.peek() == null) ? 0 : minHeap.peek();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        System.out.println("TestCase2 : " + solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
}
