import java.io.*;
import java.util.*;

class Main {

    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while (st.hasMoreTokens()) {
            count++;
            st.nextToken();
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}