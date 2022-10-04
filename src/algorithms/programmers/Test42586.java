package algorithms.programmers;

import java.util.*;

public class Test42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            days[i] = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }

        ArrayList<Integer> arrayList = new ArrayList();
        int cnt = 1;
        int day = days[0];

        for(int i = 1; i < days.length; i++) {
            if(days[i] > day) {
                arrayList.add(cnt);
                cnt = 1;
                day = days[i];
            } else {

                cnt++;
            }
        }

        arrayList.add(cnt);

        return arrayList.stream().mapToInt(i ->i).toArray();


        // sample answer
        /*
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        */
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println("TestCase2 : " + solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println("TestCase4 : " + solution(new int[]{95, 90, 99, 99, 90, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
