package algorithms.programmers.greedy;

import java.util.Arrays;

// category : greedy
// 체육복
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Test42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        for(int l : lost) {
            students[l-1] = -1;
        }

        for(int r : reserve) {
            if(students[r-1] == -1) { // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우
                students[r-1]++;
                continue;
            }
            if(r-2>=0 && students[r-2] == -1) { // 왼쪽 학생에게 빌려줄 경우
                students[r-2]++;
            } else if(r < n && students[r] == -1) { // 오른쪽 학생에게 빌려줄 경우
                students[r]++;
            }
        }

        return (int)Arrays.stream(students).filter(x -> x==0).count(); // 체육복이 있으면 0. 체육복 있는 학생 수 리턴
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println("TestCase2 : " + solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println("TestCase3 : " + solution(3, new int[]{3}, new int[]{1}));
        System.out.println("TestCase4 : " + solution(13, new int[]{1, 2, 5, 6, 10, 12, 13}, new int[]{2, 3, 4, 5, 7, 8, 9, 10, 11, 12})); // 11
    }
}
