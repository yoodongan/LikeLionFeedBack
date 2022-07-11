package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon2503 {

    static StringTokenizer st;
    static int N; // 조건의 수
    static int number , strike , ball; // 조건에 해당하는 수 , 스트라이크의 개수 , 볼의 개수
    static List<BallCondition> ballConditions = new ArrayList<>(); // 조건에 해당하는 값들을 저장할 객체를 받는 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());

            BallCondition baseBall = new BallCondition(number , strike , ball);
            ballConditions.add(baseBall); // 조건에 해당하는 값들을 객체로 지정후 리스트에 저장.
        }

        // 정답 개수 변수
        int answer = 0;

        // 조건들을 만족하는 수를 찾자.
        //  123 ~ 987 => 중복이 되면 안되기때문에
        // 중복이 허용되지 않는 수들 중 최소값 123
        // 중복이 허용되지 않는 수들 중 최대값 987
        for (int i = 123; i <= 987; i++) {
            // 0과 중복되는 수 제외
            if (containsZero(i)) continue;  // 0이 포함된 수

            if (duplicateNum(i))continue;  // 중복되는 수

            if( !condition(i) ) continue; // 조건을 만족하지 않는 수

            // 3가지 조건을 모두 피해가는 수는 정답이므로 +1 해준다
            answer++;
        }

        System.out.println(answer);
    }

    private static boolean condition(int n) { // 조건을 만족하는 지 판단하는 메서드

        int pass = 0;

        for (int i = 0; i < N; i++) {
            BallCondition status = ballConditions.get(i);
            String conditionNum = Integer.toString(status.number);
            String nowNum = Integer.toString(n);

            // strike 계산
            int strikeCount = 0;
            for (int j = 0; j < 3; j++) {
                if (conditionNum.charAt(j) == nowNum.charAt(j)) strikeCount++;
            }

            // ball 계산
            int ballCount = 0;
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (conditionNum.charAt(k) == nowNum.charAt(l)) {
                        if (k != l) ballCount++;
                    }
                }
            }

            // 조건에서의 strike 와 ball의 개수가 모두 같다면
            if (status.ball == ballCount && status.strike == strikeCount){
                pass++;
            }
        }
        // 모든 조건들을 통과 하였다면 해당 수는 조건을 충족하는 수이므로 return true
        if (pass == N){
            return true;
        } return false;
    }

    // 중복이 있는지 판단하는 메서드
    private static boolean duplicateNum(int n) {
        String number = Integer.toString(n);
        char hundredDigit = number.charAt(0); // 100의 자리수
        char tensDigit = number.charAt(1); // 10의 자리수
        char numberOfDigit = number.charAt(2); // 1의 자리수

        if (hundredDigit == tensDigit || hundredDigit == numberOfDigit || tensDigit == numberOfDigit) return true;

        return false;
    }

    // 0을 포함한 값인지 판단하는 메서드
    private static boolean containsZero(int n) {
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '0') return true;
        }
        return false;
    }

    // 내부 클래스로 현재 나왔던 숫자야구의 조건들을 저장할 객체
    static class BallCondition{
        int number;
        int strike;
        int ball;

        // 생성자
        BallCondition(int number , int strike , int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
}