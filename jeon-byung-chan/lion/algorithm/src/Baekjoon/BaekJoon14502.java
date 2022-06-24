package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14502 { // 구현 골드5 연구소

    //static 영역에 올릴 변수들 선언
    static int[][] lab; // 기둥이 세워진 연구실
    static int[][] map; // 초기 상태를 가지고 있는 2차원 배열
    static int[][] labVirus; // 기둥이 세워진 연구실 복제
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1, 0, -1, 0};
    static int n , m;
    static int answer = Integer.MIN_VALUE;
    static Queue<virus> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = lab = new int[n][m];
        labVirus = new int[n][m];
        q = new LinkedList<>();

        // 연구실 바이러스 퍼지기 전
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //벽 세우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0){ // 바이러스와 벽이 아니면
                    //해당 좌표를 1로 바꾸고 벽을 세운다.
                    lab[i][j] = 1;
                    buildWall(1);
                    lab[i][j] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    public static void buildWall(int wall){
        if (wall == 3){ //세울 수 있는 가능한 벽의 갯수의 최대치
            build(); // --> 안전 영역의 크기를 구해오는것.
            spreadBFS();
            answer = count();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0){
                    lab[i][j] = 1;
                    buildWall(wall+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static void build() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                labVirus[i][j] = lab[i][j];
                if(labVirus[i][j] ==2) {
                    q.offer(new virus(i,j));
                }
            }
        }
    }

    public static void spreadBFS() {
        //BFS
        while(!q.isEmpty()){
            virus loc = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                if (nx >= 0 && nx < n && ny >=0 && ny < m ){
                    if (labVirus[nx][ny] == 0){
                        labVirus[nx][ny] = 2;
                        q.offer(new virus(nx,ny));
                    }
                }
            }
        }
    }

    public static int count(){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(labVirus[i][j] == 0){
                    count++;
                }
            }
        }
        return Math.max(answer,count);
    }
}

class virus{
    int x;
    int y;

    public virus(int x , int y){
        this.x = x;
        this.y = y;
    }
}
