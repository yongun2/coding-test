import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] inputs;

    private static int[] select;
    private static boolean[] used;

    private static Set<String> set = new HashSet<>();

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        used = new boolean[N + 1];

        select = new int[M];

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

    private static void backtracking(int dept) {
        if (dept == M) {
            print();
            return;
        }

        for (int i = 0; i < inputs.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                select[dept] = inputs[i];
                backtracking(dept + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        StringBuilder cur = new StringBuilder();
        for (int num : select) {
            cur.append(num).append(" ");
        }

        if (!set.contains(cur.toString())) {
            set.add(cur.toString());
            sb.append(cur);
            sb.append("\n");
        }

    }
}
