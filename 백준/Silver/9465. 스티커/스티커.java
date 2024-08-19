import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int T, N;
    private static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];

            int[][] dp = new int[2][N];

            for (int j = 0; j < 2; ++j) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; ++k) {
                    // 50 100 150 160 200
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1) {
                bw.write(String.valueOf(Math.max(stickers[0][0], stickers[1][0])));
                bw.write("\n");
                continue;
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            dp[0][1] = stickers[0][1] + stickers[1][0];
            dp[1][1] = stickers[1][1] + stickers[0][0];

            for (int j = 2; j < N ; ++j) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }

            bw.write(String.valueOf(Math.max(dp[0][N - 1], dp[1][N - 1])));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
