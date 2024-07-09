import java.io.*;
import java.util.*;

class Main {

    private static int N;

    private static int[] inputs;

    private static int T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        inputs = new int[6];
        for (int i = 0; i < 6; ++i) {
            int val = Integer.parseInt(st.nextToken());
            inputs[i] = val;
        }

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int shirts = 0;
        for (int i = 0; i < 6; i++) {
            shirts += (int) (Math.ceil((double) inputs[i] / T));
        }

        bw.write(shirts + "\n");
        bw.write(N / P + " " + N % P);
        bw.flush();
        bw.close();
    }
}