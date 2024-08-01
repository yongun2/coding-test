import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15651
 * N과 M (3)
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 */
class Main {

    private static int N, M;
    private static int[] sequence;

    private static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];


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

        for (int i = 1; i <= N; ++i) {
            sequence[depth] = i;
            backtracking(depth + 1);
        }
    }

    private static void print() {
        for (int num : sequence) {
            sb.append(num)
                    .append(" ");
        }
        sb.append("\n");
    }
}
