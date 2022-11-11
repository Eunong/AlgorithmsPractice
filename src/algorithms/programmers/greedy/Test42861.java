package algorithms.programmers.greedy;

import java.util.*;

/*
# category : greedy
# 섬 연결하기
# https://school.programmers.co.kr/learn/courses/30/lessons/42861
# 참고 : https://maetdori.tistory.com/category/%EC%A0%84%EA%B3%B5%EC%A7%80%EC%8B%9D
*/
public class Test42861 {
    private static int[] parent;

    // 부모노드가 자기 자신과 같은 노드를 찾을 때까지 호출
    private static int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    /* Minimum Spanning Tree, Kruskal Algorithm 이용
    - 가중치 무방향 그래프에서 모든 정점을 최소 비용으로 연결하는 방법
    - 사이클을 형성하지 않아야 함
    */
    public static int solution(int n, int[][] costs) {
        int minWeight = 0;

        // 가중치 기준으로 오름차순 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);
        
        // union find 사용하기 위한 parent 배열 선언
        parent = new int[n];

        for(int i = 0; i < n; i ++) {
            parent[i] = i; // 최초에 부모 자기 자신으로 셋팅
        }

        for(int[] edge : costs) {
            int start = edge[0];
            int end   = edge[1];
            int cost  = edge[2];

            // 부모 노드 확인 (두 노드가 같은 그래프상에 존재하는지 확인하기 위해)
            int startParent = findParent(start);
            int endParent   = findParent(end);
            
            if(startParent == endParent) {
                continue;
            }

            minWeight += cost;
            parent[endParent] = startParent; // 두 노드가 같은 그래프에 속하게 되었기 때문에 부모노드를 갱신한다.
        }

        return minWeight;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); // 4
        System.out.println("TestCase2 : " + solution(7, new int[][]{{2,3,7},{3,6,13},{3,5,23},{5,6,25},{0,1,29},{1,5,34},{1,2,35},{4,5,53},{0,4,75}})); // 159
    }
}
