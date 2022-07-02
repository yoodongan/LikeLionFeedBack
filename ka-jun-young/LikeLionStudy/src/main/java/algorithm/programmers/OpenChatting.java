package algorithm.programmers;

import java.util.*;

public class OpenChatting {
    public static String[] solution(String[] record) {
        Map<String, String> userInfo = new HashMap<>();  // USER 최신 정보를 담는 HashMap -> K = uid, V = nickname
        List<String> userInOut = new ArrayList<>();    // USER 출입 정보를 담는 ArrayList -> nickname 출입기록

        for (String command : record) {
            String[] cmdInfo = command.split(" ");    // 0 : 출입 정보, 1 : uid, 2: nickname
            if (cmdInfo[0].equals("Enter")) {
                userInOut.add(cmdInfo[1] + "님 Enter");    // 유저가 들어온 기록을 userInOut에 저장
                userInfo.put(cmdInfo[1], cmdInfo[2]);      // 유저가 들어오면 K : uid, V : nickname 저장
            } else if (cmdInfo[0].equals("Change")) {
                userInfo.put(cmdInfo[1], cmdInfo[2]);       // 유저가 닉네임을 변경했다면 userInfo 최신화
            } else {
                userInOut.add(cmdInfo[1] + "님 Leave");      // 유저가 퇴장한 기록을 userInOut에 저장
            }
        }

        String[] answer = new String[userInOut.size()];     // userInOut의 size를 통해 몇 번 들어오고 나갔는지 확인 가능

        for (int i = 0; i < userInOut.size(); i++) {
            if (userInOut.get(i).contains("Enter")) {
                answer[i] = userInfo.get(userInOut.get(i)
                        .replaceAll("님 Enter", "")) + "님이 들어왔습니다.";
                // userInOut에 사용했던 "님 Enter"를 지운 후 "님이 들어왔습니다." 추가
            } else {
                answer[i] = userInfo.get(userInOut.get(i)
                        .replaceAll("님 Leave", "")) + "님이 나갔습니다.";
                // userInOut에 사용했던 "님 Leave"를 지운 후 "님이 나갔습니다." 추가
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}