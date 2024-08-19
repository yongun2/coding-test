import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static long[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        inputs = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N];
        for (int i = 0; i < N; ++i) {
            dp[i] = Long.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i < N; ++i){
            for (int j = 0; j <= i; ++j) {
                long cost = (i - j) * (1 + Math.abs(inputs[i] - inputs[j]));

                dp[i] = Math.min(dp[i], Math.max(dp[j], cost));
            }
        }

        bw.write(String.valueOf(dp[N - 1]));
        bw.flush();
        bw.close();



    }
}