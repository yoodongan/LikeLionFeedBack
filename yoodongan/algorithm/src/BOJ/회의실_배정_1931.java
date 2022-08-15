package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실_배정_1931 {
    static int[][] arr;

    public static int solution(int n) {
        /*
        1 | 4
        7 | 8
        5 | 8     => 잘못되었다. 시작 시간 기준으로 다시 정렬해야 함.
         */
        // 2차원 배열 정렬.
        Arrays.sort(arr, new Comparator<int[]>() {   // 2차원 배열인 arr를 정렬할 때 사용한다.
            public int compare(int[] t1, int[] t2) {
                if(t1[1] == t2[1])    // 예외상황처리 ). 1번 째 배열(종료시점)을 가리킴, 만약 회의 시작 시간과 종료시간이 같다면,
                    return t1[0] - t2[0];    // 시작 시간 기준으로 정렬 해줘야 한다. (오름차순 정렬)  만약, t2[0] -t1[0] 이면 내림차순 정렬.
                return t1[1] - t2[1];      // 종료시점을 오름차순으로 정렬.
            }
        });

        int cnt = 0;
        int end = 0;    // 종료시간 갱신을 위해 필요하다.

        for(int i = 0 ; i < n ;i++) {
            if(end <= arr[i][0]) {    // 현재 종료시간보다 시작시간이 더 클 때, 회의실을 사용할 수 있다.
                cnt++;
                end = arr[i][1];       // 종료시간은 다음 회의 종료시간에 맞게 계속 갱신시켜준다.
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2]; // arr[ ][0] : 시작시점   arr[ ][1] : 종료시점

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n));

    }
}