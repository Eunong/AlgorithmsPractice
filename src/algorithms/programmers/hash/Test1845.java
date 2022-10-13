package algorithms.programmers.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// category : hash
// 포켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Test1845 {
    public static int solution(int[] nums) {
        int pickCnt = nums.length/2;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        if(map.size() >= pickCnt) { // 골라야 하는 가지수 보다 더 많은 종류의 폰켓몬이 있는 경우 골라야 하는 가지수 만큼 다양하게 고를 수 있으므로 바로 return
            return pickCnt;
        }

        // 골라야하는 폰켓몬 전체 갯수보다 적은 종류가 있을 경우 선택할 수 있는 최대 가짓수는 폰켓몬의 종류만큼
        return map.size();
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{3, 1, 2, 3}));
        System.out.println("TestCase2 : " + solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println("TestCase3 : " + solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
