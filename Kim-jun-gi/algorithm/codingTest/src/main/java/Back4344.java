import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//평균은 넘겠지
public class Back4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int count = Integer.parseInt(line[0]);
            int sum = 0;
            for (int j = 1; j < count+1; j++) {
                sum +=Integer.parseInt(line[j]);
            }
            sum = sum / count;
            int high = 0;
            for (int j = 1; j < count+1; j++) {
                if( sum < Integer.parseInt(line[j])) {
                    high++;
                }
            }

            float result = (high / (float)count) * 100;
            System.out.println(String.format("%.3f", result)+"%"); //결과 : 3.14
        }

    }

}