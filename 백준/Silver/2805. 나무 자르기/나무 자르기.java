import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        int[] trees = new int[N];
        long maxHeight = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());
            trees[i] = val;
            if (val > maxHeight) {
                maxHeight = val;
            }
        }

        Arrays.sort(trees);

        long result = binarySearch(trees, maxHeight);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static long binarySearch(int[] tree, long high) {

        long low = 0;
        long result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long treeCount = 0;

            for (int j : tree) {
                if (j > mid) {
                    treeCount += (j - mid);
                }
            }

            if (treeCount >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}