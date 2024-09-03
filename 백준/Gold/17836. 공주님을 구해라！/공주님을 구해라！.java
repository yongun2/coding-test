import java.io.*;
import java.util.*;

class Main {

    static int N, M, T;
    static int[][] grid;

    static class Node {
        public int x;
        public int y;
        public int distance;
        public boolean isGram;

        public Node(int x, int y, int distance, boolean isGram) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isGram = isGram;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                int val = Integer.parseInt(st.nextToken());
                grid[i][j] = val;
            }
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        boolean[][] visitedWithGram = new boolean[N][M];
        queue.add(new Node(0, 0, 0, false));
        visited[0][0] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.distance > T) {
                return -1;
            }

            if (cur.x == M - 1 && cur.y == N - 1) {
                return cur.distance;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (inRange(nx, ny)) {
                    if (cur.isGram) {
                        if (!visitedWithGram[ny][nx]) {
                            queue.add(new Node(nx, ny, cur.distance + 1, cur.isGram));
                            visitedWithGram[ny][nx] = true;
                        }
                    } else {
                        if (!visited[ny][nx]) {
                            if (grid[ny][nx] == 2) {
                                queue.add(new Node(nx, ny, cur.distance + 1, true));
                                visited[ny][nx] = true;
                            } else if (grid[ny][nx] == 0) {
                                queue.add(new Node(nx, ny, cur.distance + 1, cur.isGram));
                                visited[ny][nx] = true;
                            }

                        }
                    }

                }
            }
        }
        return -1;

    }


    static boolean inRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}