package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14501 {

    static int N; // 퇴사까지 남은 일수
    static int ans = Integer.MIN_VALUE; // 최대 이익
    static int[] T , P ; // 상담 시간 정보가 담긴 배열 , 수익에 대한 정보가 담긴 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];

        // T , P 의 배열에 값 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            }

        work(1,0);
        System.out.println(ans);
    }

    public static void work(int days , int reward) { // 상담을 진행하는 함수
        // N+1 인 이유는 배열을 해당 일수와 맞게 하기 위해서 1 부터 시작했기 때문에
        // 퇴사하는 날은 N+1 이다.
        if (days == N+1) { // 퇴사하는 날일 경우
            ans = Math.max(ans , reward);
            return;
            // 리턴 값이 void인 메소드 내에서 return문을 호출할 경우
            // 해당 메서드에서 즉시 빠져나갈 수 있다.
        }

        if ( days > N+1) { // 퇴사일 보다 상담일이 늦어지는 경우
            return;
        }

        work(days + T[days] , reward + P[days]);
        // 상담을 진행하면 해당 일수와 상담에 걸리는 시간을 더하고 ,
        // 수익을 더한다.

        work(++days , reward);
        // 일을 못하는 경우 , 해당 일수만 지나가고 수익은 똑같다.
    }
}
