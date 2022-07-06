package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//그룹단어체커
public class Back1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (solution(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean solution(String word) {
        HashMap<Character,Boolean> check = new HashMap<>();
        for (int i = 0; i < word.length()-1; i++) {
            if (word.charAt(i) != word.charAt(i+1)){
                if (check.get(word.charAt(i)) == null ){
                    check.put(word.charAt(i),true);
                } else {
                    return false;
                }
            }
        }
        if (check.get(word.charAt(word.length()-1)) != null ){
            return false;
        }
        return true;
    }
    // 다른 방법
    // 문자열을 하나씩 돌면서
    // 현재 문자에 대한 index를 현재 index이후 부터 존재하는지 구한다 -> indexOf
    // 존재하면 false
    //    for(int i=0;i<str.length();i++)
    //    {
    //        int loc = str.indexOf(str.charAt(i),i+1);
    //        if(loc > i+1)
    //        {
    //            return 0;
    //        }
    //    }
    //
    //		return 1;
}
