package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// N과 M(1)
// 중복없음 순서 없음
public class Back15649 {
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
        if(len > M){
            sb.append(k+"\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(k.indexOf(Integer.toString(i)) == -1){
                solution(i+1,len+1,k+i+" ");
            }
        }
    }
}


// 1차 시도 통과, arr 이용 시간이 매우 많이 걸린다.
//public class Back15649 {
//    static int N;
//    static int M;
//    static ArrayList<Integer> arr = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        N = Integer.parseInt(str[0]);
//        M = Integer.parseInt(str[1]);
//        solution(1, 1);
//
//    }
//    public static void solution(int n, int len) {
//        if(len > M){
//            for (int i = 0; i < arr.size(); i++) {
//                if (i == arr.size()-1){
//                    System.out.println(arr.get(i));
//                    return;
//                }
//                System.out.print(arr.get(i)+" ");
//            }
//        }
//        for (int i = 1; i <= N; i++) {
//            if (arr.indexOf(i) == -1){
//                arr.add(i);
//                solution(i+1,len+1);
//                arr.remove(arr.size()-1);
//            }
//        }
//    }
//}