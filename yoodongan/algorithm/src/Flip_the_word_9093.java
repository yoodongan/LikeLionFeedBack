import java.io.*;
import java.util.Stack;

public class Flip_the_word_9093 {
    static Stack<Character> ch = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 함수에서 사용하기 위해 static 영역에 선언.
    public static void flipWord(String str) throws IOException {
        for (char i : str.toCharArray()) {
            if (i == ' ' || i == '\n') {    // stack을 통해 단어 뒤집을 때, 공백이나 개행문자를 기준으로 뒤집는다.
                while (!ch.isEmpty()) {     // 스택이 비어 있지 않다면 계속 반복.
                    bw.write(ch.pop());    // 뒤에서부터 꺼낸다. (뒤집기)
                }
                bw.write(i);    // 공백이나 개행문자를 출력.
            } else {
                ch.push(i);   // 공백이나 개행문자가 아니라면, 단어의 글자이므로 스택에 계속해서 push 한다.
            }
        }
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {          // t번 반복과 똑같다.
            String str = br.readLine() +"\n";
            flipWord(str);
        }
        bw.close();
    }
}
