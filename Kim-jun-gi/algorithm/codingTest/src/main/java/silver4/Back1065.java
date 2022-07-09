package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수
public class Back1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        if (num < 100) {
            System.out.println(num);
        } else if(num >= 100 && num <= 110) {
            System.out.println(99);
        } else {
            int count = 99;
            for (int i = 110; i <= num; i++) {
                if(((i%10) - (i/10)%10) == ((i/10)%10 - (i/100)%10)) {
                    count++;
                }
            }
            if (num == 1000) {
                count--;
            }
            System.out.println(count);

        }
    }
}
