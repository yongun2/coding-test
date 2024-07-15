import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] cables = new int[N];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(br.readLine());
            cables[i] = val;
            if (val > maxLength) {
                maxLength = val;
            }
        }

        long low = 1;
        long high = maxLength;
        long result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;
            for (Integer c : cables) {
                cnt += (c / mid);
            }

            if (cnt >= K) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}