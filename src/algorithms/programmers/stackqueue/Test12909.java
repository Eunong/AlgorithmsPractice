package algorithms.programmers.stackqueue;

import java.util.ArrayList;

// category : stack queue
// 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Test12909 {
    static boolean solution(String s) {

        // We can using ArrayList or Stack
        /*
        ArrayList<Character> arrayList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch(c) {
                case '(' :
                    arrayList.add(c);
                    break;
                case ')' :
                    if(arrayList.size() == 0 || arrayList.get(arrayList.size()-1) != '(') {
                        return false;
                    }
                    arrayList.remove(arrayLisv.size()-1);
                    break;
            }
        }

        if(arrayList.size() != 0) {
            return false;
        }

        return true;
        */

        // just using count variable

        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                cnt++;
            }
            if(c == ')') {
                cnt--;
            }
            if(cnt < 0) {
                return false;
            }
        }
        if(cnt > 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("()()"));
        System.out.println("TestCase2 : " + solution("(())()"));
        System.out.println("TestCase3 : " + solution(")()("));
    }
}
