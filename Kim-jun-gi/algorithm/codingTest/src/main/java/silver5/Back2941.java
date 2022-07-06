package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 크로아티아 알파벳
public class Back2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == 'c' && i < len - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (c == 'd' && i < len - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < len - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            } else if ((c == 'l' || c == 'n') && i < len - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if ((c == 's' || c == 'z') && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;

        }
        System.out.println(count);
        /*
            //다른 방법
            //분명 내가 replace 쓸 때는 무슨 조건때문에 안 됐는데 기억이 안 난다.
            Scanner s = new Scanner(System.in);
            String t = s.next();
            System.out.println(t.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "A").length());
        */
    }
}
