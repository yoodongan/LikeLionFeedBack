package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//달팽이는 올라가고 싶다
public class Back2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a= br.readLine().split(" ");
        double A = Integer.parseInt(a[0]);
        double B = Integer.parseInt(a[1]);
        double V = Integer.parseInt(a[2]);
        System.out.println((int)Math.ceil((V-B) / (A-B))) ;
    }
}
