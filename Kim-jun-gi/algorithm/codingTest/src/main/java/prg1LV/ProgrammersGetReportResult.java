package prg1LV;

import java.util.*;
//신고 뭐시기
public class ProgrammersGetReportResult {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int key = 2;
        solution(id_list,report,key);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,HashSet<String>> map = new HashMap<>();
        Map<String,Integer> idx = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i],new HashSet<>());
            idx.put(id_list[i],i);
        }
        for (String s : report) {
            String[] str = s.split(" ");
            map.get(str[1]).add(str[0]);
        }
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            // 정지자 [신고한 사람1, 신고한 사람2]
            if (send.size() >= k) {
                for (String s : send) {
                    answer[idx.get(s)]++;
                }
            }

        }

        return answer;
    }
}
// 유저가 신고
// 해당 유저가 신고한 애가 정지먹으면 메일로 알려줌
// [p1 p2] [ ] [ ] p1. [p2 p3]
// 문법이슈