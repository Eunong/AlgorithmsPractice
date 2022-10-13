package algorithms.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

// category : stack queue
// 같은 숫자는 싫어
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Test12906 {
    public int[] solution(int []arr) {

        // CASE1. using Stack
        /*
        Stack<Integer> stack = new Stack<>();

        for(int n : arr) {
            if(stack.isEmpty() || stack.peek() != n) {
                stack.push(n);
            }
        }

        int[] answer = new int[stack.size()];

        for(int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
        */

        // CASE2. using ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        int preNum = 10;
        for(int n : arr) {
            if(preNum != n) {
                arrayList.add(n);
                preNum = n;
            }
        }

        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
