package algorithms.programmers.greedy;

import java.util.Arrays;

// category : greedy
// 체육복
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Test42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        // 바로 옆 사람에게 체육복을 빌려주기 전, 옆 사람이 체육복을 가져오면서 도난당한 학생인지 바로 확인하기 위해 정렬하고 시장
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 각 학생 별 체육복 상태 표시를 위한 배열. -1 : 체육복 도난, 0 : 체육복 있음
        int[] students = new int[n];

        for(int l : lost) {
            students[l-1] = -1;
        }

        // 체육복 여벌이 있는 사람 처음부터 돌면서 양 옆에 체육복 빌려줘야 하는 사람이 있는지 체크하면서 진행한다.
        for(int i = 0; i < reserve.length; i++) {
            int curStudent = reserve[i]; // 현재 여벌 체육복을 가져온 학생

            // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우 다른사람에게 빌려줄 수 없고 본인만 체육복 1개가 남음
            if(students[curStudent-1] == -1) {
                students[curStudent-1]++;
                continue;
            }

            if(curStudent-2 >= 0 && students[curStudent-2] == -1) { // 왼쪽 학생에게 빌려줘야 할 경우 (왼쪽 학생이 옷을 도난당했을 경우)
                students[curStudent-2]++;
            } else if(curStudent < n && students[curStudent] == -1) { // 오른쪽 학생에게 빌려줘야 할 경우 (오른쪽 학생이 옷을 도난당했을 경우)
                if(i+1 < reserve.length && reserve[i+1] != curStudent+1) { // 오른쪽 학생이 옷을 도난당했는데, 본인도 여벌 옷이 있을 경우는 빌려주지 않는다.
                    students[curStudent]++;
                } else if(i+1 == reserve.length) { // 오른쪽 학생이 여벌옷이 있는지 없는지 확인할 필요가 없는 경우, 여벌옷을 가져온 오른쪽 학생이 더 이상 없을 경우
                    students[curStudent]++;
                }
            }
        }

        return (int)Arrays.stream(students).filter(x -> x==0).count(); // 체육복이 있으면 0. 체육복 있는 학생 수 리턴
    }

    // 수행시간 빠름
    public static int solutionSample(int n, int[] lost, int[] reserve) {
        int answer = n; // 최종적으로 체육복이 있는 학생 수
        
        // 각 학생 별 체육복 상태 표시를 위한 배열. -1 : 체육복 도난, 0 : 체육복 있음
        int[] students = new int[n];
        
        // 도난당한 학생 표시
        for(int l : lost) {
            students[l-1]--;
        }
        
        // 여벌있는 학생 표시
        for(int r : reserve) {
            students[r-1]++;
        }

        // 학생 기준으로 돌아가면서 체육복이 없으면 옆에 사람에게 빌린다.
        for(int i = 0; i < students.length; i++) {
            if(students[i] == -1) {
                if(i-1 >= 0 && students[i-1] == 1) {
                    students[i-1]--;
                    students[i]++;
                } else if(i+1 < n && students[i+1] == 1) {
                    students[i+1]--;
                    students[i]++;
                } else {
                    answer--; // 체육복이 없는데 양 옆에서 빌릴 수도 없으면 최종적으로 체육복이 없는 학생으로 count
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 5
        System.out.println("TestCase2 : " + solution(5, new int[]{2, 4}, new int[]{3})); // 4
        System.out.println("TestCase3 : " + solution(3, new int[]{3}, new int[]{1})); // 2
        System.out.println("TestCase4 : " + solution(13, new int[]{1, 2, 5, 6, 10, 12, 13}, new int[]{2, 3, 4, 5, 7, 8, 9, 10, 11, 12})); // 11
        System.out.println("TestCase5: " + solution(13, new int[]{1, 2, 5, 6, 10, 13}, new int[]{2, 3, 4, 5, 7, 8, 9, 10, 11, 12})); // 12
        System.out.println("TestCase6: " + solution(3, new int[]{1, 2}, new int[]{2, 3})); // 2
        System.out.println("TestCase6: " + solution(2, new int[]{1, 2}, new int[]{2})); // 1
    }
}
