package algorithms.leetcode.dp;

public class Test1137_NthTribonacciNumber {
    public static int tribonacci(int n) {
        if(n < 2) {
            return n;
        }
        if(n == 2) {
            return 1;
        }

        int sum = 0;
        int preNum1 = 1; // 현재 숫자보다 1번째 전
        int preNum2 = 1; // 현재 숫자보다 2번째 전
        int preNum3 = 0; // 현재 숫자보다 3번째 전

        for(int i = 3; i <= n; i++) {
            sum = preNum1 + preNum2 + preNum3;
            preNum3 = preNum2;
            preNum2 = preNum1;
            preNum1 = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + tribonacci(4));
        System.out.println("TestCase2 : " + tribonacci(25));
    }
}
