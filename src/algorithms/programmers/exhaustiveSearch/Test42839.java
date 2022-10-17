package algorithms.programmers.exhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

// category : Exhaustive Search
// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class Test42839 {
    static Set<Integer> set;

    public static int solution(String numbers) {
        int answer = 0;

        boolean[] visited = new boolean[numbers.length()];
        set = new HashSet<>();

        char[] output = new char[numbers.length()];

        for(int i=1; i<=numbers.length(); i++) {
            permutation(numbers, visited, output, numbers.length(), i, 0);
        }

        System.out.println("set : " + set);

        boolean isPrime = true;

        for(int n : set) {
            for(int i=2; i<=Math.sqrt(n); i++) {
                if(n%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && n!=1) {
                answer++;
            }
        }
        return answer;
    }

    static void permutation(String numbers, boolean visited[], char[] output, int n, int r, int depth){
        if(depth==r){
            String s = "";
            for(int i=0; i<r; i++) {
                s+=output[i];
            }

            set.add(Integer.valueOf(s));
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = numbers.charAt(i);
                permutation(numbers, visited, output, n, r, depth+1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("17"));
        System.out.println("TestCase2 : " + solution("011"));
    }
}
