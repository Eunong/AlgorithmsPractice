package algorithms.programmers.greedy;

// category : greedy
// 큰 수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Test42883 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int idx = 0;
        char max;

        // 반환할 문자열 길이만큼 반복
        // 최초에는 0번째부터 시작해서 k+1 번째까지 가장 큰 수를 탐색한다.
        /* ex) number : 4177252841, k : 4
            41772 -> 이 중에서 가장 큰 수 1개 선택 "7" / 52841
            725   -> 이 중에서 가장 큰 수 1개 선택 "7" / 2841
            252   -> 이 중에서 가장 큰 수 1개 선택 "5" / 841
            28    -> 이 중에서 가장 큰 수 1개 선택 "8" / 41
            4     -> 이 중에서 가장 큰 수 1개 선택 "4" / 1
            1     -> 이 중에서 가장 큰 수 1개 선택 "1" /
         */
        for(int i = 0; i < len-k; i++) {
            max = '0';
            for(int j = idx; j <= k+i; j++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    idx = j+1;
                    // 선택한 숫자가 9인 경우 해당 구간에서 가장 큰 수가 되므로 더 이상 비교하지 않고 break
                    if(max == '9') {
                        break;
                    }
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("1924", 2)); // 94
        System.out.println("TestCase2 : " + solution("1231234", 3)); // 3234
        System.out.println("TestCase3 : " + solution("4177252841", 4)); // 775841
    }
}
