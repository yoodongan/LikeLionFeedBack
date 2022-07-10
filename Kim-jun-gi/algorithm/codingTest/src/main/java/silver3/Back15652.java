package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M(4)
// 중복 허용/ 오름차순가능
public class Back15652 {
    static int N;
    static int M;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        solution(1, 1,"");
        System.out.println(sb);

    }
    public static void solution(int n, int len, String k) {
        
        if (len > M) {
            sb.append(k+"\n");
            return;
        }
        for (int i = 1; i <= N ; i++) {
            // 이전의 수인 n보다 이후의 수인 i가 같거나 크면 오름차순이 된다.
            if (n <= i){
                solution(i,len+1,k+i+" ");
            }

        }
    }
}
