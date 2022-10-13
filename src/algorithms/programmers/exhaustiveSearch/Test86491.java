package algorithms.programmers.exhaustiveSearch;

// category : Exhaustive Search
// 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Test86491 {
    public static int solution(int[][] sizes) {
        int maxWidth  = 0;
        int maxHeight = 0;

        for(int i = 0; i < sizes.length; i++) {
            int maxNumIdx = (sizes[i][0] > sizes[i][1]) ? 0 : 1;
            maxWidth  = Math.max(maxWidth, sizes[i][maxNumIdx]);
            maxHeight = Math.max(maxHeight, sizes[i][1-maxNumIdx]);
        }
        return maxWidth * maxHeight;
        
        // 내 풀이랑 유사한 풀이
        /*
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
        */
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println("TestCase2 : " + solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println("TestCase3 : " + solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
