package algorithms.programmers.stackqueue;

// category : stack queue
// 주식가격
// https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class Test42584 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length-1; i++) {
            for(int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[] {3, 3, 2, 3, 3}));
    }
}
