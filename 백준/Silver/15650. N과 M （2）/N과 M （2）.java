import java.io.*;
import java.util.*;

/**
 * N과 M (2)
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * - 고른 수열은 오름차순이어야 한다.
 */
class Main {

    private static int N, M;

    private static boolean[] used;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N + 1];
        sequence = new int[M];

        backtracking(0);
    }

    private static void backtracking(int depth) {

        if (depth == M) {
            printSequence();
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (!used[i]) {
                if (depth == 0) {
                    used[i] = true;
                    sequence[depth] = i;
                    backtracking(depth + 1);
                    used[i] = false;

                } else {
                    if (i > sequence[depth - 1]) {
                        used[i] = true;
                        sequence[depth] = i;
                        backtracking(depth + 1);
                        used[i] = false;
                    }
                }
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
