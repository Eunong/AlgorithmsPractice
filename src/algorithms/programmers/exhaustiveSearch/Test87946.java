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
        max = 0;
        boolean[] check = new boolean[dungeons.length];
        remaining = k;

        dfs(k, dungeons, check, 0);
        // permutation(k, dungeons, check, 0, dungeons.length, dungeons.length);

        return max;
    }

    public static void dfs(int k, int[][] dungeons, boolean[] check, int cnt) { // 3개 순열로 선택
        if(max == dungeons.length) { // 최대만큼 탐험했을 경우 더 이상 탐색하지 않음
            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(!check[i] && dungeons[i][0] <= k) {
                check[i] = true;
                dfs(k-dungeons[i][1], dungeons, check, cnt+1);
                check[i] = false;
            }
        }

        max = Math.max(cnt, max);
    }

    public static void permutation(int k, int[][] dungeons, boolean[] check, int depth, int n, int r) {
        if(max == n) { // 최대만큼 탐험했을 경우 종료
            return;
        }
        if(depth == r) { // 모두 탐험했을 경우 종료
            max = Math.max(visitCnt, max);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                int minus = 0;
                check[i] = true;

                if(dungeons[i][0] <= remaining) {
                    visitCnt++;
                    remaining -= dungeons[i][1];
                    minus = dungeons[i][1];
                }
                permutation(k, dungeons, check, depth+1, n, r);
                check[i] = false;
                remaining += minus;
                if(dungeons[i][0] <= remaining) {
                    visitCnt--;
                }

            }
        }

    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}})); // 3
        System.out.println("TestCase2 : " + solution(80, new int[][]{{100, 20}, {50, 40}, {80, 10}})); // 2
        System.out.println("TestCase3 : " + solution(80, new int[][]{{100, 20}, {100, 40}, {100, 10}})); // 0
    }
}
