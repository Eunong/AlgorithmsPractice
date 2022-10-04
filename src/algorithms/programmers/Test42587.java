package algorithms.programmers;

import javafx.scene.layout.Priority;

import java.util.*;

public class Test42587 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        List<Priority> list = new ArrayList<>();

        for(int i = 0; i < priorities.length; i++) {
            list.add(new Priority(i, priorities[i]));
        }

        System.out.println(list);

        while(!list.isEmpty()) {
            Priority prior = list.remove(0);

            if(list.stream().anyMatch(other -> prior.priority < other.priority)) { // 풀이 참조 : https://www.youtube.com/watch?v=cdgZ-lhHatM
                list.add(prior);
            } else {
                answer++;
                if(location == prior.location) {
                    break;
                }
            }
        }
        return answer;
    }

    public static class Priority {
        int location;
        int priority;

        public Priority(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println("TestCase1 : " + solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
