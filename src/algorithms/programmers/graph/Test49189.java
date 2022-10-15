package algorithms.programmers.graph;

import java.util.*;

// category : graph
// 가장 먼 노드
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class Test49189 {
    static List<Integer>[] list;
    static int cnt = 0;
    static boolean[] check;

    public static int solution(int n, int[][] edge) {
        // 입력된 그래프를 인접리스트 형태로 저장
        list = new ArrayList[n+1];
        cnt = 0;
        check = new boolean[n+1]; // 정점에 방문했는지 여부를 체크하기 위한 변수

        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<edge.length; i++) {
            // 양방향 간선 정보 저장
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        // 1번 노드에서 가장 멀리 떨어진 노드의 갯수 구하기
        int[] visited = new int[n+1]; // 정점까지 방문한 간선의 갯수를 누적해서 저장하는 배열
        int maxLength = bfsChkVisitedCnt(1, visited);

        int maxCnt = 0;
        for(int v : visited) {
            if(maxLength == v) {
                maxCnt++;
            }
        }
//        bfs(1, n);
//        dfs(1, n);

        return maxCnt;
    }

    // 너비우선탐색 - 방문한 간선의 길이 visited 배열에 저장
    public static int bfsChkVisitedCnt(int start, int[] visited) {
        Queue<Integer> q = new LinkedList<>();

        // 시작 노드부터 방문
        q.add(start);
        visited[start] = 1; // 최초 노드는 1로 셋팅

        while(!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");

            for(int y : list[x]) {
                if(visited[y]==0) {
                    q.add(y);
                    visited[y] = visited[x]+1; // 바로 직전에 방문한 노드의 간선 수 + 1 (누적 거리)
                }
            }
        }

        return Arrays.stream(visited).max().getAsInt(); // 최대 거리 return
    }


    // 너비우선탐색
    public static void bfs(int start, int n) {
        check = new boolean[n+1]; // 정점에 방문했는지 여부를 체크하기 위한 변수
        Queue<Integer> q = new LinkedList<>();

        // 시작 노드부터 방문
        q.add(start);
        check[start] = true; // queue에 add 시 방문 여부를 true로 변경

        // 정점에서 방문할 수 있는 모든 곳을 queue에 넣고 더 이상 갈 곳이 없으면 큐에서 정점을 pop
        while(!q.isEmpty()) {
            int x = q.remove();
            System.out.println("x : " + x);

            boolean isEnd = true;

            for(int y : list[x]) {
                if(!check[y]) { // 아직 방문하지 않은 노드이면 방문
                    q.add(y);
                    check[y] = true;
                    isEnd = false;
                }
            }

            if(isEnd) { // 마지막 노드 구하기
                cnt++;
            }
        }
    }
    
    // 깊이우선탐색
    public static void dfs(int x, int n) {
        if(check[x]) {
            return;
        }

        check[x] = true;
        System.out.println(x + " ");

        boolean isEnd = true;

        for(int y : list[x]) {
            if(!check[y]) { // 아직 방문하지 않은 노드이면 방문
                isEnd = false;
                dfs(y, n);
            }
        }
        if(isEnd) {
            cnt++;
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
        System.out.println("TestCase2 : " + solution(7, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {5, 7}}));
    }
}
