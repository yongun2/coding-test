import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        if (M == 0) {
            bw.write("0");
            bw.flush();
            bw.close();    
            return;
        }

        dfs(1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int cur) {
        if (visited.contains(cur)) {
            return;
        }

        visited.add(cur);
        if (cur != 1) {
            result++;
        }


        for (Integer neighbor : graph.get(cur)) {
            dfs(neighbor);
        }

    }
}