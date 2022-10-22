package algorithms.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// category : DFS/BFS
// 게임 맵 최단거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Test1844 {
    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};

    // 최단거리를 구하는 문제로 가중치가 1인 경우. BFS를 이용해서 최단거리를 구함
    public static int solution(int[][] maps) {
        int xLen = maps.length;
        int yLen = maps[0].length;

        int[][] dist      = new int[xLen][yLen]; // (x,y)까지 온 거리를 구하는 배열
        boolean[][] check = new boolean[xLen][yLen]; // (x,y)의 방문 여부를 기록하는 배열
        Queue<int[]> q    = new LinkedList<>(); // dfs 탐색용 queue

        q.add(new int[]{0,0}); // 처음 시작점인 0,0 queue에 add
        check[0][0] = true; // 최초 방문 기록
        dist[0][0]  = 1; // 최초 거리 1 기록

        while(!q.isEmpty()) {
            int[] xy = q.remove();
            int x = xy[0];
            int y = xy[1];
            
            // 상하좌우 탐색. for문 돌면서 위 아래 좌 우 순으로 탐색함 (dx, dy를 이용하여 방향에 맞춰 이동)
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < xLen && ny >= 0 && ny < yLen) { // 배열 크기 내에서만 상하좌우 이동
                    if(!check[nx][ny] && maps[nx][ny]==1) { // 아직 방문하지 않았거나, 길이 있는 경우에만 이동
                        q.add(new int[]{nx, ny});
                        check[nx][ny] = true; // 방문여부 기록
                        dist[nx][ny]  = dist[x][y]+1; // 거리 기록
                    }
                }
            }
        }

        return (dist[xLen-1][yLen-1] == 0 ? -1 : dist[xLen-1][yLen-1]);
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println("TestCase2 : " + solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
