import java.io.*;
import java.util.*;

class Main {

    static int N, X;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        inputs = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }


        int max = 0;
        int sum = 0;
        for (int i = 0; i < X; ++i) {
            sum += inputs[i];
        }

        max = sum;
        int result = 1;
        for (int i = X; i < N; ++i) {
            sum = sum - inputs[i - X] + inputs[i];
            if (sum == max) {
                result++;
            } else if (sum > max) {
                result = 1;
                max = sum;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(result);
        }

    }
}
