import java.io.*;
import java.util.*;

class Main {

    private static final int R = 31;
    private static final int M = 1234567891;
    private static int L;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        L = Integer.parseInt(br.readLine());

        String S = br.readLine();
        bw.write(String.valueOf(hash(S)));
        bw.flush();
        bw.close();
    }

    private static int hash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            sum += (int) ((str.charAt(i) - 96) * Math.pow(R, i));
        }
        return sum % M;
    }
}