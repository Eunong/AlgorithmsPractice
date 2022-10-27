package algorithms.programmers.exhaustiveSearch;

// category : Exhaustive Search
// 피로도
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Test87946 {
    static int visitCnt;
    static int max;
    static int remaining;

    public static int solution(int k, int[][] dungeons) {
        visitCnt = 0;
        max = -1;
        int answer = -1;

        boolean[] check = new boolean[dungeons.length];
        remaining = k;

        permutation(k, dungeons, check, 0, dungeons.length, dungeons.length);

        return answer;
    }

    public static void permutation(int k, int[][] dungeons, boolean[] check, int depth, int n, int r) {
        if(depth == r) {
            System.out.println("depth : " + depth + ", r : " + r);
            remaining = k;
            max = (visitCnt > max) ? visitCnt : max;
        }

        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                check[i] = true;
                if(dungeons[i][0] <= remaining) {
                    remaining -= dungeons[i][1];
                    visitCnt++;
                }
                permutation(k, dungeons, check, depth+1, n, r);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
