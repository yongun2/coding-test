import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node>{
        public int cur;
        public int time;

        public Node(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }

        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }

    static int result = Integer.MAX_VALUE;
    static int N, K;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            return;
        }

        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;

        dijkstra();

        System.out.println(time[K]);
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(N, 0));


        int[] dx = {-1, 1, 2};
        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            if (time[cur.cur] < cur.time) {
                continue;
            }

            for (int x : dx) {
                int nx;
                int nTime;
                if (x == 2) {
                    nx = cur.cur * 2;
                    nTime = cur.time;
                } else {
                    nx = cur.cur + x;
                    nTime = cur.time + 1;
                }

                if (inRange(nx) && time[nx] > nTime) {
                    time[nx] = nTime;
                    queue.add(new Node(nx, nTime));
                }


            }
        }
    }

    static boolean inRange(int x) {
        return x >= 0 && x <= 100_000;
    }



}
