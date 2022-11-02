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
        int answer = -1;

        check = new boolean[n+1];

        // 1. 입력 배열을 양방향 연결된 인접리스트 형태의 그래프로 표현
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        int cnt = 0;
        int min = n; // 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값) 최소값 저장

        List<Integer> visitedCntList = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            int visitedNode = 0;
            cnt++;
            visitedCnt = 0;
            dfs(i);
            visitedCntList.add(visitedCnt);
            
            // 모두 다 방문했을 경우에는 dfs 종료
            for(int j = 1; j <= n; j++) {
                if(!check[j]) {
                    break;
                }
                visitedNode++;
            }

            if(visitedNode==n) {
                break;
            }
        }

        min = Math.min(min, Math.abs(visitedCntList.get(0)-visitedCntList.get(1)));


        System.out.println("visitedCntList : " + visitedCntList);
        System.out.println("cnt : " + cnt);
        System.out.println("min : " + min);




        return min;
    }

    public static void dfs(int n) {
        // 방문한 node이면 종료
        if(check[n]) {
            return;
        }

        check[n] = true;
        visitedCnt++;
        System.out.print(n + " ");

        for(int x : list[n]) {
            if(!check[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(9, new int[][]{{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
//        System.out.println("TestCase1 : " + solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
//        System.out.println("TestCase2 : " + solution(4, new int[][]{{1,2},{2,3},{3,4}})); // 0
//        System.out.println("TestCase3 : " + solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})); // 1
    }
}
