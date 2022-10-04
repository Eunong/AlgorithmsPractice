package algorithms.leetcode.dp;

public class Test1646_GetMaximuminGeneratedArray {
    public static int getMaximumGenerated(int n) {
        if(n < 2) {
            return n;
        }

        int max = 1;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

//        for(int i = 2; i <= n; i++) {
//            if(i%2==0) {
//                dp[i] = dp[i/2];
//            } else {
//                dp[i] = dp[i/2] + dp[i/2+1];
//            }
//
//            max = Math.max(max, dp[i]);
//        }

        // simple solution
        for(int i = 1; i*2+1 <= n; i++) {
            dp[i*2] = dp[i];
            dp[i*2+1] = dp[i] + dp[i+1];

            max = Math.max(max, dp[i*2+1]);
        }

        for(int i = 0; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + getMaximumGenerated(0));
        System.out.println("TestCase2 : " + getMaximumGenerated(7));
        System.out.println("TestCase3 : " + getMaximumGenerated(15));
    }
}
