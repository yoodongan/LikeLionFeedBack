package silver5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 소수 구하기
public class Back1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if (n==1) continue;
            if(solution(n)) count++;
        }
        System.out.println(count);
    }
    public static boolean solution(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

}
