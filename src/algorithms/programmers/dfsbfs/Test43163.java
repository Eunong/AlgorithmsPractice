package algorithms.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// category : DFS/BFS
// 단어 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class Test43163 {

    static boolean[] check;
    static int min = 51; // 단어는 최대 50개 까지 있음

    public static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];

        dfs(0, 0, target, words);

        return min == 51 ? 0 : min;
    }

    public static void dfs(int cnt, int cur, String target, String words[]) {
        // 종료조건
        if(target.equals(words[cur])) {
            min = Math.min(min, cnt);
            return;
        }
        
        // 진행조건
        for(int i = 0; i < words.length; i++) {
            if(!check[i] && compare(words[cur], words[i])) {
                check[i] = true;
                dfs(cnt+1, i, target, words);
                check[i] = false;
            }
        }
    }
    
    // 한 글자만 다른지 체크
    public static boolean compare(String curWord, String nextWord) {
        int cnt = 0;
        for(int i = 0; i < curWord.length(); i++) {
            if(curWord.charAt(i) != nextWord.charAt(i)) {
                cnt++;
            }
        }
        return cnt==1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println("TestCase2 : " + solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println("TestCase3 : " + solution("hit", "hot", new String[]{"hit", "hot", "lot"}));
    }
}
