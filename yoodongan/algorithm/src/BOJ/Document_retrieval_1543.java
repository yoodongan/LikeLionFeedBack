package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Document_retrieval_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        for (int i = 0; i < document.length() - word.length() + 1; i++) {  // ababaabce -> aba찾을 때, 9-3 + 1 인덱스까지만 찾으면 된다.
            if(document.substring(i, (i+word.length())).equals(word)){      // 만약 document에 word를 찾았다면,
                i += word.length()-1;      // 중복되면 안되므로 word 길이만큼 건너띕니다.
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}