import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        int a, b, c;
        int[] inputs = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 3; ++i) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(inputs);

            a = inputs[0];
            b = inputs[1];
            c = inputs[2];

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            boolean result = (c * c) == a * a + b * b;
            if (result) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }

        bw.flush();
        bw.close();

    }
}