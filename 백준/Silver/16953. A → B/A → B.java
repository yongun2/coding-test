
import java.io.*;
import java.util.*;

class Main {

    private static String A, B;
    private static int result = Integer.MAX_VALUE;

    public static class Op {
        public String value;
        public int depth;

        public Op(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        A = st.nextToken();
        B = st.nextToken();


        bfs(A);

        bw.write(result == Integer.MAX_VALUE ? String.valueOf(-1) : String.valueOf(result + 1));
        bw.flush();
        bw.close();
    }

    private static void bfs(String start) {
        Queue<Op> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Op(start, 0));
        visited.add(start);


        while (!queue.isEmpty()) {
            Op cur = queue.poll();

            String[] neighbors = {String.valueOf(Long.parseLong(cur.value) * 2), cur.value + "1"};
            for (String neighbor : neighbors) {

                if(neighbor.equals(B)) {
                    result = Math.min(result, cur.depth + 1);
                } else {
                    if (!visited.contains(neighbor) && Long.parseLong(cur.value) < Long.parseLong(B)) {
                        visited.add(neighbor);
                        queue.add(new Op(neighbor, cur.depth + 1));
                    }
                }
            }

        }
    }
}