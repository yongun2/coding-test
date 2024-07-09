import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] inputs;

    private static List<Integer> lookup = new ArrayList<>();

    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            int k1 = inputs[i];
            for (int j = i + 1; j < N; ++j) {
                int k2 = inputs[j];
                for (int k = j + 1; k < N; ++k) {
                    int k3 = inputs[k];
                    if (k1 + k2 + k3 <= M) {
                        result = Math.max(result, k1 + k2 + k3);
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        


    }




}