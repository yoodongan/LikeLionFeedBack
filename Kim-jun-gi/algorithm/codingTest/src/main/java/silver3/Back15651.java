package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//N과 M(3)
// 중복허용 순서없음
public class Back15651 {
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
            solution(i,len+1,k+i+" ");
        }
    }
}

    // 1차 배열로 조건 만족 시에 출력
    // -> 시간 초과
    // -> 이유 : System.out.print 를 많이 쓰면 시간 초과라는 ...

    // 그래서 StringBuffer로 출력문을 더해준 뒤 한 꺼번에 출력함

    //2 차 시도 코드 성공
//    public static void solution(int n, int len) {
//        if(len > M){
//            int a =sb.lastIndexOf("\n");
//            if (a == -1) {
//                sb.append("\n"+sb);
//            }else {
//                sb.append("\n"+sb.substring(a+1));
//            }
//            return;
//        }
//        for (int i = 1; i <= N; i++) {
//            sb.append(i+" ");
//            solution(i,len+1);
//            if ( sb.charAt(sb.length()-1) == ' ' ){
//                sb.deleteCharAt(sb.length()-1);
//            }
//            sb.deleteCharAt(sb.length()-1);
//
//        }
//
//    }


// 1차 시도 실패
//public class Back15651 {
//    static int N;
//    static int M;
//    static ArrayList<Integer> arr = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        N = Integer.parseInt(str[0]);
//        M = Integer.parseInt(str[1]);
//        solution(1, 1);
//    }
//
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
//            arr.add(i);
//            solution(i,len+1);
//            arr.remove(arr.size()-1);
//        }
//
//    }
//}

// N, M
//
// 1~ N까지 중복선택이 가능하게 M 개를 골라서 만들 수 있는 수열




