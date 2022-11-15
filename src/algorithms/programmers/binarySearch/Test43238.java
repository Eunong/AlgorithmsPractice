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

            for(int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if(cnt < mid) {
                left = mid + 1;
            } else {
                right  = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(6, new int[]{7, 10})); // 28
        System.out.println("TestCase2 : " + solution(10, new int[]{6, 8, 10})); // 30
    }
}
