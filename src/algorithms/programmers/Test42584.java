package algorithms.programmers;

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
