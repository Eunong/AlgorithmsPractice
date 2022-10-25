package algorithms.programmers.dfsbfs;

import java.util.*;

// category : DFS/BFS
// 여행경로
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Test43164 {
    static List<String> route;
    static final String VISITED = "VISITED";

    public static String[] solution(String[][] tickets) {
        route = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        
        // input 값 인접리스트로 변환
        for(int i = 0; i < tickets.length; i++) {
            List<String> list = map.getOrDefault(tickets[i][0], new ArrayList<>());
            list.add(tickets[i][1]);
            Collections.sort(list); // 가능 경로가 있을 때 알파벳 우선순위로 탐색하기 위해 정렬 
            map.put(tickets[i][0], list);
        }
        System.out.println("map : " + map);

        route.add("ICN"); // 항상 ICN 부터 시작
        dfs(map, "ICN", tickets.length+1);

        System.out.println("route : " + route);

        return route.stream().toArray(String[]::new);
    }

    /*
    변수
    @map : 경로 인접리스트
    @visit : 현재 방문하고 있는 도시
    @cnt : 전체 방문해야 하는 경로 갯수
    */
    public static void dfs(Map<String, List<String>> map, String visit, int cnt) {
        if(route.size() == cnt || map.get(visit) == null) { // 전체를 다 방문했거나 전체 다 방문이 아닌데 더 이상 dfs로 진행할 수 없을 경우 return
            return;
        }

        for(int i = 0; i < map.get(visit).size(); i++) {
            String city = map.get(visit).get(i);
            if(!city.equals(VISITED)) {
                route.add(city);
                map.get(visit).set(i, VISITED);
                dfs(map, city, cnt);
                // dfs를 한 번 끝까지 다 탐색했는데 모든 경로를 탐색하지 못했을 경우에는 다른 방법으로 재 탐색하기 위해 방문 여부를 초기화한다.
                if(route.size() != cnt) {
                    map.get(visit).set(i, city); // 방문여부 초기화
                    route.remove(route.size()-1); // 방문기록 삭제
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        System.out.println("TestCase2 : " + solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));

        // ICN -> AAA를 먼저 방문하면 주어진 항공권을 모두 사용할 수 없음 -> 항상 알파벳 순으로 탐색해야하는 것은 아님
        // output : ["ICN", "CCC", "DDD", "ICN", "AAA", "BBB", "AAA", "BBB"]
        System.out.println("TestCase3 : " + solution(new String[][]{{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}}));

        // output : ["ICN", "A", "C", "A", "B", "D"]
        System.out.println("TestCase4 : " + solution(new String[][]{{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}}));
    }
}
