package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Back9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트 개수

        // 테스트 케이스 만큼 반복
        while (testCase-- > 0) {

            int n = Integer.parseInt(br.readLine());       // n 개의 의상
            HashMap<String,Integer> map = new HashMap<>(); // [옷종류 : 개수]

            // n 개의 의상을 입력받아 종류 별로 HashMap에 저장
            while (n-- > 0){
                // 입력값에서 옷의 종류만 받아옴
                String type = br.readLine().split(" ")[1];

                // 옷의 종류가 이미 있는 경우
                if (map.containsKey(type)) {
                    map.put(type, map.get(type)+1);
                } else {
                    map.put(type, 1);
                }
            }

            // 종류마다 옷은 하나만 입을 수 있다. (옷이 중복되는 경우는 존재하지 않음)
            // 경우의 수:  하나를 입는 경우 + 하나도 입지 않는 경우
            int result = 1;
            for (Integer value : map.values()) {
                result = result * (value+1);
            }

            // 결과값에서 옷을 모두 벗은 경우를 빼준다.
            System.out.println(result-1);
        }
    }
}
