package algorithm.BackJoon;

import java.io.*;
import java.util.StringTokenizer;

public class For_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a + b == 0) {
                break;
            }

            bw.write(a + b + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
