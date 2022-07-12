package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//소수
public class Back2581 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            if(solution(i)){
                sum+=i;
                a.add(i);
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(a.get(0));
        }
    }
    public static boolean solution(int n){
        if(n==1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }
}
