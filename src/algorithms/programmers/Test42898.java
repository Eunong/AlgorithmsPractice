package algorithms.programmers;

public class Test42898 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        map[0][0] = 1;

        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) {
                    continue;
                }

                if(j-1 >= 0 && map[i][j-1] > -1) {
                    map[i][j] += map[i][j-1];
                }
                if(i-1 >= 0 && map[i-1][j] > -1) {
                    map[i][j]+= map[i-1][j];
                }

                if(map[i][j] > 1000000007) {
                    map[i][j] %= 1000000007;
                }

            }
        }

        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(4, 3, new int[][]{{2, 2}}));
    }

}
