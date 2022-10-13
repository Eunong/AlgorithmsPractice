package algorithms.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

// category : sort
// 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class Test42746 {
    public static String solution(int[] numbers) {
        // 문자형으로 내림차순 정렬하기 위해 문자열 배열로 변환
        String[] numbersStr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 문자 내림차순 정렬
        // 이 때 330(3+30)이 303(30+3) 보다 커야하므로 o1+o2와 o2+o1을 비교해서 더 큰수 기준으로 내림차순 정렬한다.
        Arrays.sort(numbersStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(int i = 0; i < numbersStr.length; i++) {
            System.out.print(numbersStr[i] + " ");
        }

        // {0, 0, 0, 0} 같이 0이 여러건일 경우(정렬 후 가장 큰 수가 0인 경우) "0000" 대신 "0"을 리턴해야 하기 때문에 바로 리턴함  
        if(numbersStr[0].equals("0")) {
            return "0";
        }
        
        return String.join("", numbersStr); //문자열 배열을 문자열로 합쳐서 리턴
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{6, 10, 2}));
        System.out.println("TestCase2 : " + solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println("TestCase3 : " + solution(new int[]{0}));
        System.out.println("TestCase4 : " + solution(new int[]{0, 0, 0, 0})); // 11번 테스트케이스. 이 경우 0을 return해야 함

    }
}
