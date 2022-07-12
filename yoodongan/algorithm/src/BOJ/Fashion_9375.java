package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Fashion_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            HashMap<String, Integer> hashMap = new HashMap<>();   // key는 옷의 종류 , value 는 개수.
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();  // 사용하지 않음.
                String key = st.nextToken();

                if (hashMap.containsKey(key)) {
                    hashMap.put(key, hashMap.get(key) + 1);
                } else {
                    hashMap.put(key, 1);
                }
            }
            int result = 1;
            for (int count : hashMap.values()) {
                result *= (count+1);
            }
            System.out.println(result-1);
        }
    }
}
