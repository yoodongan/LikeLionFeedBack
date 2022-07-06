package prg2LV;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

//오픈채팅방
public class PrgOpenChat {
    public static void main(String[] args) throws IOException {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] a = solution(record);
        System.out.println("_____");
        System.out.println(record);


    }
    public static String[] solution(String[] record) {
        int size = 0;

        // String 크기를 미리 알아야 됨.
        for (String s : record) {
            if(s.split(" ")[0].equals("Enter") || s.split(" ")[0].equals("Leave")){
                size++;
            }
        }
        String[] answer = new String[size];

        int i = 0;

        HashMap<String,String> uid_nick = new HashMap<>();
        HashMap<String,ArrayList<Integer>> uid_index = new HashMap<>();

        for (String log : record) {
            // 정보 저장
            String[] logArr = log.split(" ");
            String action = logArr[0];
            String uid = logArr[1];

            // Leave인 경우 배열크기가 2개임
            if(logArr.length == 2) {
                uid_index.get(uid).add(i);
                answer[i++] = uid_nick.get(uid)+"님이 나갔습니다.";
                continue;
            }

            String nickname = logArr[2];

            if (action.equals("Enter")) {
                // 값이 이미 있을 경우
                if (uid_nick.containsKey(uid)) {
                    // 닉변인 경우
                    if(!uid_nick.get(uid).equals(nickname)){
                        uid_nick.put(uid,nickname);

                        for (int index : uid_index.get(uid)) {
                            int nim = answer[index].indexOf("님");
                            answer[index] = nickname+answer[index].substring(nim);
                        }
                    }

                    // 닉변 상관없이 값 추가
                    uid_index.get(uid).add(i);
                    answer[i++] = nickname+"님이 들어왔습니다.";

                } else {
                    // 값이 없을 경우
                    uid_nick.put(uid,nickname);
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    uid_index.put(uid,temp);
                    answer[i++] = nickname+"님이 들어왔습니다.";
                }
            }else if (action.equals("Change")) {
                uid_nick.put(uid,nickname);
                for (int index : uid_index.get(uid)) {
                    int nim = answer[index].indexOf("님");
                    answer[index] = nickname+answer[index].substring(nim);
                }
            }

        }
        System.out.println(uid_nick);
        return answer;
    }
}


