package algorithms.programmers.exhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

// category : Exhaustive Search
// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class Test42839 {
    static Set<Integer> set;

    public static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        set = new HashSet<>();

        char[] output = new char[numbers.length()];

        for(int i=1; i<=numbers.length(); i++) {
            permutation(numbers, output, visited, 0, numbers.length(), i);
        }

        System.out.println("set : " + set);

        int primeCnt = 0;
        for(int n : set) {
            if(isPrime(n)) {
                primeCnt++;
            }
        }
        return primeCnt;
    }

    // 소수인지 확인
    static boolean isPrime(int n) {
        if(n < 2 || n!=2 && n%2 == 0) { // 0, 1, 짝수는 소수가 아니므로 바로 return false
            return false;
        }

        for(int i=3; i<=Math.sqrt(n); i+=2) { // 소스는 루트 N보다 작은 수 중 홀수로 나누어지는 수가 있는지 확인하면 됨.
            if(n%i==0) {
                return false;
            }
        }

        return true;
    }
    
    // 순열 알고리즘
    static void permutation(String numbers, char[] output, boolean visited[], int depth, int n, int r){
        if(depth==r){
            String s = "";
            for(int i=0; i<r; i++) {
                s+=output[i];
            }
            System.out.println(Integer.valueOf(s));
            set.add(Integer.valueOf(s));
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = numbers.charAt(i);
                permutation(numbers, output, visited, depth+1, n, r);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("17"));
        System.out.println("TestCase2 : " + solution("011"));
        System.out.println("TestCase3 : " + solution("000"));
        System.out.println("TestCase4 : " + solution("1"));
        System.out.println("TestCase5 : " + solution("23"));
        System.out.println("TestCase6 : " + solution("123"));
    }
}
