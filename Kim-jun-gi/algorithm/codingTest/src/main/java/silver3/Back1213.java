package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//팰린드롬 만들기
public class Back1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        // 배열로 만들어주고 List에 추가시켜줌
        String[] alp = br.readLine().split("");
        for (String s : alp) {
            list.add(s);
        }

        System.out.println(solution(list));
    }
    public static String solution(List<String> list){
        int start = 0;
        int end = list.size()-1;

        boolean check = true;
        String middle = ""; // 홀수의 중간값 여부 변수

        while (start < list.size()/2) {
            Collections.sort(list.subList(start,end+1));

            // start 와 start-1 의 값이 다를 경우
            if ( !(list.get(start).equals(list.get(start+1))) ){
                if (list.size() % 2 == 0) {
                    return "I'm Sorry Hansoo";
                }
                // 문자개수가 홀수인데 단일 개별 문자가 두개인 경우
                if (!check) {
                    return "I'm Sorry Hansoo";
                }
                // 홀수 일 경우 한번 기회 줌
                middle = list.remove(start);
                check = false;
                end--;
                continue;
            }
            // start 와 start-1 의 값이 같을 경우, swap 시켜줌
            Collections.swap(list,start+1,end);
            start++;
            end--;
        }

        // 미들값이 있는 경우 넣어줘야 됨
        if (!middle.equals("")){
            list.add(list.size()/2,middle);
        }

        return String.join("",list);
    }

}
//package silver3;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;

//팰린드롬 만들기
//public class Back1213 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Character> list = new ArrayList<>();
//
//        // 배열로 만들어주고 List에 추가시켜줌
//        char[] alp = br.readLine().toCharArray();
//        for (char c : alp) {
//            list.add(c);
//        }
//
//        System.out.println(solution(list));
//    }
//    public static String solution(List<Character> list){
//        int start = 0;
//        int end = list.size()-1;
//        // ABCCABB AABBBCC A
//        //
//        boolean check = true;
//        char c = '1';
//        while (start < list.size()/2) {
//            Collections.sort(list.subList(start,end+1));
//            if (list.get(start) != list.get(start+1)){
//                if (list.size() % 2 == 0) {
//                    return "I'm Sorry Hansoo";
//                }
//                if (!check) {
//                    return "I'm Sorry Hansoo";
//                }
//                // 홀 수 일 경우 한번 기회 줌
//                c = list.remove(start);
//                check = false;
//                end--;
//                continue;
//            }
//            // 이제 바꿔야 되는 경우
//            Collections.swap(list,start+1,end);
//            start++;
//            end--;
//        }
//
//        if (c != '1'){
//            list.add(list.size()/2,c);
//            // 넣어줘야됨
//        }
//
//        StringBuilder builder = new StringBuilder(list.size());
//        for(Character ch: list)
//        {
//            builder.append(ch);
//        }
//        return builder.toString();
//    }
//
//}

