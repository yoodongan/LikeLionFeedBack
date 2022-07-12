package BOJ;// Dynamic Programming 풀이. 2차원 배열 사용 안함.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resignation_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];  // 

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i > 0; i--) {   // 최대값을 알려면, 결국 뒤에서부터 찾아가야 알 수 있다.
            if ( i + t[i] > n + 1 ) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i + t[i]] + p[i]);  // 최대값 저장. -> i 날 상담을 하지 않은 경우, i 날 상담을 한 경우 중 최대값을 저장한다.
            }
        }
        System.out.println(dp[1]);   // 1에 저장된게 최대값이다.
    }
}