package algorithms.programmers;

// 최대공약수와 최소공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/12940
public class Test12940 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);

        answer[0] = gcd; // 최대공약수
        answer[1] = n*m/gcd;// 최소공배수

        return answer;
    }
    
    // 최대공약수 (유클리드호제법 사용)
    public static int gcd(int n, int m) {
        while(m != 0) {
            int r = n%m;
            n = m;
            m = r;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(3, 12));
        System.out.println("TestCase2 : " + solution(2, 5));
    }
}
