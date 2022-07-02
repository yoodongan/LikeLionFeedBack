import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 뒤집기
public class Back9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                String s = str[j];
                StringBuilder sb = new StringBuilder(s);
                str[j] = sb.reverse().toString();
            }

            System.out.println(String.join(" ",str));
        }

    }
}
