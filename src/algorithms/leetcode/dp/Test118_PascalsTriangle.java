package algorithms.leetcode.dp;

import java.util.*;

public class Test118_PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> line = new ArrayList<>();
        line.add(1);

        result.add(line);

        for(int i = 1; i < numRows; i++) {
            line = new ArrayList<>();

            for(int j = 0; j < i+1; j++) {
                if(j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(line);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + generate(1));
        System.out.println("TestCase2 : " + generate(5));
    }
}
