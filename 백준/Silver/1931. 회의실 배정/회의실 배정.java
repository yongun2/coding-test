import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[][] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        inputs = new int[N][2];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            inputs[i][0] = start;
            inputs[i][1] = end;
        }

        Arrays.sort(inputs, (a, b) -> {
            int aEnd = a[1];
            int bEnd = b[1];

            if (aEnd == bEnd) {
                return a[0] - b[0];
            }
            return aEnd - bEnd;
        });

        int result = 1;

        int curEnd = inputs[0][1];

        
        for (int i = 1; i < N; ++i) {
            int nextStart = inputs[i][0];
            int nextEnd = inputs[i][1];

            if (nextStart >= curEnd ) {
                curEnd = nextEnd;
                result++;
            }
        }

        System.out.println(result);

    }
}