package algorithm.likelion;

import java.util.Arrays;

public class ExStream {
    private static void sol1(String str) {
        String[] sBits = str.split(" ");
        int sum = 0;
        for (String sBit : sBits) {
            if (sBit.matches("\\d+")) {
                sum += Integer.parseInt(sBit);
            }
        }
        System.out.println("sum = " + sum);
    }
    private static void sol2(String str) {
        int sum = Arrays
                .stream(str.split(" "))
                // s["Test", "15", "lqlq", "35", "bad", "99999", "guess", "34"]
                .filter((s) -> s.matches("\\d+")) // 10진수 정수
                // s["15", "35", "99999", "34"]
                .mapToInt(Integer::parseInt)
                // s[15, 35, 99999, 34]
                .sum();
                // 100083

        System.out.println("sum = " + sum);
    }
    public static void main(String[] args) {
        String line = "Test 15 lqlq 35 bad 99999 guess 34";
        sol1(line);
        sol2(line);
    }
}
