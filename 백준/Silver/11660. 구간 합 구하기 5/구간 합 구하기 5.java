import java.io.*;
import java.util.*;

class Main {

    private static int N, CNT;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        CNT = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                prefixSum[i][j] = prefixSum[i - 1][j] +
                        prefixSum[i][j - 1] -
                        prefixSum[i - 1][j - 1] +
                        grid[i][j];


        for (int i = 0; i < CNT; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(
                    prefixSum[x2][y2] - prefixSum[x2][y1 - 1]
                            - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1]
            ));

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
