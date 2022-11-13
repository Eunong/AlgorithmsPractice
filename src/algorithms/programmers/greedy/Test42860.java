package algorithms.programmers.greedy;

import java.util.Arrays;

// category : greedy
// 조이스틱
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// 참고 : https://hu-coding.tistory.com/m/121
public class Test42860 {
    public static int solution(String name) {
        int cnt = 0;

        int len = name.length();
        int minMove = len - 1; // case1) 계속 오른쪽으로만 이동(최대 좌우이동횟수) => 문자열의 길이 - 1

        char alphabet;

        for(int i = 0; i < len; i++) {
            alphabet = name.charAt(i);

            // 상하이동 계산 (A~Z까지 중 중간 알파벳 N)
            // (1) N보다 작으면 [Alphabet]-A
            // (2) N보다 크거나 같으면 Z-[Alphabet]+1
            if(alphabet < 'N') { // (1)
                cnt += alphabet - 'A';
            } else { // (2)
                cnt += 'Z' - alphabet + 1;
            }

            // 좌우이동 계산 - case1, case2 중 최소값 선택
            // case1) 계속 오른쪽으로만 이동 => 문자열의 길이 - 1
            // case2) 오른쪽으로 이동 중 A를 만나면 왼쪽으로 이동

            // 좌우 이동 계산
            int idx = i + 1;

            // 다음 글자가 A인 경우 idx 증가
            while(idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            
            // 좌우 이동 비교
            minMove = Math.min(minMove, i +(len-idx) + Math.min(i,len-idx));
        }
        
        return cnt + minMove;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("JEROEN")); // 56
        System.out.println("TestCase2 : " + solution("JAN")); // 23
        System.out.println("TestCase3 : " + solution("BBAABB")); // 8
    }
}
