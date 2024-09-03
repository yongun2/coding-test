import java.io.*;
import java.util.*;

class Main {

    static int N, M, K;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int result = 0;
    static int count = 0;

    static int posCircleX, posCircleY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        posCircleX = K % M - 1;
        posCircleY = K / M;

        dfs(0, 0, posCircleX, posCircleY);
        result += count == 0 ? 1 : count;
        count = 0;
        dfs(posCircleX, posCircleY, M - 1, N - 1);
        result *= count;
        System.out.println(result);

    }

    static void dfs(int x, int y, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            count++;
            return;
        }


        for (int i = 0; i < 2; ++i) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (inRange(nx, ny)) {
                dfs(nx, ny, targetX, targetY);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}
