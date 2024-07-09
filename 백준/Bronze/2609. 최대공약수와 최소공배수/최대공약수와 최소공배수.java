import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = 0;


        int target = Math.min(a, b);
        for (int i = 1; i <= target; ++i) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        bw.write(result + "\n");
        bw.write(String.valueOf(result * (a / result) * (b / result)));
        bw.flush();
        bw.close();


    }
}