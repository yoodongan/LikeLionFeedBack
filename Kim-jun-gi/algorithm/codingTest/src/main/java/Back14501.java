import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퇴사 실패
public class Back14501 {
    public static int[] time;
    public static int[] money;
    public static int maxMoney = 0;
    public static int[] temp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        time = new int[N];
        money = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }



//        System.out.println(check(N-1,N-1,0));
        System.out.println(maxMoney);

    }


}
