package algorithms.leetcode.dp;

public class Test1025_DivisorGame {
    public static boolean divisorGame(int n) {
//        if(n == 1) {
//            return false;
//        }
//
//        int[] dp = new int[n+1];
//        dp[1] = 0;
//
//        for(int i = 2; i <= n; i++) {
//            int max = 0;
//            for(int j = 1; i%j == 0 && j < i; j++) {
//                dp[i] = Math.max(max, 1 + dp[i-j]);
//                max = Math.max(max, dp[i]);
//            }
//        }
//
//        return dp[n]%2==0 ? false : true;

        return n%2==0;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + divisorGame(1));
        System.out.println("TestCase2 : " + divisorGame(2));
        System.out.println("TestCase3 : " + divisorGame(3));
        System.out.println("TestCase4 : " + divisorGame(4));
        System.out.println("TestCase5 : " + divisorGame(5));
    }
}
