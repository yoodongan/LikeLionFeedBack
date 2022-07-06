package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자의 개수
public class Back2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        // 문자를 String으로 변환
        String number = Integer.toString(A*B*C);

        // 배열인덱스가 문자면 오류남.
        for (int i = 0; i < number.length(); i++) {
            count[Character.getNumericValue(number.charAt(i))]++;
        }
        for (int i : count) {
            System.out.println(i);
        }



    }
}
