package algorithms.programmers;

import java.util.*;

public class Test42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int weightSum = 0;

        for(int i = 0; i < truck_weights.length; i++) {
            while(true) {
                // 큐가 비어있으면 트럭 삽입
                if(queue.isEmpty()) {
                    queue.add(truck_weights[i]);
                    weightSum += truck_weights[i];
                    answer++;
                    break;
                }

                // 다리만큼 다 건넌 경우 큐에서 빼고 무게 감소
                if(queue.size() == bridge_length) {
                    weightSum -= queue.poll();
                } else if(weightSum + truck_weights[i] > weight) {
                    queue.add(0);
                    answer++;
                } else {
                    queue.add(truck_weights[i]);
                    weightSum += truck_weights[i];
                    answer++;
                    break;
                }
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(2, 10, new int[] {7,4,5,6}));
    }
}
