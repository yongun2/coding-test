import java.io.*;
import java.util.*;

class Main {

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        points.sort((p1, p2) -> {
            if (p1.y > p2.y) {
                return 1;
            } else if (p1.y == p2.y) {
                return Integer.compare(p1.x, p2.x);
            } else {
                return -1;
            }
        });

        for (Point point : points) {
            bw.write(point.x + " " + point.y + "\n");
        }
        bw.flush();
        bw.close();
    }
}