package algorithms.programmers.greedy;

import java.util.*;

/*
# category : greedy
# 섬 연결하기
# https://school.programmers.co.kr/learn/courses/30/lessons/42861
# 참조 : 다익스트라 알고리즘 우선순위 큐 사용 - 최단경로 구하기
         https://devfunny.tistory.com/641
*/
public class Test42861 {
    private static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {;
            return this.weight - o.weight;
        }
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        // 가중치가 있는 인접리스트 생성
        List<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < costs.length; i++) {
            // 정점.add(Node(연결노드, 가중치))
            // 양방향 그래프로 설정
            graph[costs[i][0]].add(new Node(costs[i][1], costs[i][2]));
            graph[costs[i][1]].add(new Node(costs[i][0], costs[i][2]));
        }

        dijkstra(n, graph, 0);

        return answer;
    }

    public static int dijkstra(int n, List<Node>[] graph, int start) {
        int[] dist = new int[n]; // n번째 노드까지 갈 수 있는 최단 거리 저장 배열
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 최초 시작노드, 최단경로 0으로 셋팅
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll(); // 최단거리가 가장 짧은 노드

            int v = node.getNode();
            int w = node.getWeight();

            if(dist[v] < w) {
                continue;
            }
            
            // 현재 노드와 인접한 다른 노드 확인
            for(int i = 0; i < graph[v].size(); i++) {
                Node curNode = graph[v].get(i);

                // 현재 최단거리 + 현재 연결된 노드의 비용
                int cost = dist[v] + curNode.getWeight();

                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < dist[curNode.getNode()]) {
                    dist[curNode.getNode()] = cost;
                    pq.offer(new Node(curNode.getNode(), cost));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); // 4
        System.out.println("TestCase2 : " + solution(7, new int[][]{{2,3,7},{3,6,13},{3,5,23},{5,6,25},{0,1,29},{1,5,34},{1,2,35},{4,5,53},{0,4,75}})); // 4
    }
}
