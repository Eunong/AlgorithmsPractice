package algorithms.leetcode.dp;

public class Test746_MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i<2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]); // 한 번에 한 칸 또는 두 칸 오를 수 있기 때문에 dp[i-1], dp[i-2] 중 최소값 선택 후 현재 계단 비용을 더함
            }
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println("TestCase2 : " + minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
