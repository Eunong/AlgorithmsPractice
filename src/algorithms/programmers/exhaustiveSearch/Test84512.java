package algorithms.programmers.exhaustiveSearch;

// category : Exhaustive Search
// 모음사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Test84512 {
    public static int solution(String word) {
        int answer = word.length();

        String alphabet = "AEIOU";
        int[] n = {781, 156, 31, 6, 1};

        for(int i = 0; i < word.length(); i++) {
            answer += n[i] * alphabet.indexOf(word.charAt(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("AAAAE"));
        System.out.println("TestCase2 : " + solution("AAAE"));
        System.out.println("TestCase3 : " + solution("I"));
        System.out.println("TestCase4 : " + solution("1189"));
    }
}
