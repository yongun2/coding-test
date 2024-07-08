import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = inputs[0];
        int max = inputs[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(inputs[i], dp[i - 1] + inputs[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        


    }
}