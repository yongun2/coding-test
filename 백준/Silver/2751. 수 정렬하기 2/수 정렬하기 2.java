import java.io.*;
import java.util.*;

class Main {

    public static int N;
    private static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs);

        for (int input : inputs) {
            bw.write(input + "\n");
        }
        bw.flush();
        bw.close();
    }
}