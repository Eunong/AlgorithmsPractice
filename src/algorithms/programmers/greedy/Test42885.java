package algorithms.programmers.greedy;

import java.util.Arrays;

// category : greedy
// 구명보트
// https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Test42885 {
    public static int solution(int[] people, int limit) {
        int cnt = 0;
        int max = 0; // 인원수는 최대 두명까지

        Arrays.sort(people);

        for (int i = people.length-1; i >= max; i--) {
            if(people[i] + people[max] <= limit) {
                max++;
            }
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println("TestCase2 : " + solution(new int[]{70, 80, 50}, 100)); // 3
        System.out.println("TestCase3 : " + solution(new int[]{80, 70, 30}, 100)); // 2
        System.out.println("TestCase4 : " + solution(new int[]{100, 100, 100}, 100)); // 3
        System.out.println("TestCase5 : " + solution(new int[]{10, 20, 30, 10, 30}, 100)); // 3
    }
}
