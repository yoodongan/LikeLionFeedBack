import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class numberBaseball_2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BaseballData> baseballInput = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BaseballData baseballData = new BaseballData(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            baseballInput.add(baseballData);   // ArrayList 에 baseballData 객체를 집어넣는다.

        }
        System.out.println(playGame(baseballInput));

    }
    static int playGame(List<BaseballData> baseballInput) {
        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            if (checkSameAndZero(i)) {
                continue;
            }
            int passOneCase = 0;
            for (BaseballData eachGame : baseballInput) {  // eachGame 은 baseballInput 에 저장한 객체 하나.
                String src = eachGame.number;
                String target = Integer.toString(i);

                int strike = countStrike(src, target);
                int ball = countBall(src, target);

                if (eachGame.strike == strike && eachGame.ball == ball) {
                    passOneCase++;
                } else{
                    break;
                }
            }
            if (passOneCase == baseballInput.size()) {   // 만약 주어진 입력 테스트를 모두 통과한다면, answer에 1 더한다.
                answer++;
            }
        }
        return answer;
    }

    static int countStrike(String src, String target) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (src.charAt(i) == target.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }
    static int countBall(String src, String target) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (src.charAt(i) == target.charAt(j)) {
                    if (i != j) {
                        ball++;
                    }
                }
            }
        }
        return ball;
    }
    static boolean checkSameAndZero(int number) {
        String strNum = Integer.toString(number);
        Set<Character> charNum = new HashSet<>();     // HashSet 에 추가하면, 중복되는 숫자를 허용하지 않는다.
        for (int i = 0; i < strNum.length(); i++) {
            charNum.add(strNum.charAt(i));
        }
        return charNum.contains('0') || charNum.size() != 3;   // 0 이 있거나, 중복되는 숫자가 있는 경우를 말한다.
    }

    static class BaseballData {
        String number;
        int strike;
        int ball;

        BaseballData(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }


}

