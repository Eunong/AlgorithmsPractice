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
        int minMove = len - 1; // 계속 오른쪽으로만 이동(최대 좌우이동횟수) => 문자열의 길이 - 1

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

            // 좌우이동 계산 - 좌우 이동 횟수를 count 한다. A는 변경할 필요가 없으므로 A가 모여있는 곳으로는 이동하지 않아도 됨.
            // 아래 두 케이스 중 최소 경우를 선택한다.
            // (1) 좌측부터 A를 만날 때까지 전진한 후 다시 돌아와서 우측 끝으로 돌아가 A가 아닌 수까지 이동하는 경우
            // (2) 최초부터 우측 끝으로 돌아가 A가 아닌 수까지 이동한 후 다시 원점으로 돌아와 시작점부터 A가 아닌 문자까지 이동하는 경우
            int idx = i + 1;

            // 다음 글자가 A인 경우 idx 증가
            while(idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            
            // 좌우 이동 비교
            // i : 처음 위치부터 현재 문자열까지 오기 위한 횟수
            // len-idx : 바로 옆에 연결된 A를 제외한 현재 문자의 오른쪽 문자열의 길이
            // Math.min(i, len-idx) : 0 -> i까지 갔다가 다시 시작점으로 되돌아 오는 경우 또는 맨 처음부터 뒤로 갔다가 원점으로 되돌아오는 경우 중 빠른 경우 선택
            minMove = Math.min(minMove, i + (len-idx) + Math.min(i, len-idx));
        }
        
        return cnt + minMove;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("JEROEN")); // 56
        System.out.println("TestCase2 : " + solution("JAN")); // 23
        System.out.println("TestCase3 : " + solution("BBAABB")); // 8
        System.out.println("TestCase4 : " + solution("BBBBAAAABA")); // 12
        System.out.println("TestCase5 : " + solution("AAABBBBBBBAA")); // 16
        System.out.println("TestCase6 : " + solution("BBAABAB")); // 9
    }
}
