package Programmers;

import java.util.*;

public class 신고결과받기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution.solution(id_list, report, k)));
    }
}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];   // return 할 정답 배열.
        HashMap<String, HashSet<String>> reportDoc = new HashMap<>(); // 피신고자는 신고자에 의해 한 번만 신고될 수 있다. 따라서, 신고자를 set으로 구성.
        HashMap<String, Integer> reportFinalCount = new HashMap<>();  // 신고자 - k번 이상 신고된 피신고자를 신고한 횟수(명)

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reporter = new HashSet<>();
            reportDoc.put(id_list[i], reporter);
            reportFinalCount.put(id_list[i], 0);   // 초기화.
        }

        for (String rep : report) {
            String[] repSplit = rep.split(" ");
            reportDoc.get(repSplit[1]).add(repSplit[0]);
        }
        for (String reporter : reportDoc.keySet()) {
            int reporterSet = reportDoc.get(reporter).size();       // reportDoc 에 있는 HashSet 인 '신고자'가 몇명인지 구합니다. 피신고자가 신고된 횟수를 의미합니다.
            if (reporterSet >= k) {
                for(String result : reportDoc.get(reporter)) {
                    reportFinalCount.put(result, reportFinalCount.get(result) + 1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportFinalCount.get(id_list[i]);
        }
        return answer;

    }
}
