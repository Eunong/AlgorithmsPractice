package algorithms.programmers.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

// category : Exhaustive Search
// 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Test42840 {
    public static int[] solution(int[] answers) {
        int[] answerP1 = {1, 2, 3, 4, 5};
        int[] answerP2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answerP3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answerP1PatternLen = answerP1.length;
        int answerP2PatternLen = answerP2.length;
        int answerP3PatternLen = answerP3.length;

        int[] answerCount = new int[3]; // 1번, 2번, 3번 사람이 각각 정답을 맞춘 회수 저장

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == answerP1[i%answerP1PatternLen]) {
                answerCount[0]++;
            }
            if(answers[i] == answerP2[i%answerP2PatternLen]) {
                answerCount[1]++;
            }
            if(answers[i] == answerP3[i%answerP3PatternLen]) {
                answerCount[2]++;
            }
        }

        int max = Math.max(answerCount[0], Math.max(answerCount[1], answerCount[2]));

        List<Integer> list = new ArrayList<>();
        if(max == answerCount[0]) list.add(1);
        if(max == answerCount[1]) list.add(2);
        if(max == answerCount[2]) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{1,2,3,4,5}));
        System.out.println("TestCase2 : " + solution(new int[]{1,3,2,4,2}));
    }
}
