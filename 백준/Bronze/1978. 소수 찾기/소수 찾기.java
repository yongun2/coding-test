import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());
            if (isPrime(val)) {
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(int val) {

        if (val == 1) return false;

        for (int i = 2; i < val; ++i) {
            if (val % i == 0) {
                return false;
            }
        }

        return true;
    }
}