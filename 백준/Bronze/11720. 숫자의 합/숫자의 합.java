import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        int sum = 0;
        for (int i = 0; i < input.length(); ++i) {
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}