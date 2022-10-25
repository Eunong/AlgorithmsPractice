package algorithms.programmers.dfsbfs;

import java.util.*;

// category : DFS/BFS
// 여행경로
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Test43164 {
    static List<String> route;

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        route = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < tickets.length; i++) {
            List<String> list = map.getOrDefault(tickets[i][0], new ArrayList<>());

            list.add(tickets[i][1]);
            Collections.sort(list);

            map.put(tickets[i][0], list);
        }
//        System.out.println("map : " + map);


        route.add("ICN");
        dfs(map, "ICN");

//        System.out.println("route : " + route);

        return answer;
    }

    public static void dfs(Map<String, List<String>> map, String visit) {
        if(map.get(visit) == null || map.get(visit).stream().allMatch(str -> str.equals("VISITED"))) {
            return;
        }

        for(int i = 0; i < map.get(visit).size(); i++) {
            String city = map.get(visit).get(i);
            if(!city.equals("VISITED")) {
                route.add(city);
                map.get(visit).set(i, "VISITED");
                dfs(map, city);
            }
        }
    }

    public static void dfs2(Map<String, List<String>> map, String visit) {
        if(map.get(visit).isEmpty()) {
            return;
        }

        for(String city : map.get(visit)) {
            route.add(city);
            map.get(visit).remove(0);
            dfs(map, city);

        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        System.out.println("TestCase2 : " + solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }
}
