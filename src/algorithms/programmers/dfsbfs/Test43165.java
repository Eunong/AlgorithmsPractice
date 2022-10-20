package algorithms.programmers.dfsbfs;

// category : DFS/BFS
// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Test43165 {
    static int cnt = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }

    public static void dfs(int[] numbers, int d, int target, int sum) {
        if(d == numbers.length) {
            if(target == sum) {
                cnt++;
            }
            return;
        }
        dfs(numbers, d+1, target, sum+numbers[d]);
        dfs(numbers, d+1, target, sum-numbers[d]);
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("TestCase2 : " + solution(new int[]{4, 1, 2, 1}, 2));
    }
}
