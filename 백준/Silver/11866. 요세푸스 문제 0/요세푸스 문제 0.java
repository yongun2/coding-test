import java.io.*;
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

        List<Integer> circle = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            circle.add(i);
        }
        int index = K - 1;
        while (!circle.isEmpty()) {
            result.add(circle.remove(index--));

            if (!circle.isEmpty()) {
                index = (index + K) % circle.size();
            }
        }

        bw.write("<");
        for (int i = 0; i < result.size(); ++i) {
            bw.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();

    }
}