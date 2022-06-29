
//프로그래머스 - 숫자 문자열과 영단어
public class ProgrammersNumericString {
    public static void main(String[] args) throws Exception {

    }
    public int solution(String s) {
        String[] alp = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(alp[i],Integer.toString(i));

        }
        return Integer.parseInt(s);
    }



}
