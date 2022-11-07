package algorithms.programmers.dfsbfs;

import java.util.Arrays;

public class CombinationTest {
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 2;
        result = new int[r];
        visited = new boolean[n];

        System.out.println("combination");
        combination(arr, n, r, 0,0);

        System.out.println("repeatedCombination");
        repeatedCombination(arr, n, r, 0,0);
    }

    // 조합
    public static void combination(int[] arr, int n, int r, int cnt, int start) {
        if(cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = start; i < n; i++) {
            result[cnt] = arr[i];
            combination(arr, n, r, cnt+1, i+1);
        }
    }

    // 중복 조합
    public static void repeatedCombination(int[] arr, int n, int r, int cnt, int start) {
        if(cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = start; i < n; i++) {
            result[cnt] = arr[i];
            repeatedCombination(arr, n, r, cnt+1, i);
        }
    }
}
