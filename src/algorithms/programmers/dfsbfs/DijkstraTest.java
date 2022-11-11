package algorithms.programmers.dfsbfs;

import algorithms.programmers.greedy.Test42861;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/*
참조 : 다익스트라 알고리즘 우선순위 큐 사용 - 최단경로 구하기
      https://devfunny.tistory.com/641
 */
public class DijkstraTest {
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
    
    // start부터 각 노드까지 갈 수 있는 가장 최소 비용을 구해 dist[]에 저장하는 함수 (문제와 별개..)
    public static int[] dijkstra(int n, List<Node>[] graph, int start) {
        int[] dist = new int[n]; // n번째 노드까지 갈 수 있는 최단 거리 저장 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 배열 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 최초 시작노드, 최단경로 0으로 셋팅
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll(); // 최단거리가 가장 짧은 노드

            int v = node.getNode(); // 현재 노드
            int w = node.getWeight(); // 현재 노드까지의 비용

            // 현재 노드까지의 최단거리(dist)가 이미 저장되어 있고 현재 노드까지 오는 비용보다 더 작은 경우는 이미 최소 비용이 확인되었으므로 skip
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

        return dist;
    }

    public static void main(String[] args) {
        int n = 4; // 노드의 갯수
        int[][] input = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        // 가중치가 있는 인접리스트 생성
        List<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 정점.add(Node(연결노드, 가중치))
        // 양방향 그래프로 설정
        for(int i = 0; i < input.length; i++) {
            graph[input[i][0]].add(new Node(input[i][1], input[i][2]));
            graph[input[i][1]].add(new Node(input[i][0], input[i][2]));
        }

        int[] dist = dijkstra(n, graph, 0);

        for(int i = 0; i < dist.length; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }
}
