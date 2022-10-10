package algorithms.programmers;

import java.util.Arrays;

// category : sort
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class Test42748 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] arrayTmp;

        for(int i = 0; i < commands.length; i++) {
            arrayTmp = Arrays.copyOfRange(array, (commands[i][0])-1, (commands[i][1]));

            Arrays.sort(arrayTmp);
            answer[i] = arrayTmp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }
}
