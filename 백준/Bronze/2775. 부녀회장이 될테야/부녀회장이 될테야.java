import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        final int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for (int i = 0; i < 15; ++i) {
            dp[0][i] = i + 1;
            dp[i][0] = 1;
        }

        for (int i = 1; i < 15; ++i) {
            for (int j = 1; j < 15; ++j) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        for (int t = 0; t < T; ++t) {
            final int K = Integer.parseInt(br.readLine());
            final int N = Integer.parseInt(br.readLine()) - 1;
            bw.write(dp[K][N] + "\n");
        }
        bw.flush();
        bw.close();

    }
}