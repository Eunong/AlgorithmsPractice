package algorithms.programmers.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

// category : Exhaustive Search
// 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class Test86971 {
    static List<Integer>[] list;
    static boolean[] check;
    static int visitedCnt;

    public static int solution(int n, int[][] wires) {
        int min = n; // 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값) 최소값 저장

        // 한 개씩 연결 노드 제외하고 최소값 계산
        for(int d = 0; d < wires.length; d++) {
            check = new boolean[n + 1];

            // 입력 배열을 양방향 연결된 인접리스트 형태의 그래프로 표현
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < wires.length; i++) {
                // 인접리스트에 저장 시 한 노드 씩 연결이 끊어졌다고 가정하고 인접리스트 저장 skip (wires 0~n-1번까지 저장 skip 반복)
                if (i == d) {
                    continue;
                }
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            List<Integer> visitedCntList = new ArrayList<>();

            // 모든 노드를 다 탐색할 때까지 dps 반복
            for (int i = 1; i <= n; i++) {
                boolean isVisitedAllNode = true; // 모든 노드를 다 반복했는지 여부

                visitedCnt = 0;
                dfs(i);

                // dps 여러 번 수행한 경우 수행했을 때마다 각각 몇 개의 노드를 방문했는지 저장함
                if(visitedCnt != 0) {
                    visitedCntList.add(visitedCnt); // 1개 이상 방문한 경우 두 전력망이 가지고 있는 송전탑 갯수의 차이를 구하기 위해 list에 저장
                }

                // 모두 다 방문했을 경우에는 dfs 종료 -> 체크로직 빼는게 속도 더 빠름
                /*
                for (int j = 1; j <= n; j++) {
                    if (!check[j]) {
                        isVisitedAllNode = false;
                        break;
                    }
                }
                if(isVisitedAllNode) {
                    break;
                }
                 */
            }

            min = Math.min(min, Math.abs(visitedCntList.get(0) - visitedCntList.get(1)));

            System.out.println("visitedCntList : " + visitedCntList);
            System.out.println("min : " + min);
        }

        return min;
    }

    public static void dfs(int n) {
        // 방문한 node이면 종료
        if(check[n]) {
            return;
        }

        check[n] = true;
        visitedCnt++;

        for(int x : list[n]) {
            if(!check[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
        System.out.println("TestCase2 : " + solution(4, new int[][]{{1,2},{2,3},{3,4}})); // 0
        System.out.println("TestCase3 : " + solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})); // 1
    }
}
