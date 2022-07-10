package algorithm.programmers;

import java.util.*;

public class ReportResult {
    /*
     * * 문제 핵심 *
     * 1. 신고자가 한 유저를 여러번 신고할 수 있지만 1로 count 된다.
     * 2. k번 이상 신고될 시 정지처리 되고, 메일이 발송된다.
     * * 문제 이해 *
     * 1. 신고한 사람이 어느 유저를 신고했는지 저장하는 userReportInfoMap 생성
     * -> key : 유저, value : 유저가 신고한 리스트
     * 2. 신고된 횃수를 담는 Map<String, Integer> userReportedCountMap 생성
     * -> key : 유저, value : 유저가 신고된 횃수
     * 3.
     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // answer 배열을 멤버 수대로 만든다.

        /* HashMap -> 저장 순서 보장 X, LinkedHashMap -> 저장 순서 보장 */
        Map<String, String> reporterInfoMap = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();
        HashSet<String> reportList = new HashSet<>(Arrays.asList(report));

        for (String reportInfo : reportList) {
            String reporterId = reportInfo.split(" ")[0]; // 신고를 한 유저
            String reported = reportInfo.split(" ")[1]; // 신고를 받은 유저
            // 신고를 한 유저의 신고 목록을 받아와서 reported 추가
            reporterInfoMap.put(reporterId, (reporterInfoMap.getOrDefault(reporterId, "") + " " + reported).trim());
            // trim()을 통해 앞 뒤 공백 제거 -> 맨 처음 저장될 때 " "가 추가되기 때문!
            reportedCountMap.put(reported, reportedCountMap.getOrDefault(reported, 0) + 1);
        }

        for (String userId : reportedCountMap.keySet()) {
            int reportedCount = reportedCountMap.get(userId);
            if (reportedCount >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(userId)) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] id_list = {"con", "ryan"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
//        int k = 3;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}