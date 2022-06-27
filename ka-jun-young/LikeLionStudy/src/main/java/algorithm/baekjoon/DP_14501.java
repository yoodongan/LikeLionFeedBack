package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_14501 {
    /*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
    */
    public static void main(String[] args) throws IOException {
        // N (1 ≤ N ≤ 15)
        // (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] T = new int[N+10];    // i일에 진행하는 상담이 총 몇일 걸리는지 저장
        int[] P = new int[N+10];    // i일에 진행하는 상담에 대한 수입 저장
        int[] dp = new int[N+10];   // i일에 수입은 얼마인지 비교해서 저장

        // 입력한 값들을 T와 P에 저장
        for (int day = 1; day <= N; day++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[day] = Integer.parseInt(st.nextToken());
            P[day] = Integer.parseInt(st.nextToken());
        }
        /* for문 시나리오(입/출력 예시 1번 기준)
        * day에 상담을 진행하면 dp[T[day] + day]에 다음 상담을 진행해 수익을 낼 수 있다.
        * day = 1
        * # dp[1]에는 0(dp[day]) VS 0(max) 중에 큰 수가 저장된다.
        * # dp[T[1] + 1] -> dp[4](4일차)에 다음 수익을 낼 수 있다.
        * # 4일차의 수익 = 1 VS 2 중 큰 돈으로 저장된다.
        * ## 1. 1일차에 상담이 가능할 때  : P[1] + dp[1] -> 1일차 상담 페이 + 1일째 수익 -> 10원
        * ## 2. 1일차에 상담이 불가능할 때 : dp[T[1] + 1] -> 4일차에 일한(할) 돈 -> 0원
        * # max d[1](0원) VS max(0원) 중에 큰 수가 들어간다.
        * day = 2
        * # dp[2]에는 0 VS 0 중에 큰 수가 저장된다.
        * # dp[T[2] + 2] -> dp[7](7일차)에 다음 수익을 낼 수 있다.
        * # 7일차의 수익 = 1 VS 2 중 큰 돈으로 저장된다.
        * ## 1. 2일차에 상담이 가능할 때  : P[2] + dp[2] -> 2일차 상담 페이 + 2일째 수익 -> 20원
        * ## 2. 2일차에 상담이 불가능할 때 : dp[T[2] + 2] -> 7일차에 일한(할) 돈 -> 0원
        * # max = d[2](0원) VS max(0원) 중에 큰 수가 들어간다.
        * day = 4
        * # dp[4]에는 10 VS 0 중에 큰 수가 저장된다.
        * # dp[T[4] + 4] -> dp[5](5일차)에 다음 수익을 낼 수 있다.
        * # 5일차의 수익 = 1 VS 2 중 큰 돈으로 저장된다.
        * ## 1. 4일차에 상담이 가능할 때  : P[4] + dp[4] -> 4일차 상담 페이(10원) + 4일째 수익(1일차 상담으로 번 돈 10원) -> 10원
        * ## 2. 4일차에 상담이 불가능할 때 : dp[T[4] + 4] -> 5일차에 일한(할) 돈 -> 0원
        * # max = d[4](10원) VS max(0원) 중에 큰 수가 들어간다.
        * */
        for (int day = 1; day <= N+1; day++) {
            dp[day] = Math.max(dp[day], max);
            dp[T[day] + day] = Math.max(dp[T[day] + day], P[day] + dp[day]);
            max = Math.max(dp[day], max);
        }
        System.out.println(max);
    }
}
