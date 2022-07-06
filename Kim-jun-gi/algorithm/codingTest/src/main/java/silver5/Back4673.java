package silver5;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//셀프넘버
public class Back4673 {

    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        number = new int[10000];
        for (int i = 1; i < 10000; i++) {
            if (number[i] == 0) {
                bw.write(i+"\n");
                solution(i);
            }
        }
        bw.close();
    }
    public static void solution(int num) {
        while(num < 10000) {
            char[] c = String.valueOf(num).toCharArray();

            for (char c1 : c) {
                num +=Character.getNumericValue(c1);
            }
            if (num >= 10000) {
                break;
            }
            if (number[num] == 1) {
                break;
            }
            number[num] = 1;
        }
    }
}
