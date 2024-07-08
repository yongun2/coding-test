import java.io.*;
import java.util.*;

class Main {

    private static int A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        A = Integer.parseInt(br.readLine());
        B  = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(A + B - C) + "\n");
        String s = String.valueOf(A) + String.valueOf(B);
        bw.write(String.valueOf(Integer.parseInt(s) - C));
        bw.flush();
        bw.close();
    }
}