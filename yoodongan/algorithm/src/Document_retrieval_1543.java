import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Document_retrieval_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        for (int i = 0; i < document.length() - word.length() + 1; i++) {  // abcdeabce -> abc찾을 때, 9-3 + 1 인덱스까지만 찾으면 된다.
            String check = document.substring(i, (i+word.length()));  // document 에서 찾을 단어를 슬라이싱해 순서대로 찾는다.
            if(check.equals(word)){      // 만약 document에 word를 찾았다면,
                i += word.length();      // 중복되면 안되므로 word 길이만큼 건너띕니다.
                i--;                     // 반복문에 의해 자동으로 i가 1 더해지므로, 1을 빼줍니다.
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}