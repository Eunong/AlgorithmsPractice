package algorithms.leetcode.dp;

public class Test509_FibonacciNumber {
    public static int fib(int n) {
        if(n < 2) {
            return n;
        }

        int sum = 0;
        int preNum1 = 1; // 현재 숫자보다 1번째 전
        int preNum2 = 0; // 현재 숫자보다 2번째 전

        for(int i = 2; i <= n; i++) {
            sum = preNum1 + preNum2;
            preNum2 = preNum1;
            preNum1 = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + fib(2));
        System.out.println("TestCase2 : " + fib(3));
        System.out.println("TestCase3 : " + fib(6));
    }
}
