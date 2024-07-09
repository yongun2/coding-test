import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    private static final int R = 31;
    private static final long M = 1234567891;
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

    private static BigInteger hash(String str) {
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < str.length(); ++i) {
            sum = sum.add(BigInteger.valueOf(str.charAt(i) - 96).multiply(BigInteger.valueOf(R).pow(i)));
        }
        return sum.remainder(BigInteger.valueOf(M));
    }
}