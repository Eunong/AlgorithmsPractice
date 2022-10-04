package algorithms.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test42895 {
    public static int solution(int N, int number) {
        // 풀이 참조 https://small-stap.tistory.com/65
        // dp[i] = N을 i번 사용했을 때 만들 수 있는 수 (i개의 N으로 만들 수 있는 수)

        if(N == number) { // N과 number이 같은 경우 1번만에 바로 만들 수 있음
            return 1;
        }

        int maxCnt = 8;

        int[] dp = new int[maxCnt]; // 최솟값이 8보다 크면 -1을 return

        dp[0] = N; // 1개의 N으로 만들 수 있는 수는 N 뿐
        // 2개의 N으로 만들 수 있는 수 : [NN] or [N 연산자 N]
        // 3개의 N으로 만들 수 있는 수 : [NNN] OR [N 연산자 NN] OR [NN 연산자 N] OR [N 연산자 N 연산자 N]
        // dp[i] = NNN... i 개 붙여서 만든 수 + dp[1]사칙연산dp[i-1] + dp[2]사칙연산dp[i-2]... + dp[i]사칙연산dp[i-i]

        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= maxCnt; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N); // N을 1개 사용하여 만들 수 있는 값은 N임


        for(int i = 2; i <= maxCnt; i++) {
            Set<Integer> set = list.get(i);

            int repeatNum = 0;
            int tmp = 1;

            for(int j = 1; j <= i; j++) {
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i-j);

                for(int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if(postNum != 0) {
                            set.add(preNum / postNum);
                        }
                    }
                }

                repeatNum += N*tmp;
                tmp *= 10;
            }
            set.add(repeatNum);

            for(int setNum : set) {
                if(number == setNum) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(5, 12));
        System.out.println("TestCase2 : " + solution(2, 11));
        System.out.println("TestCase3 : " + solution(5, 5));
    }
}
