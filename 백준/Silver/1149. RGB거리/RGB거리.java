import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[][] houses;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        houses = new int[N][3];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; ++j) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        for (int i = 0; i < 3; ++i) {
            dp[0][i] = houses[0][i];
        }

        for (int i = 1; i < N; ++i) {
            dp[i][0] = houses[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = houses[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = houses[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = dp[N-1][0];
        for (int i = 1; i < 3; ++i) {
            if (min > dp[N - 1][i]) {
                min = dp[N - 1][i];
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();



    }
}