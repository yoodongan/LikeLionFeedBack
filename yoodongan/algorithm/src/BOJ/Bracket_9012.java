package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while (t-- > 0) {
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char bracket = str.charAt(i);
                if(bracket == '(') {
                    stack.push(bracket);
                } else{
                    if (stack.size() == 0) {
                        stack.push(bracket); // 아무것도 없는데 ')' 들어온 경우.
                        break;
                    } else {
                        stack.pop();  // ')' 가 왔으므로, '('를 pop으로 빼준다.
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
        }

    }
}
