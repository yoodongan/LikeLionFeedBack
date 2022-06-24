import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1152 {
    public static void main(String[] args) throws IOException {

        // 풀이 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());

        // 풀이 2
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] arrWord = br.readLine().trim().split(" ");
//        // 공백 하나만 입력 받았을 경우 1이 출력된다.
//        if (arrWord[0].isEmpty()) {
//            System.out.println(0);
//        } else {
//            System.out.println(arrWord.length);
//        }
    }
}
