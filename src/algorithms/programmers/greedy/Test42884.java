package algorithms.programmers.greedy;

import java.util.Arrays;

// category : greedy
// 단속카메라
// https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class Test42884 {
    public static int solution(int[][] routes) {
        // 고속도로에서 나간 위치를 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1],o2[1]));
        /*
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        */

        int cameraCnt = 1;      // 최소 카메라 설치 대수 (input 차량의 대수는 1대 이상 10,000대 이하이므로 최초 1대 설정)
        int min = routes[0][1]; // 최초 차량의 진출 시점을 min 값으로 설정하고 이후 차량부터 최초 시작점의 진출 위치보다 진입시점이 큰 값이 있는지 비교하여 카메라 개수를 +함

        for(int[] route : routes) {
            if(route[0] > min) { // 현재 시작 위치가 최소 시작 위치보다 큰 경우
                min = route[1]; // 최소 시작 위치를 현재 위치의 진출 시점으로 셋팅
                cameraCnt++;
            }
        }

        return cameraCnt;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})); // 2
        System.out.println("TestCase2 : " + solution(new int[][]{{-2, -1}, {1, 2}, {-3, 0}})); // 2
        System.out.println("TestCase3 : " + solution(new int[][]{{0, 0}})); // 1
        System.out.println("TestCase4 : " + solution(new int[][]{{0, 1}, {0, 1}, {1, 2}})); // 1
        System.out.println("TestCase5 : " + solution(new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}})); // 4
        System.out.println("TestCase6 : " + solution(new int[][]{{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}})); // 4
    }
}
