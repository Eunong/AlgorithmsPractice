package algorithms.programmers.graph;

// category : graph
// 순위
// https://school.programmers.co.kr/learn/courses/30/lessons/49191
public class Test49191 {
    public static int solution(int n, int[][] results) {
        int answer = 0;

        int[][] floyd = new int[n+1][n+1];
        
        // 선수 수 만큼 2차원 배열을 만들어서 floyd[i][j] 관계가 이겼으면 1, 졌으면 -1 기록
        for(int i = 0; i < results.length; i++) {
            floyd[results[i][0]][results[i][1]] = 1;
            floyd[results[i][1]][results[i][0]] = -1;
        }

        // 플로이드-워셜 알고리즘
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(i == j || i == k) {
                        continue;
                    }
                    if(floyd[i][k]==1 && floyd[k][j]==1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    if(floyd[i][k]==-1 && floyd[k][j]==-1) {
                        floyd[j][i] = 1;
                        floyd[i][j] = -1;
                    }
                }
            }
        }

        for(int i = 1; i < floyd.length; i++) {
            for(int j = 1; j < floyd[i].length; j++) {
                System.out.print(floyd[i][j] + " " );
            }
            System.out.println();
        }
        
        // 선수 n-1 개 만큼 경기 결과가 확인되면 최종적으로 경기 결과를 알 수 있는 것
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(floyd[i][j] != 0) {
                    cnt++;
                }
            }

            if(cnt == n-1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
