import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        for (int vertex : graph.keySet()) {
            if (dfs(vertex)) {
                result++;
            }
        }

        bw.write(String.valueOf(result + N - visited.size()));
        bw.flush();
        bw.close();

    }

    private static boolean dfs(int vertex) {

        if (visited.contains(vertex)) {
            return false;
        }
        visited.add(vertex);

        for (int neighbor : graph.get(vertex)) {
            dfs(neighbor);
        }

        return true;

    }



}
