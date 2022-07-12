package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class NoCompletion {

    /* * 문제이해 *
    * 1. 완주하지 못한 선수를 구하기
    * 2. 선수의 이름은 중복이 가능하다.
    * 2-1. 중복된 선수가 있더라도 그 중에 1명은 불합격으로 나와야한다.
    * participant : 참여한 선수 배열
    * completion : 완주한 선수 배열
    */
    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        List<String> completionList = new ArrayList<>(List.of(completion));
        List<String> participantList = new ArrayList<>(List.of(participant));

        for (int i = 0; i < participantList.size(); i++) {
            String player = participantList.get(i);
            boolean flag = false;
            for (int j = 0; j < completionList.size(); j++) {
                String cPlayer = completionList.get(j);
                if (player.equals(cPlayer)) {
                    completionList.remove(j);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                participantList.remove(i);
                i--;
            } else {
                answer = player;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"eden", "kiki"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
//        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
