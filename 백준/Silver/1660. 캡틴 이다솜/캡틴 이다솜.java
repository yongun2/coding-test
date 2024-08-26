import java.io.*;
import java.util.*;

class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        int[] triangles = new int[300000];
        triangles[0] = 1;
        for (int i = 1; i < triangles.length; ++i) {
            triangles[i] += triangles[i - 1] + (i + 1);
        }
        int[] tetrahedron = new int[300000];
        tetrahedron[0] = 1;
        for (int i = 1; i < tetrahedron.length; ++i) {
            tetrahedron[i] += tetrahedron[i - 1] + triangles[i];
        }


        int[] dp = new int[N + 1];
        for (int j = 1; j <= N; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        for (int tetra : tetrahedron) {
            if (tetra > N) break;
            for (int j = tetra; j <= N; j++) {
                if (dp[j - tetra] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - tetra] + 1);
                }
            }
        }

        System.out.print(dp[N]);
    }
}