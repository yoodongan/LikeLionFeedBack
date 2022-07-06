package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//최댓값
public class Back2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = Integer.parseInt(br.readLine());
        int maxValueIndex = 1;
        for (int i = 2; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > maxValue) {
                maxValueIndex = i;
                maxValue = n;
            }

        }
        System.out.println(maxValue);
        System.out.println(maxValueIndex);
    }
}
