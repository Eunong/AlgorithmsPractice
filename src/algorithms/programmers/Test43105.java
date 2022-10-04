package algorithms.programmers;

public class Test43105 {
    public static int solution(int[][] triangle) {
        int max = 0;

        int[][] sum = new int[triangle.length][];

        sum[0] = new int[]{triangle[0][0]};

        for(int i = 1; i < triangle.length; i++) {
            sum[i] = new int[triangle[i].length];

            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) { // 제일 왼쪽 라인
                    sum[i][j] = sum[i-1][0];
                } else if(j == triangle[i].length-1) { // 제일 오른쪽 라인
                    sum[i][j] = sum[i-1][j-1];
                } else {
                    sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]);
                }

                sum[i][j] += triangle[i][j];

                max = Math.max(max, sum[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
