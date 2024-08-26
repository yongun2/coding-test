import java.io.*;
import java.util.*;

class Main {

    private static int N, S, M;
    private static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                // 현재 곡 연주 가능
                if (dp[i][j]) {
                    // 볼륨 높인 경우
                    if (j + V[i] <= M) {
                        dp[i + 1][j + V[i]] = true;
                    }
                    // 볼륨 줄인 경우
                    if (j - V[i] >= 0) {
                        dp[i + 1][j - V[i]] = true;
                    }
                }
            }
        }

        int result = -1;
        for (int j = 0; j <= M; ++j) {
            if (dp[N][j]) {
                result = Math.max(result, j);
            }
        }
        System.out.println(result);
    }
}
