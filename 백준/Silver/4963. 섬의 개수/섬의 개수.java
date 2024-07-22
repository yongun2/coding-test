import java.io.*;
import java.util.*;

class Main {

    private static int W, H;
    private static int[][] grid;

    private static boolean[][] visited;

    private static int result = 0;

    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        while(true) {
            result = 0;
            st = new StringTokenizer(br.readLine(), " ");

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            grid = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; ++j) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < H; ++i) {
                for (int j = 0; j < W; ++j) {
                    if (dfs(j, i)) {
                        result++;
                    }
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean dfs(int x, int y) {
        if (!canGo(x, y)) {
            return false;
        }

        visited[y][x] = true;

        for (int i = 0; i < 8; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
        return true;
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[y][x] && grid[y][x] == 1;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}