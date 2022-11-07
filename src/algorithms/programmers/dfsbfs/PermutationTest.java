package algorithms.programmers.dfsbfs;

import java.util.Arrays;

public class PermutationTest {
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 2;
        result = new int[r];
        visited = new boolean[n];

        System.out.println("permutation");
        permutation(arr, n, r, 0);

        System.out.println("repeatedPermutation");
        repeatedPermutation(arr, n, r, 0);
    }

    // 순열
    public static void permutation(int[] arr, int n, int r, int cnt) {
        if(cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[cnt] = arr[i];
                permutation(arr, n, r, cnt+1);
                visited[i] = false;
            }
        }
    }

    // 중복 순열
    public static void repeatedPermutation(int[] arr, int n, int r, int cnt) {
        if(cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = 0; i < n; i++) {
            result[cnt] = arr[i];
            repeatedPermutation(arr, n, r, cnt+1);
        }
    }

}
