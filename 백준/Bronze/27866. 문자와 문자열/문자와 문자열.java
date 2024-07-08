import java.io.*;
import java.util.*;

class Main {

    private static String S;
    private static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        S = br.readLine();
        I = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(S.charAt(I - 1)));
        bw.flush();
        bw.close();
    }
}