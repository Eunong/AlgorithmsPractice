package algorithms.leetcode.dp;

public class Test338_CountingBits {
    public static int[] countBits(int n) {
        // dp[i] = dp[i-offset] + 1
        /*
        int[] dp = new int[n+1];
        int offset = 1;

        for(int i = 1; i < n+1; i++) {
            if(offset * 2 == i) {
                offset *= 2;
            }
            dp[i] = dp[i-offset] + 1;
        }

        return dp;
        */

        // f[i] = f[i / 2] + i % 2.
        int[] dp = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            dp[i] = dp[i/2] + i%2;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + countBits(2));
        System.out.println("TestCase2 : " + countBits(5));
    }
}
