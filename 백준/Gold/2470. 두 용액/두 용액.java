import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] inputs;

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

        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Arrays.sort(inputs);

        int pairA = 0;
        int pairB = 0;

        int curSum = 0;
        int zero = Integer.MAX_VALUE;
        while (left < right) {

            curSum = inputs[left] + inputs[right];
            if (Math.abs(curSum) < Math.abs(zero)) {
                zero = curSum;
                pairA = inputs[left];
                pairB = inputs[right];
            }

            if (curSum == 0) {
                break;
            }

            if (curSum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.printf("%d %d\n", pairA, pairB);
    }
}
