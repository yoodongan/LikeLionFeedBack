import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {
    public static String[] solutions(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            switch (str[0]) {
                case "Enter" :
                    users.put(str[1],str[2]);
                    sb.append(str[1]).append("님이 들어왔습니다.#");
                    break;
                case "Leave" :
                    sb.append(str[1]).append("님이 나갔습니다.#");
                    break;
                case "Change" :
                    users.put(str[1],str[2]);
                    break;
            }
        }
        String[] result = sb.toString().split("#");
        for (int i = 0; i < result.length; i++) {
            String change = result[i].substring(0, result[i].indexOf("님"));
            result[i] = result[i].replace(change, users.get(change));   // 해시맵에 저장한 user 정보를 result 배열에 갱신해준다.
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solutions(arr)));
    }
}
