package algorithms.programmers;

import java.util.*;

// category : hash
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

public class Test42576 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for(String parti : participant) {
            participantMap.put(parti, participantMap.getOrDefault(parti, 0) + 1);
        }

        for(String comp : completion) {
            participantMap.put(comp, participantMap.get(comp)-1);
        }

        String answer = "";
        for(Map.Entry<String, Integer> entry : participantMap.entrySet()) {
            if(entry.getValue() > 0) {
                answer += entry.getKey();
            }
        }

        return answer;
    }
}
