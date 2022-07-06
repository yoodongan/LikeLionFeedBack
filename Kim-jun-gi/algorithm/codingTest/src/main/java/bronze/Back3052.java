package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//나머지
public class Back3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rest = new int[42];
        for (int i = 0; i < 10; i++) {
            rest[Integer.parseInt(br.readLine())%42]++;
        }
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (rest[i] >= 1) {
                count++;
            }
        }
        System.out.println(count);
    }
// 다른 풀이 set이용
//    Scanner sc = new Scanner(System.in);
//    HashSet<Integer> h = new HashSet<Integer>();
//
//		for(int i=0;i<10;i++) {
//        h.add(sc.nextInt()%42);
//    }
//		System.out.println(h.size());
}
