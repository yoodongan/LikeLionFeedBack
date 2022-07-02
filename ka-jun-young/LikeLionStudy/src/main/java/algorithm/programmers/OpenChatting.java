package algorithm.programmers;

import java.util.*;

public class OpenChatting {
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> userMap = new HashMap<>();
        List<String> statusList = new ArrayList<>();
        StringTokenizer st;
        String userId = "";
        String userNickname = "";
        String userStatus = "";

        for (String info : record) {
            st = new StringTokenizer(info);
            userStatus = st.nextToken();
            if (userStatus.equals("Enter")) {
                userId = st.nextToken();
                userNickname = st.nextToken();
                if (!userMap.containsKey(userId)) {
                    userMap.put(userId, userNickname);
                    statusList.add(userNickname);
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}