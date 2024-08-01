import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private static int N, M;
    private static int[] sequence;
    private static boolean[] used;


    public static void main(String[] args) throws IOException {


        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        used = new boolean[N + 1];

        backtrack(0);
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            printSequence();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                sequence[depth] = i;
                used[i] = true;
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
    public static void printSequence() {
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}