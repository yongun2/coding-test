import java.io.*;
import java.util.*;

class Main {

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;

        int[][] dp1, dp2;

        if (K == -1) {
            dp1 = new int[N][M];

            search(dp1);

            System.out.println(dp1[N - 1][M - 1]);
            return;
        }

        int posX = K % M;
        int posY = K / M;

        dp1 = new int[posY + 1][posX + 1];
        dp2 = new int[N - posY][M - posX];
        search(dp1);
        search(dp2);

        System.out.println(dp1[posY][posX] * dp2[N - posY - 1][M - posX - 1]);
    }

    static void search(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            grid[i][0] = 1;
        }

        Arrays.fill(grid[0], 1);

        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[i].length; ++j) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
    }

}
