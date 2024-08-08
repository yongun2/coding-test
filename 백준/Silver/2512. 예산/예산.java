import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] inputs;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        inputs = new int[N];

        st = new StringTokenizer(br.readLine(), " ");


        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());
            inputs[i] = val;

            maxVal = Math.max(maxVal, val);

        }

        M = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int num : inputs) {
            sum += num;
        }

        if (sum <= M) {
            for (int num : inputs) {
                if (num >= result) {
                    result = num;
                }
            }
        } else {
            binarySearch(1, maxVal);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    private static void binarySearch(int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;

            int total = 0;
            for (int money : inputs) {
                if (money <= mid) {
                    total += money;
                } else {
                    total += mid;
                }
            }

            if (total > M) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
    }
}
