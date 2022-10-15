package algorithms.programmers.exhaustiveSearch;

// category : Exhaustive Search
// 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Test42842 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if((yellow%i == 0) && (yellow/i+2) * (i+2) == brown+yellow) {
                answer[0] = yellow/i+2;
                answer[1] = i+2;
                break;
            }
        }
        System.out.println("정답 : " + answer[0] + ", " + answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(10, 2));
        System.out.println("TestCase2 : " + solution(8, 1));
        System.out.println("TestCase3 : " + solution(24, 24));
        System.out.println("TestCase4 : " + solution(36, 64));
    }
}
