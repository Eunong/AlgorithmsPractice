package algorithms.programmers;

// category : hash (단순 정렬 후 문자열 비교로 풀이)
// https://school.programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;

public class Test42577 {
    public static boolean solution(String[] phone_book) {
        // case1 - O(n^2) -> 효율성테스트 케이스 3, 4번 시간초과 실패
        // phone_book의 길이는 1 이상 1,000,000 이하입니다.
        // 각 전화번호의 길이는 1 이상 20 이하입니다.
        /*
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book.length; j++) {
                if(i != j && phone_book[i].length() <= phone_book[j].length() && phone_book[j].indexOf(phone_book[i]) == 0) {
                    return false;
                }
            }
        }
        */

        // case2 - 이 문제는 hash 문제이지만 case1 방법처럼 이중for문을 사용하거나 hash에 자리수 별로 값을 넣어서 비교해도 시간초과가 발생함.
        // String 배열이기 때문에 문자 순으로 오름차순 정렬한 후 바로 다음 문자와 비교하는 것 만으로도 접두어 비교가 가능함.
        // 즉 아래와 같이 단순 정렬로 풀 수 있음.
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) { // if(phone_book[i+1].indexOf(phone_book[i]) == 0) 동일
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println("TestCase2 : " + solution(new String[]{"123","456","789"}));
        System.out.println("TestCase3 : " + solution(new String[]{"12","123","1235","567","88"}));
    }

}
