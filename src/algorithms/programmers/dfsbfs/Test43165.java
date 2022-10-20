package algorithms.programmers.dfsbfs;

// category : DFS/BFS
// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Test43165 {
    static int cnt;
    static int[] numbers;
    static int target;

    public static int solution(int[] numbers, int target) {
        /*cnt = 0;
        numbers = numbers;
        target  = target;
         dfs(0,0)*/;

        int answer = dfs2(numbers, 0, 0, target);
        return answer;
    }

    // sample answer
    public static int dfs2(int[] numbers, int d, int sum, int target) {
        if(d == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs2(numbers, d+1, sum+numbers[d], target) + dfs2(numbers, d+1, sum-numbers[d], target);
    }

    public static void dfs(int d, int sum) {
        if(d == numbers.length) {
            if(target == sum) {
                cnt++;
            }
            return;
        }
        dfs(d+1, sum+numbers[d]);
        dfs(d+1, sum-numbers[d]);
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("TestCase2 : " + solution(new int[]{4, 1, 2, 1}, 2));
        System.out.println("TestCase3 : " + solution(new int[]{4, 1, 2}, 2));
    }
}
