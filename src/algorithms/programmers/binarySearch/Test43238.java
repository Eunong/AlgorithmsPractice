package algorithms.programmers.binarySearch;

import java.util.Arrays;

// category : 이분탐색
// 입국심사
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class Test43238 {
    public static long solution(int n, int[] times) {
        long answer = 0;

        // 심사 시간이 빠른 순으로 오름차순 정렬
        Arrays.sort(times);

        // 이분탐색을 위한 left, right, mid 선언
        long left  = 1; // n명이 입국심사를 받는데 걸릴 수 있는 최소 시간
        long right = (long) times[times.length-1] * n; // n명이 입국심사를 받을 경우 최대로 걸릴 수 있는 시간
        long mid;

        long cnt; // 심사 완료한 인원수

        while(left <= right) {
            mid = (left + right) / 2;

            cnt = 0;

            // 이진탐색 수행하는 mid분 동안 심사위원이 심사할 수 있는 최대 명수 구함
            // 각 심사위원 별로 mid분 동안 심사할 수 있는 명수를 구하기 위해 -> (mid / times[i]) 한 후 누적 심사 완료 인원 cnt에 합산한다.
            for(int i = 0; i < times.length; i++) {
                cnt += (mid / times[i]);
            }

            if(cnt < n) { // 심사 완료한 인원이 대기인원보다 적을 경우 : 소요시간 증가시키고 재 탐색
                left = mid + 1;
            } else { // 심사 완료한 인원이 대기인원보다 클 경우 : 소요시간 감소시키고 재 탐색
                right  = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(6, new int[]{7, 10})); // 28
        System.out.println("TestCase2 : " + solution(10, new int[]{6, 8, 10})); // 30
        System.out.println("TestCase3 : " + solution(3, new int[]{1, 1, 10})); // 2
    }
}
