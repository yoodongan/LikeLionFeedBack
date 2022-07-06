package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1543 {
    public static int countTarget(String str, String target) {
        if (!str.contains(target)) return 0;
        int cnt = 0;
        for (int i = 0; i < str.length(); i += target.length()) {
            if (str.substring(i).startsWith(target)) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        String target = br.readLine();
        System.out.println(countTarget(testCase, target));
    }
}
