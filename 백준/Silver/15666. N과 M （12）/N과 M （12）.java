import java.io.*;
import java.util.*;

class Main {

    private static int N, M;

    private static int[] inputs;
    private static int[] sequence;

    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(inputs);
        backtracking(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int i = 0; i < inputs.length; ++i) {
            if (depth > 0 && inputs[i] < sequence[depth-1]) continue;

            sequence[depth] = inputs[i];
            backtracking(depth+1);
        }
    }

    private static void print() {
        StringBuilder cur = new StringBuilder();
        for (int num : sequence) {
            cur.append(num).append(" ");
        }

        if (!set.contains(cur.toString())) {
            set.add(cur.toString());
            sb.append(cur);
            sb.append("\n");
        }
    }
}
