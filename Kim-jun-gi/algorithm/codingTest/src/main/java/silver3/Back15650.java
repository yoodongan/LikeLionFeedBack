package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N과 M(2)
// 중복없이 오름차순
public class Back15650 {
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

    public static void solution(int n, int len, String k){
        if (len > M){
            sb.append(k+"\n");
            return;
        }
        // 중복 X 오름차순
        // i+1씩 올려줌, int i도 n부터 시작함
        for (int i = n; i <= N; i++) {
            solution(i+1, len+1,k+i+" ");
        }

    }
}
