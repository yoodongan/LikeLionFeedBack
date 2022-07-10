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
        Map<String, String> reporterInfoMap = new LinkedHashMap<>();
        Map<String, Integer> reportedCountMap = new LinkedHashMap<>();

        /* 1단계 : id_list 순서대로 map 초기화 */
        for (String userId : id_list) {
            reporterInfoMap.put(userId, "");
            reportedCountMap.put(userId, 0);
        }

        /* 2단계 : report 순서대로 유저가 신고한 유저들을 저장 */
        for (String reportInfo : report) {
            String reporterId = reportInfo.split(" ")[0]; // 신고를 한 유저
            String reported = reportInfo.split(" ")[1]; // 신고를 받은 유저
            if (!reporterInfoMap.get(reporterId).contains(reported)) {
                // 중복 방지를 위해 신고한 유저의 신고 목록에 reported 가 없다면 저장

                String reportId = reporterInfoMap.get(reporterId) + " " + reported;
                // 신고를 한 유저의 신고 목록을 받아와서 reported 추가

                reporterInfoMap.replace(reporterId, reportId.trim());
                // trim()을 통해 앞 뒤 공백 제거 -> 맨 처음 저장될 때 " "가 추가되기 때문!
                reportedCountMap.replace(reported, reportedCountMap.getOrDefault(reported, 0) + 1);
            }
        }

        /* 3단계 info keySet()을 돌면서 answer 배열 완성 */
        for (String userId : id_list) {
            int idx = 0;
            if (reportedCountMap.get(userId) >= k) {
                for (String reportedListStr : reporterInfoMap.values()) {
                    if (reportedListStr.contains(userId)) {
                        answer[idx]++;
                    }
                    idx++;
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