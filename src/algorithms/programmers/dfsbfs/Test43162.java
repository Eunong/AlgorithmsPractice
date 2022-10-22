package algorithms.programmers.dfsbfs;

// category : DFS/BFS
// 네트워크
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Test43162 {

    // 연결요소를 구하는 문제 (dfs를 몇 번 시작했는지 확인)
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n]; // dfs 방문 여부 체크용
        
        // 그래프가 단방향일 경우 양방향 연결로 바꿔줌 -> 테스트케이스 양방향으로 주어져서 생략
        /*for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers.length; j++) {
                if(i!=j && computers[i][j]+computers[j][i]==1) {
                    computers[i][j] = computers[j][i] = 1;
                }
            }
        }*/
        for(int i = 0; i < check.length; i++) { // 모든 노드를 방문할 때까지 dfs를 계속하고 dfs 수행 시작 회수를 합산해서 리턴
            if(!check[i]) {
                answer += dfs(computers, i, n, check);
            }
        }

        return answer;
    }

    static int dfs(int[][] computers, int x, int n, boolean[] check) {
        check[x] = true;
        for(int i = 0; i < n; i++) {
            if(computers[x][i] == 1 && !check[i]) {
                dfs(computers, i, n, check);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println("TestCase2 : " + solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println("TestCase3 : " + solution(1, new int[][]{{1}}));
        System.out.println("TestCase4 : " + solution(3, new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}));
        System.out.println("TestCase5 : " + solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}));
        System.out.println("TestCase6 : " + solution(4, new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
        System.out.println("TestCase7 : " + solution(3, new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 0, 1}}));
        // 만약 문제에서 단방향도 연결된 것으로 봐야 한다면 아래 케이스의 output은 1이 되어야 함
        System.out.println("TestCase8 : " + solution(5, new int[][] {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 0, 1}}));

    }
}
