package prg1LV;

import java.util.*;

//완주하지 못한 선수
public class PrgDidntFinish {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String a= solution(participant, completion);
        System.out.println(a);

    }
    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        // 참가자들을 map에 추가해줌.
        // 동명이인이 있을 수 있서 1씩 더해줌
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // map에서 완주한 사람들 빼줌
        for (String s : completion) {
            map.put(s,map.get(s)-1);
        }

        // 완주하지 못한 사람 걸러줌
        for (String s : map.keySet()) {
            if(map.get(s) == 1) return s;
        }

        return "";
    }
}
