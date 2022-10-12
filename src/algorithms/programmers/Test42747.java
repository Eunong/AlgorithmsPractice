package algorithms.programmers;

import java.util.Arrays;

// category : sort
// H-Index
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class Test42747 {
    public static int solution(int[] citations) {
        int cnt[] = new int[10001]; // 논문별 인용 횟수는 0회 이상 10,000회 이하입니다. => 0회부터 10,000회까지 각 횟수 별 논문 인용 건수를 저장하기 위한 배열 선언

        // i번 인용된 논문의 건수 구하기
        // 예) input : {3, 0, 6, 1, 5} / cnt[] : {5, 4, 3, 3, 2, 1, 0, 0, ....} (0회 인용 논문 : 5건, 1회 인용 논문 : 4건, 2회 인용 논문 : 3건, ...)
        for(int i = 0; i < citations.length; i++) {
            for(int j = 0; j <= citations[i]; j++) {
                cnt[j]++;
            }
        }

        // 가장 많이 인용될 수 있는 횟수부터 H-Index인지 검사해서 맞을 경우 리턴
        Arrays.sort(citations);

        int maxNum = citations[citations.length-1];
        for(int i = maxNum; i >= 0; i--) {
            if(cnt[i] >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println("TestCase2 : " + solution(new int[]{1, 2}));
        System.out.println("TestCase3 : " + solution(new int[]{0, 0, 1}));
    }
}
