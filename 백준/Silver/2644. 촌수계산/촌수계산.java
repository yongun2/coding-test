import java.io.*;
import java.util.*;

class Main {

    private static int N, A, B, CNT;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        CNT = Integer.parseInt(br.readLine());

        for (int i = 0; i < CNT; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(src, new ArrayList<Integer>());
            graph.putIfAbsent(dest, new ArrayList<Integer>());

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        
        dfs(A, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int cur, int depth) {
        if (visited.contains(cur)) {
            return;
        }

        visited.add(cur);

        if (cur == B) {
            result = depth;
        }

        for (Integer i : graph.get(cur)) {
            dfs(i, depth + 1);
        }
    }
}