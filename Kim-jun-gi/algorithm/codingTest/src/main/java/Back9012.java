import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호
public class Back9012 {
    public static Stack<Character> stack = new Stack<>();  // 스택 사용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // N개의 테스트 데이터

        // 한 문장씩 괄호 여부 체크
        for (int i = 0; i < N; i++) {
            String bracket = br.readLine();
            String result = checkVPS(bracket);
            System.out.println(result);                 // 결과 출력
            stack.clear();                              // 스택 초기화
        }
    }

    public static String checkVPS(String bracket) {
        // 괄호 여부를 체크해 주는 함수.
        // 오류의 경우 1. '('가 없는데 ')'가 있는 경우 ex) "))" , "()))"
        //             2. '('가 ')'보다 더 많은 경우   ex) "(() , "((("

        for (int j = 0; j < bracket.length(); j++) {
            if (bracket.charAt(j) == ')') {
                // 오류 1번의 경우
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            } else if (bracket.charAt(j) == '(') {
                stack.push(bracket.charAt(j));
            }
        }

        // 오류 2번의 경우
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
