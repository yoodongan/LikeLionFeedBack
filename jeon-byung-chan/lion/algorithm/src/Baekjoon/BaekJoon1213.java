package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BaekJoon1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팰린드롬 => 거꾸로 읽어도 제대로 읽는 것 ex) 이(리)효리 , 리효리(이)
        // 팰린드롬이 될수 있는 조건
        // 1. 한 문자가 홀수개 or 1개 && 다른 문자들은 짝수개
        // 2. 모든 문자들이 짝수 개
        String word = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i<word.length(); i++) { // 카운트 배열 완성
            char nextWord = word.charAt(i);
            count[nextWord - 65]++;
        } // count[0] ==> 의미는 'A'가 나온 갯수는 count[0]의 값이다. 즉 count[0] = count['A'] 와 같은 의미이다.

        // 홀수개 카운트
        int oddCount = 0;
        for (int i = 0; i<count.length; i++){
            if(count[i] % 2 == 1){
                oddCount++;
            }
        }

        String str = "";
        char temp = '0'; // temp는 쓰레기 값을 넣어서 초기화 시켜놓는다.
        // temp는 팰린드롬의 가운데 기준이 될 문자를 넣을 변수.

        if (oddCount > 1) { // 홀수개 인 문자가 1개 이상이면 조건에 불충족한다.
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i<count.length; i++) {
            if ( count[i] % 2 == 1 && count[i] != 1) { // 홀수지만 1이 아닌 홀수
                int cnt = count[i] / 2;
                for (int j = 0; j<cnt; j++){
                    str += (char) (i+65);
                }
                temp = (char) (i+65);
            } else if( count[i] == 1) { // 1인 경우
                temp = (char) (i+65);
            } else { // 그외의 경우
                int cnt = count[i] / 2;
                for(int j = 0; j<cnt; j++){
                    str += (char) (i+65);
                }
            }
        }

        if (temp == '0') { // 홀수인 갯수가 없었다는 것
            for (int j = str.length()-1; j>=0; j--){
                str += str.charAt(j);
            }
        } else {
            str += temp;
            for (int j = str.length()-2; j>=0; j--){ // temp가 포함된 str 이기 때문에
                // 시작점을 str.length() - 2 로 한다.
                str += str.charAt(j);
            }
        }

        System.out.println(str);

    }
}
