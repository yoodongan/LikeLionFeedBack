package algorithm.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String msg = st.nextToken();
            int X = 0;
            if (msg.equals("push")) {
                stack.push(Integer.valueOf(st.nextToken()));
            } else {
                switch (msg) {
                    case "pop":
                        if(!stack.empty()) sb.append(stack.pop()).append("\n");
                        else sb.append(-1).append("\n");
                        break;
                    case "size":
                        sb.append(stack.size()).append("\n");
                        break;
                    case "empty":
                        if(!stack.isEmpty()) sb.append(0).append("\n");
                        else sb.append(1).append("\n");
                        break;
                    case "top":
                        if(!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                        else sb.append(-1).append("\n");
                        break;
                }
            }

        }
        System.out.println(sb);
    }
}
