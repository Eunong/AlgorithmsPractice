package algorithms.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// category : hash
// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Test42578 {
    static int sum = 0;

    public static int solution(String[][] clothes) {
        int cnt = clothes.length;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        System.out.println("map : " + map);
        if(map.size() == 1) { // 한 가지 종류로만 이루어져있을 경우는 1개 씩 만 고를 수 있으므로 건수 만큼 바로 리턴
            return cnt;
        }

        List<Map.Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());

        // 조합으로 풀 경우 1번 테스트케이스 timeout 발생. 다른 방법 찾아야 할 듯.. (n : 30인 케이스)
        boolean[] visited = new boolean[list.size()];
        for(int i = 1; i <= list.size(); i++) {
            combinationBFS(list, visited, 0, list.size(), i);
        }

        return sum;
    }

    // 백트래킹 사용 (참조 : https://bcp0109.tistory.com/15)
    static void combinationBFS(List<Map.Entry<String, Integer>> list, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int calcTmp = 1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    calcTmp *= list.get(i).getValue();
//                    System.out.print(list.get(i) + " ");
                }
            }
//            System.out.println();
            sum += calcTmp;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinationBFS(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println("TestCase2 : " + solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

}
