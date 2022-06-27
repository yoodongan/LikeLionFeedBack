import java.io.BufferedReader;
import java.io.InputStreamReader;

//알고리즘 수업 - 피보나치 수 1
public class Back24416 {
    public static int count1 = 0;
    public static int count2 = 0;
    public static int[] memory;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memory = new int[n+1];
        fib(n);
        fibonacci(n);
        System.out.println(count1+" "+count2);

        /*
        다른 풀이,
        재귀는 결국 n번째 피보나치수열을 구하기 위해서 n번째 수 만큼 반복해야됨
        동적 방법은 n-2번
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n] + " " + (n - 2));
        */
    }

    public static int fib(int n){
        if (n == 1 || n ==2){
            count1++;
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int fibonacci(int n) {
        memory[1] = 1;
        memory[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++;
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }
}
